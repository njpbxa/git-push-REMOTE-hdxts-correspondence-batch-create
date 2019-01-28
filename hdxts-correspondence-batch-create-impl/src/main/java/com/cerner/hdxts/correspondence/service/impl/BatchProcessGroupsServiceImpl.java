package com.cerner.hdxts.correspondence.service.impl;

import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.*;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.cerner.hdxts.correspondence.entities.BatchConfiguration;
import com.cerner.hdxts.correspondence.entities.BatchError;
import com.cerner.hdxts.correspondence.entities.BatchFilename;
import com.cerner.hdxts.correspondence.entities.BatchRequest;
import com.cerner.hdxts.correspondence.entities.BatchTracking;
import com.cerner.hdxts.correspondence.entities.QueueBatchedRequest;
import com.cerner.hdxts.correspondence.entities.common.FlatFile;
import com.cerner.hdxts.correspondence.exception.BatchOutMapException;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.letters.model.CorrespondenceRequestWrapper;
import com.cerner.hdxts.correspondence.service.ITrackingServiceMethods;
import com.cerner.hdxts.correspondence.service.config.BatchConfigRuleGroup;
import com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant;
import com.cerner.hdxts.correspondence.service.mqutils.MQUtils;
import com.cerner.hdxts.correspondence.service.util.BatchNameUtil;
import com.cerner.hdxts.correspondence.service.util.BatchTrackingHelperServicePartner;
import com.cerner.hdxts.correspondence.service.util.FileUtil;
import com.cerner.hdxts.correspondence.statements.model.StatementRequestWrapper;
import com.cerner.hdxts.correspondence.utils.performance.PerformanceLogger;
import com.cerner.hdxts.correspondence.transformation.dto.MapData;
import com.cerner.hdxts.correspondence.transformation.dto.TxTransformationRequest;
import com.cerner.hdxts.correspondence.transformation.dto.TxTransformationResponse;

@Service
public class BatchProcessGroupsServiceImpl
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchProcessGroupsServiceImpl.class);
	
	@Qualifier("marshallerForCernerStandardRequestStatement")
	@Autowired
	private Jaxb2Marshaller marshallerForCernerStandardRequestStatement;

	@Qualifier("marshallerForCernerStandardRequestLetter")
	@Autowired
	private Jaxb2Marshaller marshallerForCernerStandardRequestLetter;

	@Autowired
	private BatchConfigRuleGroup batchConfigRuleGroup;

	@Autowired
	private TransformationRestClient transformationRestClient;

	@Autowired
	@Qualifier("transformationServiceURL")
	private String transformationServiceURL;

	@Autowired
	@Qualifier("batchCreateTempDirLocation")
	private String batchCreateTempDirLocation;

	@Autowired
	@Qualifier("batchCreateStagingDirPath")
	private String stagingDirPath;

	@Autowired
	private FileUtil fileUtil;

	@Autowired
	private BatchErrorHandler batchErrorHandler;

	@Autowired
	private BatchTrackingHelperServicePartner batchTrackingHelperServicePartner;

	@Autowired
	private ITrackingServiceMethods trackingService;

	@Autowired
	private MQUtils mqUtils;
	
	@Autowired
	@Qualifier("mqCorrespondenceOutboundConnectionFactory")
	private QueueConnectionFactory mqCorrespondenceOutboundConnectionFactory;
	
	@Autowired
	@Qualifier("mqCorrespondenceOutboundQueue")
	private Queue mqCorrespondenceOutboundQueue;

	@Async
	public void processBatchRequests(QueueBatchedRequest queueBatchedRequest)
	{
		try
		{
			PerformanceLogger.processStart(CorrespondenceConstant.PERF_PROCESS_BATCH_REQ);
			LOGGER.debug("Inside BatchProcessGroupsServiceImpl.processBatchRequests");
			if (queueBatchedRequest != null)
			{
				Long parentGroupId = queueBatchedRequest.getParentGroupId();
				String serviceType = queueBatchedRequest.getServiceType();
				String partnerAlias = queueBatchedRequest.getPartnerAlias();
				String strParentGroupId = String.valueOf(parentGroupId);
				if ((queueBatchedRequest.getBatchRequests() != null) && (queueBatchedRequest.getBatchRequests().getBatchRequests() != null) && 
						(!queueBatchedRequest.getBatchRequests().getBatchRequests().isEmpty())) 
				{
					List<BatchFilename> batchFilenameList = null;
					for (BatchRequest batchRequest : queueBatchedRequest.getBatchRequests().getBatchRequests())
					{
						try
						{
							PerformanceLogger.processStart(CorrespondenceConstant.PERF_INVOKE_MAP);
							BatchFilename batchFilename = invokeMap(batchRequest, strParentGroupId);

							if(batchFilenameList == null)
							{
								batchFilenameList = new ArrayList<>();
							}
							String filename = batchFilename.getFilename();
							long batchRequestGroupId = batchRequest.getGroupId();
							String trxnType = batchRequest.getTransactionType();
							boolean exists = false;
							for(BatchFilename fileObj : batchFilenameList) 
							{
								String existingFilename = fileObj.getFilename();
								if(filename.equals(existingFilename)) 
								{
									exists = true;
									if(fileObj.getGroupIds() == null)
									{
										fileObj.setGroupIds(new ArrayList<>());
									}
									fileObj.getGroupIds().add(batchRequestGroupId);
									break;
								}
							}
							if(!exists) 
							{
								batchFilename.setGroupIds(new ArrayList<>());
								batchFilename.getGroupIds().add(batchRequestGroupId);
								batchFilename.setTrxnType(trxnType);
								batchFilenameList.add(batchFilename);
							}

							PerformanceLogger.processEnd(CorrespondenceConstant.PERF_INVOKE_MAP);
						}
						catch(BatchOutMapException e)
						{
							PerformanceLogger.processFail(CorrespondenceConstant.PERF_INVOKE_MAP);
							LOGGER.error("BatchOutMapException exception caught, Reason: {}", e.getMessage());
							handelBatchError(batchRequest,e.getMessage(), strParentGroupId, "invokeMap error");
						}
						catch(Exception e)
						{
							PerformanceLogger.processFail(CorrespondenceConstant.PERF_INVOKE_MAP);
							LOGGER.error("Unexpected error occured while making call to invokeMap() method, Reason: {}", e.getMessage());
							handelBatchError(batchRequest,e.getMessage(), strParentGroupId,"invokeMap error");
						}
					}
					LOGGER.debug("Size of the batchFilenameList is: {}",batchFilenameList.size());
					PerformanceLogger.processStart(CorrespondenceConstant.PERF_COPY_FILE);
					copyFile(batchFilenameList, strParentGroupId);
					PerformanceLogger.processEnd(CorrespondenceConstant.PERF_COPY_FILE);
				}
			}
			PerformanceLogger.processEnd(CorrespondenceConstant.PERF_PROCESS_BATCH_REQ);
		}
		catch (Exception e)
		{
			PerformanceLogger.processFail(CorrespondenceConstant.PERF_PROCESS_BATCH_REQ);
			LOGGER.error("Error caught while processing batch request, Reason: {}", e.getMessage());
		}
	}

	private void handelBatchError(BatchRequest batchRequest, String errMessage, String strParentGroupId, String errSource)
	{
		BatchError batchError = new BatchError();
		batchError.setErrorSource(errSource);
		batchError.setGroupID(Long.valueOf(strParentGroupId));
		batchError.setTrxnType(batchRequest.getTransactionType());
		batchError.setFailureString(errMessage);

		batchErrorHandler.handleError(batchError);
	}

	public BatchFilename invokeMap(BatchRequest batchRequest, String strParentGroupId) throws BatchOutMapException
	{
		String strGroupId = batchRequest.getGroupId().toString();
		BatchFilename batchFilename = null;
		BatchConfiguration batchConfiguration = batchConfigRuleGroup.getConfigByBatchRequest(batchRequest);
		TxTransformationRequest txTransformationRequest = new TxTransformationRequest();
		txTransformationRequest.setMapPath(batchConfiguration.getMapLocation());

		String cernerStandardReq = null;
		try
		{
			if (batchRequest.getTransactionType().equals(CORRESPONDENCE_STATEMENTS))
			{
				StatementRequestWrapper wrapper = (StatementRequestWrapper)this.marshallerForCernerStandardRequestStatement.unmarshal(new StringSource(batchRequest.getMessage()));
				LOGGER.debug("Unmarshalled the CERNER_STANDARD_REQUEST for Statements service");

				StringResult srCernerStandardRequest = new StringResult();
				this.marshallerForCernerStandardRequestStatement.marshal(wrapper.getStatementRequest(), srCernerStandardRequest);
				cernerStandardReq = srCernerStandardRequest.toString();
				LOGGER.debug("Marshalled the request. New strinf value is: {}", cernerStandardReq);
			}
			else if (batchRequest.getTransactionType().equals(CORRESPONDENCE_LETTERS))
			{
				/*CorrespondenceRequestWrapper crw = (CorrespondenceRequestWrapper)this.marshallerForCernerStandardRequestLetter.unmarshal(new StringSource(batchRequest.getMessage()));
				LOGGER.debug("Unmarshalled the CERNER_STANDARD_REQUEST for letters service");

				StringResult srCernerStandardRequest = new StringResult();
				this.marshallerForCernerStandardRequestLetter.marshal(crw.getCORRESPONDENCEREQUEST(), srCernerStandardRequest);
				cernerStandardReq = srCernerStandardRequest.toString();
				LOGGER.debug("Marshalled the request. New string value is: {}", cernerStandardReq);*/
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				InputSource is = new InputSource(new StringReader(batchRequest.getMessage()));
				Document document = builder.parse(is);
				document.getDocumentElement().normalize();
				NodeList nList = document.getElementsByTagName(CORRESPONDENCE_REQUEST);
				Node node = nList.item(0);
				Transformer t = TransformerFactory.newInstance().newTransformer();
				t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			    StringWriter sw = new StringWriter();
			    t.transform(new DOMSource(node), new StreamResult(sw));
			    cernerStandardReq = sw.toString(); 
			}


			if ((cernerStandardReq != null) && (!cernerStandardReq.isEmpty()))
			{
				List<MapData> mapInputs = new ArrayList<>();
				MapData mapDataForPayload = new MapData();
				mapDataForPayload.setId(1);
				mapDataForPayload.setBase64Data(Base64.encodeBase64String(cernerStandardReq.getBytes()));

				LOGGER.debug("Base64 encoded payload: {}", mapDataForPayload.getBase64Data());

				MapData mapDataForGroupId = new MapData();
				mapDataForGroupId.setId(2);
				mapDataForGroupId.setBase64Data(Base64.encodeBase64String(String.valueOf(batchRequest.getGroupId()).getBytes()));
				LOGGER.debug("Base64 encoded Group Id: {}", mapDataForGroupId.getBase64Data());

				mapInputs.add(mapDataForPayload);
				mapInputs.add(mapDataForGroupId);

				txTransformationRequest.setMapInputs(mapInputs);
				try
				{
					PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_TRANSFORMATION_RESP);
					TxTransformationResponse txTransformationResponse = this.transformationRestClient.transformMap(txTransformationRequest, this.transformationServiceURL);
					PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_TRANSFORMATION_RESP);
					if (txTransformationResponse != null)
					{
						if ((txTransformationResponse.getMapOutputs() != null) && (!txTransformationResponse.getMapOutputs().isEmpty()))
						{
							for (MapData responseMapData : txTransformationResponse.getMapOutputs())
							{
								LOGGER.debug("Id: {}", Integer.valueOf(responseMapData.getId()));
								String strPartnerRequest = new String(Base64.decodeBase64(responseMapData.getBase64Data()));
								batchFilename = createFlatFile(batchConfiguration, batchRequest, strParentGroupId, strPartnerRequest);
								if(batchFilename != null)
								{
									break;
								}
							}
						}
						else
						{
							LOGGER.debug("auditLog: {}", txTransformationResponse.getAuditLog());
							LOGGER.debug("executionWarningCode {}", txTransformationResponse.getExecutionWarningCode());
							LOGGER.debug("executionWarningMessage {}", txTransformationResponse.getExecutionWarningMessage());
						}
					}
					else 
					{
						LOGGER.debug("Received empty or errored response from transformation service");
					}
				}
				catch (Exception e)
				{
					LOGGER.error("Error caught, Reason: {}", e.getMessage());
					throw e;
				}

			}
		}
		catch(Exception e)
		{
			throw new BatchOutMapException("BatchCreate.invokeMap",e.getMessage(), String.valueOf(batchRequest.getGroupId()),batchRequest.getTransactionType(), batchRequest.getMessage());
		}
		return batchFilename;
	}

	public void copyFile(List<BatchFilename> batchFilenameList, String strParentGroupId)
	{
		LOGGER.debug("BatchProcessGroupsServiceImpl.copyFile");
		if(batchFilenameList != null)
		{
			for(BatchFilename batchFilename : batchFilenameList)
			{
				LOGGER.debug("Looping through batchFileName list");
				FlatFile flatFile = new FlatFile();
				flatFile.setDirectoryPath(batchFilename.getDirectory());
				LOGGER.debug("Dir: {}", flatFile.getDirectoryPath());
				flatFile.setFileName(batchFilename.getFilename());
				LOGGER.debug("File Name: {}", flatFile.getFileName());
				String fileContent = "";
				try
				{
					
					fileContent = fileUtil.retrieveFlatFile(flatFile);

					BatchTracking batchTracking = batchTrackingHelperServicePartner.parseFilename(flatFile.getFileName());
					String eventId = null;
					try
					{
						eventId = trackingService.addEventToGroup(strParentGroupId, "BATCH_REQUEST", batchTracking.getType(), "RECEIVED", "Received file for copy while creating batch");
					}
					catch(TrackingException e)
					{
						//Handle the error
						LOGGER.error("Error caught while adding batch request event to group, Reason: {}", e.getMessage());
					}

					List<String> groupIds = new ArrayList<>();
					for(Long groupId : batchFilename.getGroupIds())
					{
						groupIds.add(String.valueOf(groupId));
					}
					trackingService.batchUpdateGroupEvents(groupIds, "SENT", "NONE", "PARTNER_REQUEST","SENT", "Partner request batched");
					trackingService.updateBatchStatistics(eventId, String.valueOf(groupIds.size()) , "");
					trackingService.updateFileLocation(eventId, batchFilename.getDirectory(), batchFilename.getFilename());
					trackingService.updateGroupStatus(Long.valueOf(strParentGroupId), "SENT", "NONE");
					trackingService.addHistoryToEvent(eventId, "SENT_TO_TEST" + batchFilename.getFilename(), "TRANSFORMED");


					String newFilenameWithTempExt = BatchNameUtil.createNewFilenameWithTMPExtension(batchFilename.getFilename(), strParentGroupId);

					FlatFile flatFileStaging = new FlatFile();
					flatFileStaging.setDirectoryPath(stagingDirPath);
					flatFileStaging.setFileName(newFilenameWithTempExt);
					flatFileStaging.setContent(fileContent);
					try
					{
						fileUtil.createFlatFile(flatFileStaging);
					}
					catch(Exception e)
					{
						//handle error gracefully
						LOGGER.error("Error cought while creating flatfile with tem extension");
						throw e;
					}

					String newFileName =  fileUtil.removeTMPExt(flatFileStaging);
					fileUtil.deleteTempFile(flatFile);
					PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_PUT_OUTBUND_MESSAGE);
					mqUtils.send(flatFileStaging.getDirectoryPath() + "," + newFileName, "", mqCorrespondenceOutboundConnectionFactory, mqCorrespondenceOutboundQueue, null);
					PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_PUT_OUTBUND_MESSAGE);
				}
				catch(Exception e)
				{
					LOGGER.error("Error occured while retrieving the Flat file, Reason: {}", e.getMessage());
					BatchError batchError = new BatchError();
					batchError.setErrorSource("BATCH_CREATE_READFILE");
					batchError.setGroupID(Long.valueOf(strParentGroupId));
					batchError.setTrxnType(batchFilename.getTrxnType());
					batchError.setFailureString(e.getMessage());
					batchError.setFileContent(fileContent);
					batchErrorHandler.handleError(batchError);
				}
			}
		}
	}

	public BatchFilename createFlatFile(BatchConfiguration batchConfiguration, BatchRequest batchRequest, String strParentGroupId, String strPartnerRequest) throws BatchOutMapException
	{
		FlatFile flatFile = new FlatFile();
		flatFile.setDirectoryPath(batchCreateTempDirLocation);
		flatFile.setFileContentEncoding("UTF-8");
		flatFile.setCreateFileIfNotExists(true);
		flatFile.setContent(strPartnerRequest);

		String flatFileName = setFileName(batchConfiguration, batchRequest, strParentGroupId);
		flatFile.setFileName(flatFileName);

		try
		{
			fileUtil.appendFlatFile(flatFile);
		}
		catch(Exception e)
		{
			LOGGER.error("Error caught while appending the content to file, Reason: {}", e.getMessage());

			BatchError batchError = new BatchError();
			batchError.setErrorSource("BATCH_OUTBOUND_APPEND");
			batchError.setGroupID(batchRequest.getGroupId());
			batchError.setFileContent(batchRequest.getMessage());
			batchError.setFailureString(e.getMessage());
			batchError.setTrxnType(batchRequest.getTransactionType());
			batchErrorHandler.handleError(batchError);
		}

		BatchFilename batchFilename = new BatchFilename();
		batchFilename.setDirectory(flatFile.getDirectoryPath());
		batchFilename.setFilename(flatFile.getFileName());

		return batchFilename;
	}

	private String setFileName(BatchConfiguration batchConfiguration, BatchRequest batchRequest, String strParentGroupId)
	{
		String fileExtension = batchConfiguration.getFileExtension();
		if(fileExtension == null || fileExtension.trim().length() == 0) 
		{
			String errorMessage = "Missing batchConfig/fileExtension.";
			LOGGER.error(errorMessage);
			//Need to throw error
		}
		String sourceName = batchConfiguration.getSourceName();
		if(sourceName == null || sourceName.trim().length() == 0) 
		{
			String errorMessage = "Missing batchConfig/sourceName.";
			LOGGER.error(errorMessage);
		}
		String typeCDF = batchConfiguration.getBatchTypeCDF();
		if(typeCDF == null || typeCDF.trim().length() == 0) 
		{
			String errorMessage = "Missing batchConfig/typeCDF.";
			LOGGER.error(errorMessage);
		}
		String serviceCDF = batchConfiguration.getServiceCDF();
		if(serviceCDF == null || serviceCDF.trim().length() == 0) {
			String errorMessage = "Missing batchConfig/serviceCDF.";
			LOGGER.error(errorMessage);
		}
		String submitterId = batchRequest.getSubmitterId();
		if(submitterId == null || submitterId.trim().length() == 0) {
			submitterId = "UNKNOWN";
		}

		String batchId = strParentGroupId;
		if(StringUtils.isBlank(batchId)){
			String errorMessage = "Missing batchId.";
			LOGGER.error(errorMessage);
		}

		// added batchId to file name to make it unique for each flow
		String newFilename = submitterId.concat("-").concat(serviceCDF).concat("-").concat(typeCDF).concat("-").concat(batchId).concat("-").concat(sourceName).concat(".").concat(fileExtension);
		LOGGER.debug("New filename [{}]", newFilename);
		return newFilename;
	}
}
