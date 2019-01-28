package com.cerner.hdxts.correspondence;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cerner.hdxts.correspondence.controller.CorrespondenceController;
import com.cerner.hdxts.correspondence.service.IBatchOutService;

@RunWith(MockitoJUnitRunner.class)
public class TestingController {

	ResponseEntity<String> res;//=  new ResponseEntity("", null, HttpStatus.OK);
	
	@Mock
	IBatchOutService batchOutService;
	@Mock
	HttpServletRequest httpRequest;
	@Mock
	HttpServletResponse httpResponse;
	
	@InjectMocks
	CorrespondenceController correspondenceController;
	@Test
	public void testProcessBatch()
	{
		//doNothing().when(batchOutService).processBatchRequest(anyString());
		res=correspondenceController.processBatch("clientRequest", httpRequest, httpResponse);
		Assert.assertNotNull(res);
	}
}
