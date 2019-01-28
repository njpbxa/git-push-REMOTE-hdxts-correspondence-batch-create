package com.cerner.hdxts.correspondence.service.impl.test;


import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doAnswer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringSource;
import org.springframework.xml.transform.StringResult;

import com.cerner.hdxts.correspondence.entities.BatchConfiguration;
import com.cerner.hdxts.correspondence.entities.BatchCriteria;
import com.cerner.hdxts.correspondence.entities.BatchRequest;
import com.cerner.hdxts.correspondence.entities.BatchRequests;
import com.cerner.hdxts.correspondence.entities.BatchTracking;
import com.cerner.hdxts.correspondence.entities.QueueBatchedRequest;
import com.cerner.hdxts.correspondence.exception.CorrespondenceServiceException;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.letters.model.CorrespondenceRequestWrapper;
import com.cerner.hdxts.correspondence.service.ITrackingServiceMethods;
import com.cerner.hdxts.correspondence.service.config.BatchConfigRuleGroup;
import com.cerner.hdxts.correspondence.service.impl.BatchErrorHandler;
import com.cerner.hdxts.correspondence.service.impl.BatchProcessGroupsServiceImpl;
import com.cerner.hdxts.correspondence.service.impl.TransformationRestClient;
import com.cerner.hdxts.correspondence.service.mqutils.MQUtils;
import com.cerner.hdxts.correspondence.service.util.BatchTrackingHelperServicePartner;
import com.cerner.hdxts.correspondence.service.util.FileUtil;
import com.cerner.hdxts.correspondence.statements.model.StatementRequestWrapper;
import com.cerner.hdxts.correspondence.transformation.dto.MapData;
import com.cerner.hdxts.correspondence.transformation.dto.TxTransformationResponse;

@RunWith(MockitoJUnitRunner.class)
public class TestBatchProcessGroupsServiceImpl {

	QueueBatchedRequest queueBatchedRequest = new QueueBatchedRequest(); 
	BatchRequests batchRequests = new BatchRequests();
	BatchRequest batchRequestCorrespondenceStatements = new BatchRequest();
	BatchRequest batchRequestCorrespondenceLetters = new BatchRequest();
	BatchConfiguration batchConfiguration = new BatchConfiguration();
	TxTransformationResponse transformationResponse = new TxTransformationResponse();
	MapData mapData = new MapData();
	List<MapData> mapDataList = new ArrayList<>();
	Writer w = new Writer() {
		
		@Override
		public void write(char[] cbuf, int off, int len) throws IOException {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void flush() throws IOException {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void close() throws IOException {
			// TODO Auto-generated method stub
			
		}
	};
	@Mock
	StatementRequestWrapper statementRequestWrapper;
	
	@Mock
	CorrespondenceRequestWrapper correspondenceRequestWrapper;
	
	@Qualifier("marshallerForCernerStandardRequestStatement")
	@Mock
	Jaxb2Marshaller marshallerForCernerStandardRequestStatement;

	@Qualifier("marshallerForCernerStandardRequestLetter")
	@Mock
	Jaxb2Marshaller marshallerForCernerStandardRequestLetter;

	@Mock
	ITrackingServiceMethods trackingService;
	
	@Mock
	MQUtils mqUtils;

	@Mock
	BatchConfigRuleGroup batchConfigRuleGroup;
	
	@Mock
	TransformationRestClient transformationRestClient;
	
	@Mock
	FileUtil fileUtil;
	
	@Mock
	BatchErrorHandler batchErrorHandler;
	
	@Mock
	BatchTrackingHelperServicePartner batchTrackingHelperServicePartner;
	
	@Mock
	BatchTracking batchTracking;
	
	
	@InjectMocks
	BatchProcessGroupsServiceImpl batchProcessGroupsServiceImpl;
	
	
	@Before
	public void SetUp()
	{
		MockitoAnnotations.initMocks(this);
		//setting values for BatchRequest
		batchRequestCorrespondenceStatements.setEventId((long)123);
		batchRequestCorrespondenceStatements.setGroupId((long)2);
		batchRequestCorrespondenceStatements.setMessage("message");
		batchRequestCorrespondenceStatements.setSubmitterId("submitterId");
		batchRequestCorrespondenceStatements.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchRequestCorrespondenceLetters.setEventId((long)1234);
		batchRequestCorrespondenceLetters.setGroupId((long)24);
		batchRequestCorrespondenceLetters.setMessage("message");
		batchRequestCorrespondenceLetters.setSubmitterId("submitterId");
		batchRequestCorrespondenceLetters.setTransactionType("CORRESPONDENCE_LETTERS");
		
		
		List<BatchRequest> batchRequestsList = new ArrayList<>();
		batchRequestsList.add(batchRequestCorrespondenceStatements);
		batchRequestsList.add(batchRequestCorrespondenceLetters);
		//Adding the above BatchRequest to BatchRequests
		batchRequests.setBatchRequests(batchRequestsList);
		
		//Setting values for QueueBatchedRequest
		queueBatchedRequest.setBatchRequests(batchRequests);
		queueBatchedRequest.setParentGroupId((long)1);
		queueBatchedRequest.setPartnerAlias("partnerAlias");
		queueBatchedRequest.setServiceType("serviceType");
		
		
		//Setting values for BatchConfiguration
		batchConfiguration.setMapLocation("MapLocation");
		batchConfiguration.setFileExtension("STA");
		batchConfiguration.setSourceName("BatchCreate");
		batchConfiguration.setBatchTypeCDF("PARTNER_REQUEST");
		batchConfiguration.setServiceCDF("CORRESPONDENCE_STATEMENTS");
		
		//Setting value for MapData to be used in TxTransformationResponse
		mapData.setBase64Data("base64Data");
		mapData.setId(00);
		mapDataList.add(mapData);
		transformationResponse.setMapOutputs(mapDataList);
	}

	@Test
	public void TestProcessBatchRequestsThrowsBatchOutMapException() throws Exception
	{
		
		when(batchConfigRuleGroup.getConfigByBatchRequest(any())).thenReturn(batchConfiguration);
		batchProcessGroupsServiceImpl.processBatchRequests(queueBatchedRequest);
	}

	@Test
	public void TestProcessBatchRequestsWithNoMapOutputs() throws Exception
	{
		
		when(batchConfigRuleGroup.getConfigByBatchRequest(any())).thenReturn(batchConfiguration);
		when((StatementRequestWrapper)marshallerForCernerStandardRequestStatement.unmarshal(new StringSource(anyString()))).thenReturn(statementRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestStatement).marshal(any(), any());
		
		
		when((CorrespondenceRequestWrapper)marshallerForCernerStandardRequestLetter.unmarshal(new StringSource(anyString()))).thenReturn(correspondenceRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestLetter).marshal(any(), any());
		transformationResponse = new TxTransformationResponse();
		when(transformationRestClient.transformMap(any(), anyString())).thenReturn(transformationResponse);
		when(fileUtil.appendFlatFile(any())).thenReturn(true);
		when(trackingService.addEventToGroup(anyString(), anyString(),anyString(),anyString(), anyString())).thenReturn("124");
		doNothing().when(trackingService).batchUpdateGroupEvents(any(), anyString(),anyString(),anyString(),anyString(),anyString());
		when(trackingService.updateBatchStatistics(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateFileLocation(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateGroupStatus(anyLong(),anyString(),anyString())).thenReturn(true);
		when(trackingService.addHistoryToEvent(anyString(),anyString(),anyString())).thenReturn("SAMPLE");
		when(fileUtil.createFlatFile(any())).thenReturn(true);
		when(fileUtil.deleteTempFile(any())).thenReturn(true);
		when(fileUtil.retrieveFlatFile(any())).thenReturn("fileContent");
		when(batchTrackingHelperServicePartner.parseFilename(anyString())).thenReturn(batchTracking);
				doNothing().when(mqUtils).send(anyString(), anyString(),any(), any(),anyLong());
		batchProcessGroupsServiceImpl.processBatchRequests(queueBatchedRequest);
	}

	@Test
	public void TestProcessBatchRequestsWithErrorInTransformMap() throws Exception
	{
		
		when(batchConfigRuleGroup.getConfigByBatchRequest(any())).thenReturn(batchConfiguration);
		when((StatementRequestWrapper)marshallerForCernerStandardRequestStatement.unmarshal(new StringSource(anyString()))).thenReturn(statementRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestStatement).marshal(any(), any());
		
		
		when((CorrespondenceRequestWrapper)marshallerForCernerStandardRequestLetter.unmarshal(new StringSource(anyString()))).thenReturn(correspondenceRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestLetter).marshal(any(), any());
		when(transformationRestClient.transformMap(any(), anyString())).thenThrow(new CorrespondenceServiceException());
		when(fileUtil.appendFlatFile(any())).thenReturn(true);
		when(trackingService.addEventToGroup(anyString(), anyString(),anyString(),anyString(), anyString())).thenReturn("124");
		doNothing().when(trackingService).batchUpdateGroupEvents(any(), anyString(),anyString(),anyString(),anyString(),anyString());
		when(trackingService.updateBatchStatistics(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateFileLocation(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateGroupStatus(anyLong(),anyString(),anyString())).thenReturn(true);
		when(trackingService.addHistoryToEvent(anyString(),anyString(),anyString())).thenReturn("SAMPLE");
		when(fileUtil.createFlatFile(any())).thenReturn(true);
		when(fileUtil.deleteTempFile(any())).thenReturn(true);
		when(fileUtil.retrieveFlatFile(any())).thenReturn("fileContent");
		when(batchTrackingHelperServicePartner.parseFilename(anyString())).thenReturn(batchTracking);
				doNothing().when(mqUtils).send(anyString(), anyString(),any(), any(),anyLong());
		batchProcessGroupsServiceImpl.processBatchRequests(queueBatchedRequest);
	}


	@Test
	public void TestProcessBatchRequestsWithErrorInAppendFile() throws Exception
	{
		
		when(batchConfigRuleGroup.getConfigByBatchRequest(any())).thenReturn(batchConfiguration);
		when((StatementRequestWrapper)marshallerForCernerStandardRequestStatement.unmarshal(new StringSource(anyString()))).thenReturn(statementRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestStatement).marshal(any(), any());
		
		
		when((CorrespondenceRequestWrapper)marshallerForCernerStandardRequestLetter.unmarshal(new StringSource(anyString()))).thenReturn(correspondenceRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestLetter).marshal(any(), any());
		when(transformationRestClient.transformMap(any(), anyString())).thenReturn(transformationResponse);
		when(fileUtil.appendFlatFile(any())).thenThrow(new IOException());
		when(trackingService.addEventToGroup(anyString(), anyString(),anyString(),anyString(), anyString())).thenReturn("124");
		doNothing().when(trackingService).batchUpdateGroupEvents(any(), anyString(),anyString(),anyString(),anyString(),anyString());
		when(trackingService.updateBatchStatistics(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateFileLocation(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateGroupStatus(anyLong(),anyString(),anyString())).thenReturn(true);
		when(trackingService.addHistoryToEvent(anyString(),anyString(),anyString())).thenReturn("SAMPLE");
		when(fileUtil.createFlatFile(any())).thenReturn(true);
		when(fileUtil.deleteTempFile(any())).thenReturn(true);
		when(fileUtil.retrieveFlatFile(any())).thenReturn("fileContent");
		when(batchTrackingHelperServicePartner.parseFilename(anyString())).thenReturn(batchTracking);
				doNothing().when(mqUtils).send(anyString(), anyString(),any(), any(),anyLong());
		batchProcessGroupsServiceImpl.processBatchRequests(queueBatchedRequest);
	}

	
	@Test
	public void TestProcessBatchRequestsWithErrorInSendingToQueue() throws Exception
	{
		
		when(batchConfigRuleGroup.getConfigByBatchRequest(any())).thenReturn(batchConfiguration);
		when((StatementRequestWrapper)marshallerForCernerStandardRequestStatement.unmarshal(new StringSource(anyString()))).thenReturn(statementRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestStatement).marshal(any(), any());
		
		
		when((CorrespondenceRequestWrapper)marshallerForCernerStandardRequestLetter.unmarshal(new StringSource(anyString()))).thenReturn(correspondenceRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestLetter).marshal(any(), any());
		when(transformationRestClient.transformMap(any(), anyString())).thenReturn(transformationResponse);
		when(fileUtil.appendFlatFile(any())).thenReturn(true);
		when(trackingService.addEventToGroup(anyString(), anyString(),anyString(),anyString(), anyString())).thenReturn("124");
		doNothing().when(trackingService).batchUpdateGroupEvents(any(), anyString(),anyString(),anyString(),anyString(),anyString());
		when(trackingService.updateBatchStatistics(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateFileLocation(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateGroupStatus(anyLong(),anyString(),anyString())).thenReturn(true);
		when(trackingService.addHistoryToEvent(anyString(),anyString(),anyString())).thenReturn("SAMPLE");
		when(fileUtil.createFlatFile(any())).thenReturn(true);
		when(fileUtil.deleteTempFile(any())).thenReturn(true);
		when(fileUtil.retrieveFlatFile(any())).thenReturn("fileContent");
		when(batchTrackingHelperServicePartner.parseFilename(anyString())).thenReturn(batchTracking);
		doThrow(new JMSException("Error")).when(mqUtils).send(anyString(), anyString(),any(), any(),anyLong());
		batchProcessGroupsServiceImpl.processBatchRequests(queueBatchedRequest);
	}

	@Test
	public void TestProcessBatchRequestsWithErrorInCreateFile() throws Exception
	{
		
		when(batchConfigRuleGroup.getConfigByBatchRequest(any())).thenReturn(batchConfiguration);
		when((StatementRequestWrapper)marshallerForCernerStandardRequestStatement.unmarshal(new StringSource(anyString()))).thenReturn(statementRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestStatement).marshal(any(), any());
		
		
		when((CorrespondenceRequestWrapper)marshallerForCernerStandardRequestLetter.unmarshal(new StringSource(anyString()))).thenReturn(correspondenceRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestLetter).marshal(any(), any());
		when(transformationRestClient.transformMap(any(), anyString())).thenReturn(transformationResponse);
		when(fileUtil.appendFlatFile(any())).thenReturn(true);
		when(trackingService.addEventToGroup(anyString(), anyString(),anyString(),anyString(), anyString())).thenReturn("124");
		doNothing().when(trackingService).batchUpdateGroupEvents(any(), anyString(),anyString(),anyString(),anyString(),anyString());
		when(trackingService.updateBatchStatistics(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateFileLocation(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateGroupStatus(anyLong(),anyString(),anyString())).thenReturn(true);
		when(trackingService.addHistoryToEvent(anyString(),anyString(),anyString())).thenReturn("SAMPLE");
		when(fileUtil.createFlatFile(any())).thenThrow(new IOException());
		when(fileUtil.deleteTempFile(any())).thenReturn(true);
		when(fileUtil.retrieveFlatFile(any())).thenReturn("fileContent");
		when(batchTrackingHelperServicePartner.parseFilename(anyString())).thenReturn(batchTracking);
				doNothing().when(mqUtils).send(anyString(), anyString(),any(), any(),anyLong());
		batchProcessGroupsServiceImpl.processBatchRequests(queueBatchedRequest);
	}

	@Test
	public void TestProcessBatchRequestsWithTrackingException() throws Exception
	{
		
		when(batchConfigRuleGroup.getConfigByBatchRequest(any())).thenReturn(batchConfiguration);
		when((StatementRequestWrapper)marshallerForCernerStandardRequestStatement.unmarshal(new StringSource(anyString()))).thenReturn(statementRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestStatement).marshal(any(), any());
		
		
		when((CorrespondenceRequestWrapper)marshallerForCernerStandardRequestLetter.unmarshal(new StringSource(anyString()))).thenReturn(correspondenceRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestLetter).marshal(any(), any());
		when(transformationRestClient.transformMap(any(), anyString())).thenReturn(transformationResponse);
		when(fileUtil.appendFlatFile(any())).thenReturn(true);
		when(trackingService.addEventToGroup(anyString(), anyString(),anyString(),anyString(), anyString())).thenThrow(new TrackingException());
		doNothing().when(trackingService).batchUpdateGroupEvents(any(), anyString(),anyString(),anyString(),anyString(),anyString());
		when(trackingService.updateBatchStatistics(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateFileLocation(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateGroupStatus(anyLong(),anyString(),anyString())).thenReturn(true);
		when(trackingService.addHistoryToEvent(anyString(),anyString(),anyString())).thenReturn("SAMPLE");
		when(fileUtil.createFlatFile(any())).thenReturn(true);
		when(fileUtil.deleteTempFile(any())).thenReturn(true);
		when(fileUtil.retrieveFlatFile(any())).thenReturn("fileContent");
		when(batchTrackingHelperServicePartner.parseFilename(anyString())).thenReturn(batchTracking);
				doNothing().when(mqUtils).send(anyString(), anyString(),any(), any(),anyLong());
		batchProcessGroupsServiceImpl.processBatchRequests(queueBatchedRequest);
	}
	
	
	
	@Test
	public void TestProcessBatchRequests() throws Exception
	{
		
		when(batchConfigRuleGroup.getConfigByBatchRequest(any())).thenReturn(batchConfiguration);
		when((StatementRequestWrapper)marshallerForCernerStandardRequestStatement.unmarshal(new StringSource(anyString()))).thenReturn(statementRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestStatement).marshal(any(), any());
		
		
		when((CorrespondenceRequestWrapper)marshallerForCernerStandardRequestLetter.unmarshal(new StringSource(anyString()))).thenReturn(correspondenceRequestWrapper);
		doAnswer(invocation ->{
			Object[] args = invocation.getArguments();
			StringResult s = ((StringResult)args[1]);
			w.write("abcd");
			s.setWriter(w);
			//System.out.println(s.toString());
			return null;
		}).when(marshallerForCernerStandardRequestLetter).marshal(any(), any());
		when(transformationRestClient.transformMap(any(), anyString())).thenReturn(transformationResponse);
		when(fileUtil.appendFlatFile(any())).thenReturn(true);
		when(trackingService.addEventToGroup(anyString(), anyString(),anyString(),anyString(), anyString())).thenReturn("124");
		doNothing().when(trackingService).batchUpdateGroupEvents(any(), anyString(),anyString(),anyString(),anyString(),anyString());
		when(trackingService.updateBatchStatistics(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateFileLocation(anyString(),anyString(),anyString())).thenReturn(true);
		when(trackingService.updateGroupStatus(anyLong(),anyString(),anyString())).thenReturn(true);
		when(trackingService.addHistoryToEvent(anyString(),anyString(),anyString())).thenReturn("SAMPLE");
		when(fileUtil.createFlatFile(any())).thenReturn(true);
		when(fileUtil.deleteTempFile(any())).thenReturn(true);
		when(fileUtil.retrieveFlatFile(any())).thenReturn("fileContent");
		when(batchTrackingHelperServicePartner.parseFilename(anyString())).thenReturn(batchTracking);
				doNothing().when(mqUtils).send(anyString(), anyString(),any(), any(),anyLong());
		batchProcessGroupsServiceImpl.processBatchRequests(queueBatchedRequest);
	}
	
	
	
}
