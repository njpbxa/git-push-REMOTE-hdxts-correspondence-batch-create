package com.cerner.hdxts.correspondence.service.impl.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import com.cerner.edi.tracking.service.domain.TrackingGroup;
import com.cerner.edi.tracking.service.domain.TrackingPartner;
import com.cerner.hdxts.correspondence.entities.BatchCriteria;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.service.ITrackingServiceMethods;
import com.cerner.hdxts.correspondence.service.impl.BatchOutServiceImpl;
import com.cerner.hdxts.correspondence.service.mqutils.MQUtils;

@RunWith(MockitoJUnitRunner.class)
public class TestBatchOutServiceImpl {

	BatchCriteria batchCriteria = new BatchCriteria();
	String request;
	List<Long> submitter_list = new ArrayList<>();
	@Mock
	ITrackingServiceMethods trackingServiceMethods;
	@Mock
	MQUtils mqUtils;
	
	@Mock
	@Qualifier("marshallerForClientRequest")
	Jaxb2Marshaller marshallerForClientRequest;
	
	@Qualifier("marshallerForBatchRequest")
	@Mock
	Jaxb2Marshaller marshallerForBatchRequest;
	
	@InjectMocks
	BatchOutServiceImpl batchOutServiceImpl = new BatchOutServiceImpl();
	
	@Before
	public void SetUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><batchCriteria xmlns:ns0=\"http://BatchOutboundLib/model\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ns0:BatchCriteria\">\r\n" + 
				"  <transactionType>CORRESPONDENCE_STATEMENTS</transactionType>\r\n" + 
				"  <category>REALTIME</category>\r\n" + 
				"  <status>VALIDATED</status>\r\n" + 
				"</batchCriteria>\r\n";
		batchCriteria.setCategory("REALTIME");
		submitter_list.add((long)1);
		submitter_list.add((long)2);
	}
	
	@Test
	public void testProcessBatchRequestWithNullPointerException()
	{
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenThrow(new NullPointerException("null"));
		batchOutServiceImpl.processBatchRequest(request);
	
	}
	
	@Test
	public void testProcessBatchRequestWithNoTransactionType() throws JMSException
	{
		batchCriteria = new BatchCriteria();
		batchCriteria.setStatus("");
		batchCriteria.setCategory("");
		batchCriteria.setTransactionType("");
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		batchOutServiceImpl.processBatchRequest(request);
	}
	

	@Test
	public void testProcessBatchRequestWithIncorrectStatus() throws JMSException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchCriteria.setStatus("INCORRECT");
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	@Test
	public void testProcessBatchRequestThrowingJMSException() throws JMSException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchCriteria.setStatus("VALIDATED");
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findSubmitterList(anyString())).thenReturn(submitter_list);
		doThrow(new JMSException("error")).when(mqUtils).send(anyString(), anyString(), any(), any(), anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	@Test
	public void testProcessBatchRequestWithStatusAsValidatedThrowingJMSError() throws JMSException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchCriteria.setStatus("VALIDATED");
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findSubmitterList(anyString())).thenReturn(submitter_list);
		when(mqUtils.getQueueDepth(any())).thenThrow(new JMSException("ERROR"));
		doNothing().when(mqUtils).send(anyString(), anyString(), any(), any(),anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	@Test
	public void testProcessBatchRequestWithStatusAsValidated() throws JMSException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchCriteria.setStatus("VALIDATED");
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findSubmitterList(anyString())).thenReturn(submitter_list);
		doNothing().when(mqUtils).send(anyString(), anyString(), any(), any(),anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	@Test
	public void testProcessBatchRequestWithStatusAsValidatedAndTransactionAsStatementsRequest() throws JMSException
	{
		batchCriteria.setTransactionType("STATEMENTS_REQUEST_BO");
		batchCriteria.setStatus("VALIDATED");
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findSubmitterList(anyString())).thenReturn(submitter_list);
		doNothing().when(mqUtils).send(anyString(), anyString(), any(), any(),anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	@Test
	public void testProcessBatchRequestWithStatusAsValidatedAndTransactionAsCorrespondenceRequests() throws JMSException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_REQUEST_BO");
		batchCriteria.setStatus("VALIDATED");
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findSubmitterList(anyString())).thenReturn(submitter_list);
		doNothing().when(mqUtils).send(anyString(), anyString(), any(), any(),anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Status is now set as PARTNER_QUEUE_ERROR
	 * 
	 * 
	 * 
	 */
	
	TrackingGroup trackingGroup = new TrackingGroup((long)1, (long)2, (long)3);
	List<TrackingGroup> trackingGroups = new ArrayList<>();
	TrackingPartner partner = new TrackingPartner();
	
	@Test
	public void testProcessBatchRequestThrowsTrackingExceptionForFindGroup() throws JMSException, TrackingException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchCriteria.setStatus("PARTNER_QUEUE_ERROR");
		partner.setAlias("alias");
		trackingGroup.setPartner(partner);
		trackingGroups.add(trackingGroup);
		
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findGroups(any())).thenThrow(new TrackingException());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	
	@Test
	public void testProcessBatchRequestThrowsTrackingExceptionForUpdateGroupStatus() throws JMSException, TrackingException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchCriteria.setStatus("PARTNER_QUEUE_ERROR");
		partner.setAlias("alias");
		trackingGroup.setPartner(partner);
		trackingGroups.add(trackingGroup);
		
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findGroups(any())).thenReturn(trackingGroups);
		when(trackingServiceMethods.updateGroupStatus(anyLong(), anyString(), anyString())).thenThrow(new TrackingException());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	@Test
	public void testProcessBatchRequestWithStatusAsPartnerQueueErrorThrowsJMSException() throws JMSException, TrackingException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchCriteria.setStatus("PARTNER_QUEUE_ERROR");
		partner.setAlias("alias");
		trackingGroup.setPartner(partner);
		trackingGroups.add(trackingGroup);
		
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findGroups(any())).thenReturn(trackingGroups);
		when(trackingServiceMethods.updateGroupStatus(anyLong(), anyString(), anyString())).thenReturn(true);
		doNothing().when(marshallerForBatchRequest).marshal(any(), any());
		doThrow(new JMSException("Error")).when(mqUtils).send(anyString(), anyString(), any(), any(),anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	@Test
	public void testProcessBatchRequestWithStatusAsPartnerQueueErrorThrowingTrackingException() throws JMSException, TrackingException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchCriteria.setStatus("PARTNER_QUEUE_ERROR");
		partner.setAlias("alias");
		trackingGroup.setPartner(partner);
		trackingGroups.add(trackingGroup);
		
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findGroups(any())).thenReturn(trackingGroups);
		when(trackingServiceMethods.updateGroupStatus(anyLong(), anyString(), anyString())).thenThrow(new TrackingException());
		doNothing().when(marshallerForBatchRequest).marshal(any(), any());
		doNothing().when(mqUtils).send(anyString(), anyString(), any(), any(),anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	
	
	@Test
	public void testProcessBatchRequestWithStatusAsPartnerQueueError() throws JMSException, TrackingException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchCriteria.setStatus("PARTNER_QUEUE_ERROR");
		partner.setAlias("alias");
		trackingGroup.setPartner(partner);
		trackingGroups.add(trackingGroup);
		
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findGroups(any())).thenReturn(trackingGroups);
		when(trackingServiceMethods.updateGroupStatus(anyLong(), anyString(), anyString())).thenReturn(true);
		doNothing().when(marshallerForBatchRequest).marshal(any(), any());
		doNothing().when(mqUtils).send(anyString(), anyString(), any(), any(),anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	
	@Test
	public void testProcessBatchRequestWithStatusAsPartnerQueueErrorAndTransactionAsStatementsRequest() throws JMSException, TrackingException
	{
		batchCriteria.setTransactionType("STATEMENTS_REQUEST_BO");
		batchCriteria.setStatus("PARTNER_QUEUE_ERROR");
		partner.setAlias("alias");
		trackingGroup.setPartner(partner);
		trackingGroups.add(trackingGroup);
		
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findGroups(any())).thenReturn(trackingGroups);
		when(trackingServiceMethods.updateGroupStatus(anyLong(), anyString(), anyString())).thenReturn(true);
		doNothing().when(marshallerForBatchRequest).marshal(any(), any());
		doNothing().when(mqUtils).send(anyString(), anyString(), any(), any(),anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	
	
	@Test
	public void testProcessBatchRequestWithStatusAsPartnerQueueErrorAndTransactionAsCorrespondenceRequests() throws JMSException, TrackingException
	{
		batchCriteria.setTransactionType("CORRESPONDENCE_REQUEST_BO");
		batchCriteria.setStatus("PARTNER_QUEUE_ERROR");
		partner.setAlias("alias");
		trackingGroup.setPartner(partner);
		trackingGroups.add(trackingGroup);
		
		when((BatchCriteria)marshallerForClientRequest.unmarshal(new StringSource(anyString()))).thenReturn(batchCriteria);
		when(trackingServiceMethods.findGroups(any())).thenReturn(trackingGroups);
		when(trackingServiceMethods.updateGroupStatus(anyLong(), anyString(), anyString())).thenReturn(true);
		doNothing().when(marshallerForBatchRequest).marshal(any(), any());
		doNothing().when(mqUtils).send(anyString(), anyString(), any(), any(),anyLong());
		batchOutServiceImpl.processBatchRequest(request);
	}
	
	@Test
	public void TestIsNullEmpty()
	{
		boolean value = batchOutServiceImpl.isNullEmpty("str");
		assertEquals(value, false);
	}
	
}
