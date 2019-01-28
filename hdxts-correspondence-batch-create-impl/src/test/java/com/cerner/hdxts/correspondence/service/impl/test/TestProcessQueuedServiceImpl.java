package com.cerner.hdxts.correspondence.service.impl.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringSource;

import com.cerner.edi.tracking.service.domain.TrackingEvent;
import com.cerner.edi.tracking.service.domain.TrackingGroup;
import com.cerner.edi.tracking.service.domain.TrackingOrganization;
import com.cerner.edi.tracking.service.domain.TrackingSubmitter;
import com.cerner.hdxts.correspondence.entities.ProcessBatch;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.service.ITrackingServiceMethods;
import com.cerner.hdxts.correspondence.service.impl.BatchProcessGroupsServiceImpl;
import com.cerner.hdxts.correspondence.service.impl.ProcessQueuedServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestProcessQueuedServiceImpl {

	ProcessBatch processBatch = new ProcessBatch();
	TrackingGroup trackingGroup = new TrackingGroup();
	List<TrackingGroup> trackingGroupList = new ArrayList<>();
	List<TrackingEvent> events = new ArrayList<TrackingEvent>();
	@Mock
	TextMessage message;
	@Mock
	TrackingEvent event;
	@Mock
	TrackingSubmitter trackingSubmitter;
	@Qualifier("marshallerForBatchRequest")
	@Mock
	Jaxb2Marshaller marshallerForBatchRequest;

	@Mock
	ITrackingServiceMethods trackingServiceMethods;

	@Mock
	BatchProcessGroupsServiceImpl batchProcessGroupsService;
	
	@InjectMocks
	ProcessQueuedServiceImpl processQueuedServiceImpl;
	
	@Before
	public void SetUp()
	{
		processBatch.setParentGroupId("123");
		processBatch.setPartnerAlias("Alias");
		processBatch.setServiceType("Type");
		
	}
	
	@Test
	public void TestOnMessageThrowingException() throws JMSException, TrackingException {
		processBatch.setParentGroupId("WillCauseError");
		when(message.getText()).thenReturn("abcde");
		when(marshallerForBatchRequest.unmarshal(new StringSource(anyString()))).thenReturn(processBatch);
		processQueuedServiceImpl.onMessage(message);
	}
	
	@Test
	public void TestOnMessageWithTrackingException() throws JMSException, TrackingException
	{
	
		events.add(event);
		trackingGroup.setSubmitter(trackingSubmitter);
		trackingGroup.setEvents(events);
		trackingGroupList.add(trackingGroup);
		when(message.getText()).thenReturn("abcde");
		when(marshallerForBatchRequest.unmarshal(new StringSource(anyString()))).thenReturn(processBatch);
		when(trackingSubmitter.getSubmitterId()).thenReturn((long)123456);
		when(event.getId()).thenReturn((long)1122);
		when(event.getPayload()).thenReturn("payload");
		when(trackingServiceMethods.findGroups(any())).thenThrow(new TrackingException());
		doNothing().when(batchProcessGroupsService).processBatchRequests(any());
		processQueuedServiceImpl.onMessage(message);
	}
	
	@Test
	public void TestOnMessage() throws JMSException, TrackingException
	{
	
		events.add(event);
		trackingGroup.setSubmitter(trackingSubmitter);
		trackingGroup.setEvents(events);
		trackingGroupList.add(trackingGroup);
		when(message.getText()).thenReturn("abcde");
		when(marshallerForBatchRequest.unmarshal(new StringSource(anyString()))).thenReturn(processBatch);
		when(trackingSubmitter.getSubmitterId()).thenReturn((long)123456);
		when(event.getId()).thenReturn((long)1122);
		when(event.getPayload()).thenReturn("payload");
		when(trackingServiceMethods.findGroups(any())).thenReturn(trackingGroupList);
		doNothing().when(batchProcessGroupsService).processBatchRequests(any());
		processQueuedServiceImpl.onMessage(message);
	}
}
