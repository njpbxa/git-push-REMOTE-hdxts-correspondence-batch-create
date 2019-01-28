package com.cerner.hdxts.correspondence.service;

import java.util.List;

import com.cerner.edi.tracking.service.domain.TrackingGroup;
import com.cerner.edi.tracking.service.dto.criteria.TrackingGroupCriteria;
import com.cerner.hdxts.correspondence.exception.TrackingException;

public interface ITrackingServiceMethods 
{
	/**
	 * Creates a tracking group.
	 * @param submitter
	 * @param service
	 * @param serviceCategory
	 * @param serviceMethod
	 * @param partner
	 * @return
	 * @throws TrackingException
	 */
	public Long createTrackingGroup(String submitter, String service, String serviceCategory, String serviceMethod, String partner) throws TrackingException;


	/**
	 * Links all the child to parent group Id
	 * @param parentGroupId
	 * @param childGroups
	 * @throws TrackingException
	 */
	public void batchAddChildrenToParent(Long parentGroupId, List<String> childGroups) throws TrackingException;

	/**
	 * @param groups
	 * @param trxnStatus
	 * @param deliveryStatus
	 * @throws TrackingException
	 */
	public void batchUpdateGroupEvents(List<String> groups, String trxnStatus, String deliveryStatus, String eventType, String historyType, String historyMessage) throws TrackingException;


	/**
	 * @param parentGroupId
	 * @param transactionStatus
	 * @param deliveryStatus
	 * @return
	 * @throws TrackingException
	 */
	public Boolean updateGroupStatus(Long parentGroupId, String transactionStatus, String deliveryStatus) throws TrackingException;

	/**
	 * Adds an event to the tracking group.
	 * @param groupId
	 * @param eventPayload
	 * @param eventType
	 * @param eventHistoryType
	 * @param eventHistoryMessage
	 * @throws TrackingException
	 */
	public String addEventToGroup(String groupId, String eventPayload, String eventType, String eventHistoryType, String eventHistoryMessage) throws TrackingException;

	/**
	 * Adds an error event to the tracking group.
	 * @param groupId
	 * @param eventType
	 * @param eventHistoryMessage
	 * @return
	 * @throws TrackingException
	 */
	public String addErrorEvent(String groupId, String eventType, String eventHistoryMessage) throws TrackingException;

	/**
	 * @param trackingGroupCriteria
	 * @return
	 * @throws TrackingException
	 */
	public List<TrackingGroup> findGroups(TrackingGroupCriteria trackingGroupCriteria)
			throws TrackingException;

	
	/**
	 * @param eventId
	 * @param filePath
	 * @param fileName
	 * @return
	 * @throws TrackingException
	 */
	public Boolean updateFileLocation(String eventId, String filePath, String fileName) throws TrackingException;
	
	/**
	 * @param eventId
	 * @param batchCount
	 * @param batchSequenceNumber
	 * @return
	 * @throws TrackingException
	 */
	public Boolean updateBatchStatistics(String eventId, String batchCount, String batchSequenceNumber) throws TrackingException;
	
	/**
	 * @param groupId
	 * @param transactionStatus
	 * @param deliveryStatus
	 * @param functionalTrxnStatus
	 * @return
	 */
	public Boolean updateGroupStatusAndFunctionalTrxnStatus(String groupId, String transactionStatus, String deliveryStatus, String functionalTrxnStatus) throws TrackingException;
	
	/**
	 * @param eventId
	 * @param historyMessage
	 * @param historyType
	 * @return
	 * @throws TrackingException
	 */
	public String addHistoryToEvent(String eventId, String historyMessage, String historyType) throws TrackingException;
	
	/**
	 * Returns the list of Submitter_Ids which are subscribed to the serviceCd
	 * @param serviceCd
	 * @return
	 */
	public List<Long> findSubmitterList(String serviceCd);
}
