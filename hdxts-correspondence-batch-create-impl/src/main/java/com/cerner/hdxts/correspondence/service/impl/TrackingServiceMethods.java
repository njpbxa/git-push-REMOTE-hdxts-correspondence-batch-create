package com.cerner.hdxts.correspondence.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cerner.edi.code.entity.CodeValue;
import com.cerner.edi.code.service.CodeSetService;
import com.cerner.edi.dep.partner.service.ServiceManager;
import com.cerner.edi.dep.submitter.response.ServiceResponse;
import com.cerner.edi.tracking.dao.TrackingDao;
import com.cerner.edi.tracking.service.TrackingService;
import com.cerner.edi.tracking.service.constant.DeliveryStatusKey;
import com.cerner.edi.tracking.service.constant.EventTypeKey;
import com.cerner.edi.tracking.service.constant.FunctionalTrxnStatusKey;
import com.cerner.edi.tracking.service.constant.HistoryTypeKey;
import com.cerner.edi.tracking.service.constant.RelationshipTypeKey;
import com.cerner.edi.tracking.service.constant.TransactionStatusKey;
import com.cerner.edi.tracking.service.domain.TrackingGroup;
import com.cerner.edi.tracking.service.dto.criteria.TrackingEventCriteria;
import com.cerner.edi.tracking.service.dto.criteria.TrackingGroupCriteria;
import com.cerner.edi.tracking.service.dto.request.AddEventRequest;
import com.cerner.edi.tracking.service.dto.request.AddHistoryRequest;
import com.cerner.edi.tracking.service.dto.request.BatchGroupEventRequest;
import com.cerner.edi.tracking.service.dto.request.CreateGroupRequest;
import com.cerner.edi.tracking.service.dto.request.UpdateEventRequest;
import com.cerner.edi.tracking.service.dto.request.UpdateGroupRequest;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.mapper.SubmitterMapper;
import com.cerner.hdxts.correspondence.service.ITrackingServiceMethods;
import com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant;
import com.cerner.hdxts.correspondence.utils.performance.PerformanceLogger;

@Service
public class TrackingServiceMethods
implements ITrackingServiceMethods
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TrackingServiceMethods.class);
	@Autowired
	private TrackingService trackingService;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private CodeSetService codeSetService;

	@Autowired
	private ServiceManager serviceManager;

	@Autowired
	private TrackingDao trackingDao;

	@Override
	public Long createTrackingGroup(String submitter, String service, String serviceCategory, String serviceMethod, String partner)
			throws TrackingException
	{
		try
		{
			CreateGroupRequest groupRequest = new CreateGroupRequest();
			if (!StringUtils.isBlank(service)) {
				groupRequest.setService(service);
			}
			if (!StringUtils.isBlank(serviceCategory)) {
				groupRequest.setServiceCategory(serviceCategory);
			}
			if (!StringUtils.isBlank(serviceMethod)) {
				groupRequest.setServiceMethod(serviceMethod);
			}
			if (!StringUtils.isBlank(partner)) {
				groupRequest.setPartner(partner);
			}
			if (!StringUtils.isBlank(submitter)) {
				groupRequest.setSubmitter(submitter);
			}
			Long groupId = this.trackingService.createGroup(groupRequest);
			return groupId;
		}
		catch (Exception e)
		{
			LOGGER.error("Error occured creating tracking group" + e);
			throw new TrackingException("Error occured creating tracking group");
		}
	}
	@Override
	public void batchAddChildrenToParent(Long parentGroupId, List<String> childGroups)
			throws TrackingException
	{
		if (parentGroupId == null) {
			throw new TrackingException("No parent group provided for operation addChildrenToParent");
		}
		if ((childGroups == null) || (childGroups.isEmpty())) {
			throw new TrackingException("No groups provided for operation addChildrenToParent");
		}
		List<Long> childList = new ArrayList();
		for (String nextGroup : childGroups) {
			childList.add(Long.valueOf(Long.parseLong(nextGroup)));
		}
		if (childList.size() == 1) 
		{
			try
			{
				this.trackingService.joinGroups(parentGroupId, (Long)childList.get(0), RelationshipTypeKey.BATCH);
			}
			catch (Exception e)
			{
				String errorMsg = "Error occured in operation addChildrenToParent , Reason: " + e.getMessage();
				LOGGER.error(errorMsg);
				throw new TrackingException(errorMsg);
			}
		} 
		else 
		{
			try
			{
				this.trackingService.addChildrenToParent(parentGroupId, childList, RelationshipTypeKey.BATCH);
			}
			catch (Exception e)
			{
				String errorMsg = "Error occured in operation addChildrenToParent , Reason: " + e.getMessage();
				LOGGER.error(errorMsg);
				throw new TrackingException(errorMsg);
			}
		}
	}
	@Override
	public void batchUpdateGroupEvents(List<String> groups, String trxnStatus, String deliveryStatus, String eventType, String historyType, String historyMessage)
			throws TrackingException
	{
		if ((groups == null) || (groups.isEmpty())) {
			throw new TrackingException("No groups provided for operation batchUpdateGroupEvents");
		}
		List<Long> grpList = new ArrayList<>();
		for (String nextGroup : groups) 
		{
			grpList.add(Long.valueOf(Long.parseLong(nextGroup)));
		}
		BatchGroupEventRequest request = new BatchGroupEventRequest();
		request.setTrxnStatus(trxnStatus);
		request.setDlvryStatus(deliveryStatus);
		request.setEventType(eventType);
		request.setEventHistoryType(historyType);
		request.setEventHistoryMessage(historyMessage);
		try
		{
			
			this.trackingService.batchUpdateGroupEvents(grpList, request);
		}
		catch (Exception e)
		{
			String errorMsg = "Error occured in operation batchUpdateGroupEvents , Reason: " + e.getMessage();
			LOGGER.error(errorMsg);
			throw new TrackingException(errorMsg);
		}
	}
	@Override
	public Boolean updateGroupStatus(Long parentGroupId, String transactionStatus, String deliveryStatus)
			throws TrackingException
	{
		try
		{
			UpdateGroupRequest updateGroup = new UpdateGroupRequest();
			if (StringUtils.isNotBlank(transactionStatus)) {
				updateGroup.setTransactionStatus(TransactionStatusKey.findForName(transactionStatus).getValue());
			}
			if (StringUtils.isNotBlank(deliveryStatus)) {
				updateGroup.setDeliveryStatus(DeliveryStatusKey.findForName(deliveryStatus).getValue());
			}
			PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_UPDATE_GROUP_STATUS);
			Boolean isUpdated = Boolean.valueOf(this.trackingService.updateGroup(parentGroupId, updateGroup));
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_UPDATE_GROUP_STATUS);
			return isUpdated;
		}
		catch (Exception e)
		{
			LOGGER.error("Error occured updating tracking group status:" + e);
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_UPDATE_GROUP_STATUS);
			throw new TrackingException("Error occured updating tracking group status: " + parentGroupId);
		}
	}
	@Override
	public String addEventToGroup(String groupId, String eventPayload, String eventType, String eventHistoryType, String eventHistoryMessage)
			throws TrackingException
	{
		try
		{
			EventTypeKey type = EventTypeKey.findForName(eventType);
			HistoryTypeKey htype = HistoryTypeKey.findForName(eventHistoryType);

			AddEventRequest addEventRequest = new AddEventRequest();
			if (type != null) {
				addEventRequest.setEventType(EventTypeKey.findForName(type.getValue()));
			}
			if (eventPayload != null) {
				addEventRequest.setPayload(eventPayload);
			}
			if (htype != null) {
				addEventRequest.setHistoryType(htype);
			}
			if (!StringUtils.isBlank(eventHistoryMessage)) {
				addEventRequest.setHistoryMessage(eventHistoryMessage);
			}
			PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_ADD_EVENT_TO_GROUP);
			String eventId = trackingService.addEvent(Long.valueOf(groupId), addEventRequest).toString();
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_ADD_EVENT_TO_GROUP);
			return eventId;
		}
		catch (Exception e)
		{
			LOGGER.error("Error adding event to group" + e);
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_ADD_EVENT_TO_GROUP);
			throw new TrackingException("Error adding event to group: " + groupId);
		}
	}
	@Override
	public String addErrorEvent(String groupId, String eventType, String eventHistoryMessage)
			throws TrackingException
	{
		try
		{
			return addEventToGroup(groupId, null, eventType, "ERROR", eventHistoryMessage);
		}
		catch (Exception e)
		{
			LOGGER.error("Error adding error event to group" + e);
			throw new TrackingException("Error adding error event to group: " + groupId);
		}
	}
	
	@Override
	public Boolean updateGroupStatusAndFunctionalTrxnStatus(String groupId, String transactionStatus, String deliveryStatus, String functionalTrxnStatus)
			throws TrackingException
	{
		try
		{
			UpdateGroupRequest updateGroup = new UpdateGroupRequest();
			if (StringUtils.isNotBlank(transactionStatus)) {
				updateGroup.setTransactionStatus(TransactionStatusKey.findForName(transactionStatus).getValue());
			}
			if (StringUtils.isNotBlank(deliveryStatus)) {
				updateGroup.setDeliveryStatus(DeliveryStatusKey.findForValue(deliveryStatus).getValue());
			}
			if (StringUtils.isNotBlank(functionalTrxnStatus)) {
				updateGroup.setFunctionalTrxnStatus(FunctionalTrxnStatusKey.findForValue(functionalTrxnStatus).getValue());
			}
			PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_UPDATE_GROUP_STATUS_AND_FUNCTIONAL_STATUS);
			Boolean isUpdate = Boolean.valueOf(this.trackingService.updateGroup(Long.valueOf(groupId), updateGroup));
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_UPDATE_GROUP_STATUS_AND_FUNCTIONAL_STATUS);
			return isUpdate;
		}
		catch (Exception e)
		{
			LOGGER.error("Error occured creating updating group and functional status" + e);
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_UPDATE_GROUP_STATUS_AND_FUNCTIONAL_STATUS);
			throw new TrackingException("Error occured creating updating group and functional status " + groupId);
		}
	}

	@Override
	public List<TrackingGroup> findGroups(TrackingGroupCriteria trackingGroupCriteria) throws TrackingException
	{
		List<TrackingGroup> trackingGroups = null;
		try
		{
			if (trackingGroupCriteria != null)
			{
				trackingGroupCriteria.setLoadEvents(Boolean.valueOf(true));
				LOGGER.debug("Search criteria: {}", trackingGroupCriteria);
				trackingGroups = this.trackingService.findGroups(trackingGroupCriteria);
				if ((null != trackingGroups) && (!trackingGroups.isEmpty()))
				{
					LOGGER.debug("Found [{}] TrackingGroups", Integer.valueOf(trackingGroups.size()));
					int groupIndex = 1;
					for (TrackingGroup trackingGroup : trackingGroups)
					{
						TrackingEventCriteria eventCriteria = new TrackingEventCriteria();
						eventCriteria.setGroupId(trackingGroup.getId());

						eventCriteria.setEventType(trackingGroupCriteria.getGroupEventType());

						eventCriteria.setEventDateSortOrder(trackingGroupCriteria.getEventDateSortOrder());

						trackingGroup.setEvents(this.trackingService.findEvents(eventCriteria, false));
					}
				}
			}
		}
		catch (Exception e)
		{
			LOGGER.error("Error occured finding the groups, Reason: {}", e.getMessage());
			throw new TrackingException("Error occured finding the groups");
		}
		return trackingGroups;
	}

	/**
	 * Method generated to support implementation of operation
	 * "updateBatchStatistics" defined for WSDL port type named
	 * "ITrackingService".
	 * 
	 * Please refer to the WSDL Definition for more information on the type of
	 * input, output and fault(s).
	 * @throws TrackingException 
	 */
	@Override
	public Boolean updateBatchStatistics(String eventId, String batchCount, String batchSequenceNumber) throws TrackingException {

		try {
			UpdateEventRequest req = new UpdateEventRequest();
			if (!StringUtils.isBlank(batchCount)) {
				req.setBatchCount(Integer.valueOf(batchCount));
			}
			if (!StringUtils.isBlank(batchSequenceNumber)) {
				req.setBatchSeqNumber(Integer.valueOf(batchSequenceNumber));
			}
			PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_UPDATE_BATCH_STATISTICS);
			Boolean isUpdated = trackingService.updateEvent(Long.valueOf(eventId), req);
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_UPDATE_BATCH_STATISTICS);
			return isUpdated;
		}
		catch (Exception e) 
		{
			LOGGER.error("Error occured updating batch statistics, Reason: {}", e.getMessage());
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_UPDATE_BATCH_STATISTICS);
			throw new TrackingException("Error occured updating batch statistics");
		}
	}

	/**
	 * Method generated to support implementation of operation
	 * "updateFileLocation" defined for WSDL port type named "ITrackingService".
	 * 
	 * Please refer to the WSDL Definition for more information on the type of
	 * input, output and fault(s).
	 * @throws TrackingException 
	 */
	@Override
	public Boolean updateFileLocation(String eventId, String filePath, String fileName) throws TrackingException {
		try 
		{
			UpdateEventRequest req = new UpdateEventRequest();
			if (!StringUtils.isBlank(fileName)) {
				req.setFileName(fileName);
			}
			if (!StringUtils.isBlank(filePath)) {
				req.setFilePath(filePath);
			}
			PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_UPDATE_FILE_LOCATION);
			Boolean isUpdated = trackingService.updateEvent(Long.valueOf(eventId), req);
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_UPDATE_FILE_LOCATION);
			return isUpdated;
		} 
		catch (Exception e) 
		{
			LOGGER.error("Error occured updating group file location" + e);
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_UPDATE_FILE_LOCATION);
			throw new TrackingException("Error occured updating group file location");
		}
	}


	@Override
	public String addHistoryToEvent(String eventId, String historyMessage, String historyType) throws TrackingException
	{
		try 
		{
			Long eventID = Long.valueOf(eventId);
			AddHistoryRequest addHistoryRequest = new AddHistoryRequest();
			if (historyType != null) {
				addHistoryRequest.setType(HistoryTypeKey.findForName(historyType));
			}
			if (!StringUtils.isBlank(historyMessage)) {
				addHistoryRequest.setMessage(historyMessage);
			}
			PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_ADD_HISTORY);
			String historyId = String.valueOf(trackingService.addHistory(eventID, addHistoryRequest));
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_ADD_HISTORY);
			return historyId;
		} 
		catch (Exception e) 
		{
			LOGGER.error("Error occured adding history to event:" + e);
			PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_ADD_HISTORY);
			throw new TrackingException("Error occured adding history to event: "+ eventId);
		}
	}

	@Override
	public List<Long> findSubmitterList(String serviceCd)
	{
		Long serviceId = findServiceId(serviceCd);
		List<Long> submitterIds = null;
		if(serviceId != null)
		{
			submitterIds = new JdbcTemplate(dataSource).query(CorrespondenceConstant.FIND_SUBMITTER_LIST, new Object[] { serviceId}, new SubmitterMapper());
		}
		else
		{
			LOGGER.debug("Service Id is null");
		}
		return submitterIds;
	}

	private Long findServiceId(String serviceCd)
	{
		CodeValue serviceCodeValue = codeSetService.findCodeValue(CorrespondenceConstant.SERVICE, serviceCd);
		LOGGER.debug("Service CodeValue: {}",serviceCodeValue.getCodeValue());
		CodeValue serviceCategoryCdCodeValue = codeSetService.findCodeValue(CorrespondenceConstant.SERVICE_CATEGORY, CorrespondenceConstant.REALTIME);
		if(serviceCodeValue != null)
		{
			ServiceResponse serviceResponse = serviceManager.getServiceByServiceCodes(serviceCategoryCdCodeValue.getCodeValue(), serviceCodeValue.getCodeValue());
			if(serviceResponse != null)
			{
				return serviceResponse.getServiceId();
			}
		}
		return null;
	}
}
