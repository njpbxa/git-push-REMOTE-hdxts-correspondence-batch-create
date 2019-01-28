package com.cerner.hdxts.correspondence.service.impl.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

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

import com.cerner.edi.tracking.service.TrackingService;
import com.cerner.edi.tracking.service.domain.SubmitterPartnerGroup;
import com.cerner.hdxts.correspondence.entities.BatchRequestMessage;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.service.impl.BatchOutServiceImpl;
import com.cerner.hdxts.correspondence.service.impl.BatchRequestListner;
import com.cerner.hdxts.correspondence.service.impl.TrackingServiceMethods;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class TestBatchRequestListner {

	String text = "{\r\n" + 
			"   \"submitterId\": \"12\",\r\n" + 
			"   \"serviceCode\": \"CORRESPONDENCE_STATEMENTS\",\r\n" + 
			"   \"serviceCategory\": \"REALTIME\",\r\n" + 
			"   \"trxnStatus\": \"VALIDATED\"\r\n" + 
			"}";
	List<String> groupList = new ArrayList<>();
	SubmitterPartnerGroup submitterPartnerGroup;
	List<SubmitterPartnerGroup> submitterPartnerGroupList = new ArrayList<>();
	@Mock
	TextMessage message;
	@Mock
	BatchOutServiceImpl batchOutServiceImpl;
	
	@Mock
	TrackingService trackingService;
	
	@Mock
	TrackingServiceMethods trackingServiceMethods;
	
	@Mock
	ObjectMapper objectMapper;
	
	@Mock
	BatchRequestMessage batchRequestMessage;
	@InjectMocks
	BatchRequestListner batchRequestListner;
	
	@Before
	public void SetUp() throws JMSException
	{
		groupList.add("1");
		groupList.add("2");
		submitterPartnerGroup = new SubmitterPartnerGroup("submitterId", "ediSubmitterId", "partnerId", "partnerAlias", groupList);
		submitterPartnerGroupList.add(submitterPartnerGroup);
	}
	
	@Test
	public void TestOnMessageWithMapperError()
	{
		batchRequestListner.onMessage(message);
	}
	
	@Test
	public void TestOnMessageWithTrackingExceptionOnCreateTrackingGroup() throws JMSException, TrackingException
	{
		when(message.getText()).thenReturn(text);
		when(trackingService.findSubmitterPartnerGroups(any(),anyLong())).thenReturn(submitterPartnerGroupList);
		when(trackingServiceMethods.createTrackingGroup(anyString(), anyString(), anyString(), anyString(), anyString())).thenThrow(new TrackingException());
		doNothing().when(trackingServiceMethods).batchAddChildrenToParent(anyLong(), any());
		doNothing().when(trackingServiceMethods).batchUpdateGroupEvents(any(), anyString(), anyString(), anyString(), anyString(),anyString());
		doNothing().when(batchOutServiceImpl).putMessageInQueue(anyLong(), anyString(),anyString());
		batchRequestListner.onMessage(message);
	}

	@Test
	public void TestOnMessageWithTrackingExceptionOnBatchAddChildren() throws JMSException, TrackingException
	{
		when(message.getText()).thenReturn(text);
		when(trackingService.findSubmitterPartnerGroups(any(),anyLong())).thenReturn(submitterPartnerGroupList);
		when(trackingServiceMethods.createTrackingGroup(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn((long)141);
		doThrow(new TrackingException()).when(trackingServiceMethods).batchAddChildrenToParent(anyLong(), any());
		doNothing().when(trackingServiceMethods).batchUpdateGroupEvents(any(), anyString(), anyString(), anyString(), anyString(),anyString());
		doNothing().when(batchOutServiceImpl).putMessageInQueue(anyLong(), anyString(),anyString());
		batchRequestListner.onMessage(message);
	}
	
	@Test
	public void TestOnMessageWithTrackingExceptionOnBatchUpdateGroupEvents() throws JMSException, TrackingException
	{
		when(message.getText()).thenReturn(text);
		when(trackingService.findSubmitterPartnerGroups(any(),anyLong())).thenReturn(submitterPartnerGroupList);
		when(trackingServiceMethods.createTrackingGroup(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn((long)141);
		doNothing().when(trackingServiceMethods).batchAddChildrenToParent(anyLong(), any());
		doThrow(new TrackingException()).when(trackingServiceMethods).batchUpdateGroupEvents(any(), anyString(), anyString(), anyString(), anyString(),anyString());
		doNothing().when(batchOutServiceImpl).putMessageInQueue(anyLong(), anyString(),anyString());
		batchRequestListner.onMessage(message);
	}

	

	
	@Test
	public void TestOnMessage() throws JMSException, TrackingException
	{
		when(message.getText()).thenReturn(text);
		when(trackingService.findSubmitterPartnerGroups(any(),anyLong())).thenReturn(submitterPartnerGroupList);
		when(trackingServiceMethods.createTrackingGroup(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn((long)141);
		doNothing().when(trackingServiceMethods).batchAddChildrenToParent(anyLong(), any());
		doNothing().when(trackingServiceMethods).batchUpdateGroupEvents(any(), anyString(), anyString(), anyString(), anyString(),anyString());
		doNothing().when(batchOutServiceImpl).putMessageInQueue(anyLong(), anyString(),anyString());
		batchRequestListner.onMessage(message);
	}
}
