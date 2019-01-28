package com.cerner.hdxts.correspondence.service.impl;

import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.NONE;
import static com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant.QUEUED;

import java.util.List;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cerner.edi.tracking.dao.TrackingDao;
import com.cerner.edi.tracking.service.TrackingService;
import com.cerner.edi.tracking.service.constant.TransactionStatusKey;
import com.cerner.edi.tracking.service.domain.SubmitterPartnerGroup;
import com.cerner.edi.tracking.service.dto.criteria.TrackingGroupCriteria;
import com.cerner.hdxts.correspondence.entities.BatchRequestMessage;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant;
import com.cerner.hdxts.correspondence.utils.performance.PerformanceLogger;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BatchRequestListner implements MessageListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchRequestListner.class);

	@Autowired
	private BatchOutServiceImpl batchOutServiceImpl;

	@Autowired
	@Qualifier("maxResults")
	private Long maxResults;

	@Autowired
	private TrackingService trackingService;

	@Autowired
	private TrackingServiceMethods trackingServiceMethods;

	@Override
	public void onMessage(Message message) 
	{
		LOGGER.debug("Message received in BatchRequestListner.onMessage(): {}", message);
		if (message != null)
		{
			TextMessage tMsg = null;
			try
			{
				if ((message instanceof TextMessage))
				{
					tMsg = (TextMessage) message;

					String strMessage = tMsg.getText();
					ObjectMapper mapper = new ObjectMapper();
					BatchRequestMessage batchRequestMessage = mapper.readValue(strMessage, BatchRequestMessage.class);

					List<SubmitterPartnerGroup> submitterPartnerGroups = findSubmitterPartnerGroupMap(batchRequestMessage);
					processSubmitterPartnerGroups(submitterPartnerGroups, batchRequestMessage);
				}
			}
			catch(Exception e)
			{
				LOGGER.error("BatchRequestListner.onMessage(): Exception:" + e.getMessage());
			}
		}
		
	}
	
	public List<SubmitterPartnerGroup> findSubmitterPartnerGroupMap(BatchRequestMessage batchReqMessage)
	{
		List<SubmitterPartnerGroup> submitterPartnerGroups = null;
		try
		{
			PerformanceLogger.processStart(CorrespondenceConstant.PERF_FIND_SUB_PARTNER_GROUP);
			TrackingGroupCriteria groupCriteria = new TrackingGroupCriteria();
			
			groupCriteria.setServiceName(batchReqMessage.getServiceCode());
			groupCriteria.setServiceCategory(batchReqMessage.getServiceCategory());
			groupCriteria.setTransactionStatus(TransactionStatusKey.findForName(batchReqMessage.getTrxnStatus()));
			groupCriteria.setMaxResults(this.maxResults);

			submitterPartnerGroups = trackingService.findSubmitterPartnerGroups(groupCriteria,batchReqMessage.getSubmitterId());
			PerformanceLogger.processEnd(CorrespondenceConstant.PERF_FIND_SUB_PARTNER_GROUP);
		}
		catch (Exception e)
		{
			LOGGER.error("Error occured while fetching the transactions for batch processing {}", e.getMessage());
			PerformanceLogger.processFail(CorrespondenceConstant.PERF_FIND_SUB_PARTNER_GROUP);
		}
		return submitterPartnerGroups;
	}
	
	public void processSubmitterPartnerGroups(List<SubmitterPartnerGroup> submitterPartnerGroups, BatchRequestMessage batchReqMessage)
	{
		if ((submitterPartnerGroups != null) && (!submitterPartnerGroups.isEmpty()))
		{
			PerformanceLogger.processStart(CorrespondenceConstant.PERF_PROCESS_GROUPS);
			LOGGER.debug("Found submitter partner group for batch processing, count: {}", Integer.valueOf(submitterPartnerGroups.size()));
			for (SubmitterPartnerGroup submitterPartnerGroup : submitterPartnerGroups)
			{
				Long parentGroupId = null;
				try
				{
					PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_TRK_CREATE_GROUP);
					parentGroupId = this.trackingServiceMethods.createTrackingGroup(submitterPartnerGroup.getEdiSubmitterId(), batchReqMessage.getServiceCode(), batchReqMessage.getServiceCategory(), "PROCESS_BATCH", submitterPartnerGroup
							.getPartnerAlias());
					LOGGER.debug("Parent group Id created: {}", parentGroupId);
					PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_TRK_CREATE_GROUP);
				}
				catch (TrackingException e)
				{
					PerformanceLogger.serviceFail(CorrespondenceConstant.PERF_TRK_CREATE_GROUP);
					LOGGER.error("Error occured while creating parent group id, Reason {} ", e.getMessage());
					continue;
				}
				try
				{
					LOGGER.debug("Start: Linking groups to parent");
					PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_TRK_JOIN_GROUP);
					this.trackingServiceMethods.batchAddChildrenToParent(parentGroupId, submitterPartnerGroup.getGroupList());
					PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_TRK_JOIN_GROUP);
					LOGGER.debug("End: Linking groups to parent");
				}
				catch (TrackingException e)
				{
					PerformanceLogger.serviceFail(CorrespondenceConstant.PERF_TRK_JOIN_GROUP);
					LOGGER.error("Error occured while linking with parent group id to child groups, Reason {}", e.getMessage());
				}
				try
				{
					LOGGER.debug("Start: Updating group status to QUEUED");
					PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_BATCH_UPDATE_GROUP_EVENTS);
					this.trackingServiceMethods.batchUpdateGroupEvents(submitterPartnerGroup.getGroupList(), QUEUED, NONE,"", "","");
					PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_BATCH_UPDATE_GROUP_EVENTS);
					LOGGER.debug("End: Updating group status to QUEUED");
				}
				catch (TrackingException e)
				{
					PerformanceLogger.serviceFail(CorrespondenceConstant.PERF_BATCH_UPDATE_GROUP_EVENTS);
					LOGGER.error("Error occured while updating the child groups to QUEUED status, Reason {} ", e.getMessage());
				}
				PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_PUT_BATCH_REQ_MSG);
				batchOutServiceImpl.putMessageInQueue(parentGroupId, batchReqMessage.getServiceCode(), submitterPartnerGroup.getPartnerAlias());
				PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_PUT_BATCH_REQ_MSG);
				PerformanceLogger.processEnd(CorrespondenceConstant.PERF_PROCESS_GROUPS);
			}
		}
		else
		{
			LOGGER.debug("No records found");
		}
	}

}
