package com.cerner.hdxts.correspondence.service.impl;

import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.CORRESPONDENCE_LETTERS;
import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.CORRESPONDENCE_REQUEST_BO;
import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.CORRESPONDENCE_STATEMENTS;
import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.PARTNER_QUEUE_ERROR;
import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.QUEUED;
import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.STATEMENTS_REQUEST_BO;
import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.VALIDATED;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import com.cerner.edi.tracking.service.constant.TransactionStatusKey;
import com.cerner.edi.tracking.service.domain.TrackingGroup;
import com.cerner.edi.tracking.service.dto.criteria.TrackingGroupCriteria;
import com.cerner.hdxts.correspondence.entities.BatchCriteria;
import com.cerner.hdxts.correspondence.entities.BatchRequestMessage;
import com.cerner.hdxts.correspondence.entities.ProcessBatch;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.service.IBatchOutService;
import com.cerner.hdxts.correspondence.service.ITrackingServiceMethods;
import com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant;
import com.cerner.hdxts.correspondence.service.mqutils.MQUtils;
import com.cerner.hdxts.correspondence.utils.performance.PerformanceLogger;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BatchOutServiceImpl
implements IBatchOutService
{
	@Qualifier("marshallerForClientRequest")
	@Autowired
	private Jaxb2Marshaller marshallerForClientRequest;

	@Qualifier("marshallerForBatchRequest")
	@Autowired
	private Jaxb2Marshaller marshallerForBatchRequest;

	@Autowired
	@Qualifier("maxResults")
	private Long maxResults;

	@Autowired
	private ITrackingServiceMethods trackingServiceMethods;

	@Autowired
	private MQUtils mqUtils;

	@Qualifier("mqCorrespondenceConnectionFactory")
	@Autowired
	private QueueConnectionFactory mqCorrespondenceConnectionFactory;

	@Qualifier("mqCorrespondenceQueue")
	@Autowired
	private Queue mqCorrespondenceQueue;

	@Qualifier("mqCorrespondenceBatchRequestQueue")
	@Autowired
	private Queue mqCorrespondenceBatchRequestQueue;

	@Qualifier("mqCorrespondenceBatchRequestCF")
	@Autowired
	private QueueConnectionFactory mqCorrespondenceBatchRequestCF;

	@Autowired
	@Qualifier("expirationTime")
	private Long expirationTime;

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchOutServiceImpl.class);

	public void processBatchRequest(String request)
	{
		try
		{
			BatchCriteria batchCriteria = (BatchCriteria)this.marshallerForClientRequest.unmarshal(new StringSource(request));
			if ((batchCriteria.getTransactionType().length() <= 0) || (batchCriteria.getCategory().length() <= 0) || (batchCriteria.getStatus().length() <= 0)) 
			{
				LOGGER.info("Invalid request received");
				return;
			}
			if ((!batchCriteria.getStatus().equals(VALIDATED)) && (!batchCriteria.getStatus().equals(PARTNER_QUEUE_ERROR))) 
			{
				LOGGER.info("Invalid request received");
				return;
			}
			if (batchCriteria.getStatus().equals(PARTNER_QUEUE_ERROR))
			{
				LOGGER.debug("Received batch request for PARTNER_QUEUE_ERROR trxn status");
				processQueueErroredTransactions(batchCriteria);
			}
			else
			{
				LOGGER.debug("Received batch request for VALIDATED trxn status");
				processValidatedTransactions(batchCriteria);
			}
		}
		catch (Exception e)
		{
			LOGGER.error("Error caught in processBatchRequest {} ", e.getMessage());
		}
	}

	public void processQueueErroredTransactions(BatchCriteria batchCriteria)
	{
		TrackingGroupCriteria trackingGroupCriteria = initGroupSearch(batchCriteria);
		List<TrackingGroup> trackingGroups = null;
		try
		{
			if (trackingGroupCriteria != null) 
			{
				trackingGroups = trackingServiceMethods.findGroups(trackingGroupCriteria);
			}
		}
		catch (TrackingException e)
		{
			LOGGER.error("Error caught while find the groups for PARTNER_QUEUE_ERROR, Reason: {}",e.getMessage());
		}
		if ((trackingGroups != null) && (!trackingGroups.isEmpty()))
		{
			LOGGER.debug("Found tracking groups with trxn status as PARTNER_QUEUE_ERROR");
			for (TrackingGroup trackingGroup : trackingGroups)
			{
				try
				{
					LOGGER.debug("Settign transaction status to QUEUED");
					trackingServiceMethods.updateGroupStatus(trackingGroup.getId(), QUEUED, "");
				}
				catch (TrackingException e)
				{
					LOGGER.error("Error occured while changing the status to QUEUED " + e.getMessage());
				}
				LOGGER.debug("Putting message in the queue");
				putMessageInQueue(trackingGroup.getId(), batchCriteria.getTransactionType(), trackingGroup.getPartner().getAlias());
			}
		}
	}

	public void processValidatedTransactions(BatchCriteria batchCriteria)
	{
		Long queueDepth = 0L;
		try
		{
			queueDepth = mqUtils.getQueueDepth(mqCorrespondenceBatchRequestQueue);
			LOGGER.debug("Queue depth is: {}",queueDepth);
		}
		catch(JMSException ex)
		{
			LOGGER.error("Caught JMSException while fetching the queue depth, Reason: {}",ex.getMessage());
			return;
		}

		if(queueDepth == 0L)
		{
			String transactionType = null;
			if (batchCriteria.getTransactionType().equals(STATEMENTS_REQUEST_BO))
			{
				transactionType = CORRESPONDENCE_STATEMENTS;
				batchCriteria.setTransactionType(transactionType);
			}
			else if (batchCriteria.getTransactionType().equals(CORRESPONDENCE_REQUEST_BO))
			{
				transactionType = CORRESPONDENCE_LETTERS;
				batchCriteria.setTransactionType(transactionType);
			}
			else
			{
				transactionType = batchCriteria.getTransactionType();
			}


			PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_FIND_SUBMITTERS);
			List<Long> submitterIds = trackingServiceMethods.findSubmitterList(transactionType);
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_FIND_SUBMITTERS);
			if(submitterIds != null && !submitterIds.isEmpty())
			{
				for(Long submitterId : submitterIds)
				{

					LOGGER.debug("Message for submitter Id {} is ready to be sent to MQ", submitterId);
					BatchRequestMessage messageObj = new BatchRequestMessage();
					messageObj.setSubmitterId(submitterId);
					messageObj.setServiceCategory(batchCriteria.getCategory());
					messageObj.setServiceCode(batchCriteria.getTransactionType());
					messageObj.setTrxnStatus(batchCriteria.getStatus());

					ObjectMapper mapper = new ObjectMapper();
					String message = null;
					try
					{
						message = mapper.writeValueAsString(messageObj);
					}
					catch(Exception e)
					{
						LOGGER.error("Error occured while converting the BatchRequestMessage to json string, Reason: {}", e.getMessage());
					}
					if(message != null)
					{
						try 
						{
							PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_PUT_SUB_IN_QUEUE);
							mqUtils.send(message, "", mqCorrespondenceBatchRequestCF, mqCorrespondenceBatchRequestQueue, expirationTime);
							PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_PUT_SUB_IN_QUEUE);
						} 
						catch (JMSException e)
						{
							PerformanceLogger.serviceFail(CorrespondenceConstant.PERF_PUT_SUB_IN_QUEUE);
							LOGGER.error("Error occured while putting message into the queue, Reason: {}",e.getMessage());
						}
					}
				}
			}
		}
	}

	public void putMessageInQueue(Long parentGroupId, String serviceType, String partnerAlias)
	{
		try
		{
			ProcessBatch processBatch = new ProcessBatch();
			processBatch.setParentGroupId(parentGroupId.toString());
			processBatch.setServiceType(serviceType);
			processBatch.setPartnerAlias(partnerAlias);

			StringResult srBatchRequest = new StringResult();
			this.marshallerForBatchRequest.marshal(processBatch, srBatchRequest);

			this.mqUtils.send(srBatchRequest.toString(), "", mqCorrespondenceConnectionFactory, mqCorrespondenceQueue,null);
		}
		catch (Exception e)
		{
			LOGGER.error("Error occured while putting message into the queue {} ", e.getMessage());
			try
			{
				this.trackingServiceMethods.updateGroupStatus(parentGroupId, PARTNER_QUEUE_ERROR, "");
			}
			catch (TrackingException ex)
			{
				LOGGER.error("Error occured while updating the parent transaction status to PARTNER_QUEUE_ERROR, Reason: {}", ex.getMessage());
			}
		}
	}
	

	private TrackingGroupCriteria initGroupSearch(BatchCriteria batchCriteria)
	{
		TrackingGroupCriteria groupCriteria = new TrackingGroupCriteria();
		String transactionType = null;
		if (batchCriteria.getTransactionType().equals(STATEMENTS_REQUEST_BO))
		{
			transactionType = CORRESPONDENCE_STATEMENTS;
			batchCriteria.setTransactionType(transactionType);
		}
		else if (batchCriteria.getTransactionType().equals(CORRESPONDENCE_REQUEST_BO))
		{
			transactionType = CORRESPONDENCE_LETTERS;
			batchCriteria.setTransactionType(transactionType);
		}
		else
		{
			transactionType = batchCriteria.getTransactionType();
		}
		groupCriteria.setServiceName(transactionType);
		groupCriteria.setServiceCategory(batchCriteria.getCategory());
		groupCriteria.setTransactionStatus(TransactionStatusKey.findForName(batchCriteria.getStatus()));
		groupCriteria.setMaxResults(this.maxResults);

		return groupCriteria;
	}

	public boolean isNullEmpty(String str)
	{
		return (str == null) || (str.trim().length() <= 0);
	}
}
