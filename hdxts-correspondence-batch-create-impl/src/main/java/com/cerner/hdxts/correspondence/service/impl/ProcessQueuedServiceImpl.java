package com.cerner.hdxts.correspondence.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.xml.transform.StringSource;

import com.cerner.edi.tracking.service.constant.EventTypeKey;
import com.cerner.edi.tracking.service.domain.TrackingEvent;
import com.cerner.edi.tracking.service.domain.TrackingGroup;
import com.cerner.edi.tracking.service.dto.criteria.TrackingGroupCriteria;
import com.cerner.hdxts.correspondence.entities.BatchRequest;
import com.cerner.hdxts.correspondence.entities.BatchRequests;
import com.cerner.hdxts.correspondence.entities.ProcessBatch;
import com.cerner.hdxts.correspondence.entities.QueueBatchedRequest;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.service.ITrackingServiceMethods;
import com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant;
import com.cerner.hdxts.correspondence.utils.performance.PerformanceLogger;

@Service
public class ProcessQueuedServiceImpl
implements MessageListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessQueuedServiceImpl.class);
	
	@Qualifier("marshallerForBatchRequest")
	@Autowired
	private Jaxb2Marshaller marshallerForBatchRequest;

	@Autowired
	private ITrackingServiceMethods trackingServiceMethods;

	@Autowired
	private BatchProcessGroupsServiceImpl batchProcessGroupsService;

	public void onMessage(Message message)
	{
		LOGGER.debug("Message received in ProcessQueuedServiceImpl.onMessage(): {}", message);
		if (message != null)
		{
			TextMessage tMsg = null;
			try
			{
				if ((message instanceof TextMessage))
				{
					tMsg = (TextMessage) message;
					LOGGER.debug("Converted Message to TextMessage {}", tMsg);
					LOGGER.debug("Marshaller object {}", this.marshallerForBatchRequest);
					ProcessBatch processBatch = (ProcessBatch)this.marshallerForBatchRequest.unmarshal(new StringSource(tMsg.getText()));
					LOGGER.debug("Unmarshalled the queue message to object");
					QueueBatchedRequest queueBatchedRequest = findChildGroups(processBatch);
					if (queueBatchedRequest != null)
					{
						LOGGER.debug("Start: Calling BatchProcessGroupsServiceImpl.processBatchRequests");
						batchProcessGroupsService.processBatchRequests(queueBatchedRequest);
						LOGGER.debug("End: Calling BatchProcessGroupsServiceImpl.processBatchRequests");
					}
				}
			}
			catch (Exception t)
			{
				LOGGER.error("ProcessQueuedServiceImpl.onMessage(): Exception:" + t.getMessage());
			}
		}
	}

	private QueueBatchedRequest findChildGroups(ProcessBatch processBatch)
	{
		List<TrackingGroup> trackingGroups = null;
		QueueBatchedRequest batchedRequest = null;
		if (processBatch != null)
		{
			TrackingGroupCriteria criteria = new TrackingGroupCriteria();
			criteria.setServiceName(processBatch.getServiceType());
			criteria.setGroupEventType(EventTypeKey.CERNER_STANDARD_REQUEST);
			criteria.setParentGroupId(Long.valueOf(Long.parseLong(processBatch.getParentGroupId())));
			LOGGER.debug("Finding child groups for service: {}, parentGroupId: {}", criteria.getServiceName(), criteria.getParentGroupId());
			try
			{
				PerformanceLogger.processStart(CorrespondenceConstant.PERF_FIND_GROUPS);
				trackingGroups = this.trackingServiceMethods.findGroups(criteria);
				PerformanceLogger.processEnd(CorrespondenceConstant.PERF_FIND_GROUPS);
				if ((trackingGroups != null) && (!trackingGroups.isEmpty()))
				{
					LOGGER.debug("Tracking child groups are not null, count is {}", Integer.valueOf(trackingGroups.size()));
					batchedRequest = new QueueBatchedRequest();
					batchedRequest.setParentGroupId(Long.valueOf(Long.parseLong(processBatch.getParentGroupId())));
					batchedRequest.setServiceType(processBatch.getServiceType());
					batchedRequest.setPartnerAlias(processBatch.getPartnerAlias());
					List<BatchRequest> batchRequests = new ArrayList<>();
					LOGGER.debug("Starting the loop");
					for (TrackingGroup trackingGroup : trackingGroups)
					{
						BatchRequest batchRequest = new BatchRequest();
						batchRequest.setSubmitterId(trackingGroup.getSubmitter().getSubmitterId().toString());
						LOGGER.debug("Submitter Id: {}", trackingGroup.getSubmitter().getSubmitterId().toString());
						batchRequest.setEventId(((TrackingEvent)trackingGroup.getEvents().get(0)).getId());
						LOGGER.debug("Event Id: {}", ((TrackingEvent)trackingGroup.getEvents().get(0)).getId());
						batchRequest.setGroupId(trackingGroup.getId());
						LOGGER.debug("Group Id: {}", trackingGroup.getId());
						batchRequest.setMessage(((TrackingEvent)trackingGroup.getEvents().get(0)).getPayload());
						LOGGER.debug("Payload: {}", ((TrackingEvent)trackingGroup.getEvents().get(0)).getPayload());
						batchRequest.setTransactionType(processBatch.getServiceType());
						batchRequests.add(batchRequest);
					}
					BatchRequests requests = new BatchRequests();
					requests.setBatchRequests(batchRequests);
					batchedRequest.setBatchRequests(requests);
				}
			}
			catch (TrackingException e)
			{
				LOGGER.error("Error occured while fetching child group details, Reason: {}", e.getMessage());
			}
		}
		return batchedRequest;
	}
}
