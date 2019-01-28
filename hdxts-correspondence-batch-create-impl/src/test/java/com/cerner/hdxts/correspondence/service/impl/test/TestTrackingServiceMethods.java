package com.cerner.hdxts.correspondence.service.impl.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.cerner.edi.code.entity.CodeValue;
import com.cerner.edi.code.service.CodeSetService;
import com.cerner.edi.dep.partner.service.ServiceManager;
import com.cerner.edi.dep.submitter.response.ServiceResponse;
import com.cerner.edi.tracking.dao.TrackingDao;
import com.cerner.edi.tracking.service.TrackingService;
import com.cerner.edi.tracking.service.domain.TrackingEvent;
import com.cerner.edi.tracking.service.domain.TrackingGroup;
import com.cerner.edi.tracking.service.domain.TrackingSubmitter;
import com.cerner.edi.tracking.service.dto.criteria.TrackingGroupCriteria;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.service.impl.TrackingServiceMethods;

@RunWith(MockitoJUnitRunner.class)
public class TestTrackingServiceMethods {

	
	TrackingGroup trackingGroup = new TrackingGroup();
	List<TrackingGroup> trackingGroupList = new ArrayList<>();
	List<TrackingEvent> events = new ArrayList<TrackingEvent>();
	@Mock
	CodeValue codeValue;// = new CodeValue();
	@Mock
	TrackingService trackingService;
	
	@Mock
	DataSource dataSource;
	
	@Mock
	CodeSetService codeSetService;
	
	
	@Mock
	ServiceResponse serviceResponse;
	@Mock
	ServiceManager serviceManager;
	
	@Mock
	TrackingDao trackingDao;

	@Mock
	TrackingGroupCriteria trackingGroupCriteria;
	@Mock
	TrackingEvent event;
	@Mock
	TrackingSubmitter trackingSubmitter;
	@InjectMocks
	TrackingServiceMethods  trackingServiceMethods;
	
	
	@Test(expected = TrackingException.class)
	public void TestCreateTrackingGroupWithException() throws TrackingException
	{
		TrackingServiceMethods tsm= new TrackingServiceMethods();
		tsm.createTrackingGroup("submitter", "service", "serviceCategory", "serviceMethod", "partner");
	}
	
	@Test
	public void TestCreateTrackingGroup() throws TrackingException
	{
		when(trackingService.createGroup(any())).thenReturn((long)112);
		long groupId = trackingServiceMethods.createTrackingGroup("submitter", "service", "serviceCategory", "serviceMethod", "partner");
		assertNotNull(groupId);
	}
	
	
	@Test
	public void TestBatchAddChildrenToParentWithTrackingExceptionForParentGroupID()
	{
		try {
			trackingServiceMethods.batchAddChildrenToParent(null, null);
		} catch (TrackingException e) {
			// TODO Auto-generated catch block
			String expected = "No parent group provided for operation addChildrenToParent";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void TestBatchAddChildrenToParentWithTrackingExceptionForChildGroups()
	{
		try {
			trackingServiceMethods.batchAddChildrenToParent((long)1, null);
		} catch (TrackingException e) {
			// TODO Auto-generated catch block
			String expected = "No groups provided for operation addChildrenToParent";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test(expected=TrackingException.class)
	public void TestBatchAddChildrenWithOneGroupWithTrackingExceptionDuringOperationaddChildrenToParent() throws TrackingException
	{
		List<String> childGroups =new ArrayList<>();
		TrackingServiceMethods tsm = new TrackingServiceMethods();
		childGroups.add("1");
		tsm.batchAddChildrenToParent((long)1, childGroups);
	}
	
	@Test
	public void TestBatchAddChildrenWithOneGroup()
	{
		List<String> childGroups =new ArrayList<>();
		childGroups.add("1");
		try {
			when(trackingService.joinGroups(anyLong(), anyLong(), any())).thenReturn(true);
			trackingServiceMethods.batchAddChildrenToParent((long)1, childGroups);
		} catch (TrackingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected = TrackingException.class)
	public void TestBatchAddChildrenWithMultipleGroupsAndTrackingException() throws TrackingException
	{
		TrackingServiceMethods tsm =new TrackingServiceMethods();
		List<String> childGroups =new ArrayList<>();
		childGroups.add("1");
		childGroups.add("2");
		tsm.batchAddChildrenToParent((long)1, childGroups);
	}
	
	
	@Test
	public void TestBatchAddChildrenWithMultipleGroups()
	{
		List<String> childGroups =new ArrayList<>();
		childGroups.add("1");
		childGroups.add("2");
		try {
			doNothing().when(trackingService).addChildrenToParent(anyLong(), any(), any());
			trackingServiceMethods.batchAddChildrenToParent((long)1, childGroups);
		} catch (TrackingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestBatchUpdateGroupEventsWithNoGroupID()
	{
		try {
			trackingServiceMethods.batchUpdateGroupEvents(null, null, null, null, null, null);
		} catch (TrackingException e) {
			String expected = "No groups provided for operation batchUpdateGroupEvents";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test(expected = TrackingException.class)
	public void TestBatchUpdateGroupEventsWithTrackingExceptionDuringOperation() throws TrackingException
	{
		TrackingServiceMethods tsm = new TrackingServiceMethods();
		List<String> List_group_id = new ArrayList<>();
		List_group_id.add("111");
		List_group_id.add("222");
		tsm.batchUpdateGroupEvents(List_group_id, "", "", "", "", "");
	}
	
	@Test
	public void TestBatchUpdateGroupEvents()
	{
		try {
			List<String> List_group_id = new ArrayList<>();
			List_group_id.add("111");
			List_group_id.add("222");
			doNothing().when(trackingService).batchUpdateGroupEvents(any(),any());
			trackingServiceMethods.batchUpdateGroupEvents(List_group_id, "", "", "", "", "");
		} catch (TrackingException e) {
			String expected = "No groups provided for operation batchUpdateGroupEvents";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void TestUpdateGroupStatusWithTrackingException()
	{
		when(trackingService.updateGroup(anyLong(),any())).thenReturn(true);
		boolean status;
		try {
			status = trackingServiceMethods.updateGroupStatus((long)123, "WillThrowError", "AVAILABLE");
		} catch (TrackingException e) {
			// TODO Auto-generated catch block
			String expected = "Error occured updating tracking group status: 123";
			assertEquals(expected, e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void TestUpdateGroupStatus() throws TrackingException
	{
		when(trackingService.updateGroup(anyLong(),any())).thenReturn(true);
		boolean status = trackingServiceMethods.updateGroupStatus((long)123, "COMPLETE", "AVAILABLE");
		assertEquals(status, true);
	}
	
	
	@Test
	public void TestAddEventToGroupWithTrackingException()
	{
		try {
			trackingServiceMethods.addEventToGroup("123","abcd","WillThrowError","ARCHIVED","xyz");
		} catch (TrackingException e) {
			String expected = "Error adding event to group: 123";
			assertEquals(expected, e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void TestAddEventToGroup() throws TrackingException
	{
		when(trackingService.addEvent(anyLong(), any())).thenReturn((long)110);
		String eventId = trackingServiceMethods.addEventToGroup("123","abcd","CERNER_STANDARD_REQUEST","ARCHIVED","xyz");
		assertEquals(eventId,"110");
	}
	
	@Test
	public void TestAddErrorEventWithTrackingException()
	{
		String eventId;
		try {
			eventId = trackingServiceMethods.addErrorEvent("123","WillThrowError","xyz");
		} catch (TrackingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String expected = "Error adding error event to group: 123";
			assertEquals(expected, e.getMessage());
			System.out.println(e.getMessage());
		}
		//assertEquals(eventId,"110");
	}
	
	
	@Test
	public void TestAddErrorEvent() throws TrackingException
	{
		when(trackingService.addEvent(anyLong(), any())).thenReturn((long)110);
		String eventId = trackingServiceMethods.addErrorEvent("123","CERNER_STANDARD_REQUEST","xyz");
		assertEquals(eventId,"110");
	}
	
	@Test
	public void TestUpdateGroupStatusAndFunctionalTrxnStatusWithTrackingException()
	{
		//when(trackingService.updateGroup(anyLong(), any())).thenReturn(true);
		boolean returnValue;
		try {
			returnValue = trackingServiceMethods.updateGroupStatusAndFunctionalTrxnStatus("123", "WillThrowError",  "AVAILABLE", "APPROVED");
		} catch (TrackingException e) {
			String expected = "Error occured creating updating group and functional status 123";
			assertEquals(expected, e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void TestUpdateGroupStatusAndFunctionalTrxnStatus() throws TrackingException
	{
		when(trackingService.updateGroup(anyLong(), any())).thenReturn(true);
		boolean returnValue = trackingServiceMethods.updateGroupStatusAndFunctionalTrxnStatus("123", "COMPLETE",  "AVAILABLE", "APPROVED");
		assertEquals(returnValue, true);
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * WRITE TEST CASES FOR findGroups
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	@Test(expected=TrackingException.class)
	public void TestFindGroupWithtrackingException() throws TrackingException
	{
		TrackingServiceMethods tsm = new TrackingServiceMethods();
		tsm.findGroups(trackingGroupCriteria);
	}
	@Test
	public void TestFindGroup() throws TrackingException
	{
		trackingGroup.setBatchCount("batchCount");
		trackingGroupList.add(trackingGroup);
		trackingGroupCriteria.setAlias("alias");
		when(trackingService.findGroups(any())).thenReturn(trackingGroupList);
		trackingServiceMethods.findGroups(trackingGroupCriteria);
	}
	
	
	
	@Test
	public void TestUpdateBatchStatisticsWithTrackingException()
	{
		Boolean value;
		try {
			value = trackingServiceMethods.updateBatchStatistics("12","WillCauseError","12");
		} catch (TrackingException e) {
			String expected = "Error occured updating batch statistics";
			assertEquals(expected, e.getMessage());
			System.out.println(e.getMessage());
			
		}
		
	}
	
	@Test
	public void TestUpdateBatchStatistics() throws TrackingException
	{
		when(trackingService.updateEvent(anyLong(), any())).thenReturn(true);
		Boolean value = trackingServiceMethods.updateBatchStatistics("12","12","12");
		assertEquals(value,true);
	}
	
	@Test
	public void TestUpdateFileLocationThrowsTrackingException()
	{
		
		try {
			Boolean returnValue = trackingServiceMethods.updateFileLocation("WillCauseError", "filePath", "fileName");
		} catch (TrackingException e) {
			String expected = "Error occured updating group file location";
			assertEquals(expected, e.getMessage());
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void TestUpdateFileLocation() throws TrackingException
	{
		when(trackingService.updateEvent(anyLong(), any())).thenReturn(true);
		Boolean returnValue = trackingServiceMethods.updateFileLocation("123", "filePath", "fileName");
		assertEquals(returnValue,true);
	}
	
	@Test
	public void TestAddHistoryToEventWithTrackingException()
	{
		String returnValue;
		try {
			returnValue = trackingServiceMethods.addHistoryToEvent("123", "historyMessage", "WillCauseError");
		} catch (TrackingException e) {
			String expected = "Error occured adding history to event: 123";
			assertEquals(expected, e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void TestAddHistoryToEvent() throws TrackingException
	{
		when(trackingService.addHistory(anyLong(),any())).thenReturn((long)121);
		String returnValue = trackingServiceMethods.addHistoryToEvent("123", "historyMessage", "ERROR");
		assertEquals(returnValue,"121");
	}
	
	@Test(expected = NullPointerException.class)
	public void TestFindSubmitterList()
	{
		codeValue.setCodeValue((long)1223);
		when(serviceResponse.getServiceId()).thenReturn((long)122);
		when(codeSetService.findCodeValue(anyString(),anyString())).thenReturn(codeValue);
		when(serviceManager.getServiceByServiceCodes(anyLong(), anyLong())).thenReturn(serviceResponse);
		trackingServiceMethods.findSubmitterList("serviceCd");
	}
	
}
