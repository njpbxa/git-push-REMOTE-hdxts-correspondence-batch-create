package com.cerner.hdxts.correspondence.service.impl.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cerner.hdxts.correspondence.exception.CorrespondenceServiceException;
import com.cerner.hdxts.correspondence.service.impl.TransformationRestClient;
import com.cerner.hdxts.correspondence.transformation.dto.TxTransformationRequest;

@RunWith(MockitoJUnitRunner.class)
public class TestTransformationRestClient {

	TxTransformationRequest txTransformationRequest= new TxTransformationRequest();
//	ResponseEntity<String> responseEntity = new ResponseEntity<String>(null);
	
	@Mock
	RestTemplate restTemplate;
	
	@InjectMocks
	TransformationRestClient transformationRestClient;
	
	@Before
	public void SetUp()
	{
		txTransformationRequest.setMapPath("mapPath");
	}
	
	@Test
	public void TestTransformMapWithExceptionDuringRestCall()
	{
		
		//when(restTemplate.postForEntity(any(), any(), any())).thenReturn()
		try {
			transformationRestClient.transformMap(txTransformationRequest, "transformationServiceURL");
		} catch (CorrespondenceServiceException e) {
			String expected = "Exception during rest call to transformationService";
			assertEquals(expected,e.getMessage());
		}
	}
}
