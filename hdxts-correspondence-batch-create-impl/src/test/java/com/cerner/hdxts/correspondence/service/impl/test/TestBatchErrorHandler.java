package com.cerner.hdxts.correspondence.service.impl.test;

import static org.mockito.Mockito.when;

import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cerner.hdxts.correspondence.entities.BatchError;
import com.cerner.hdxts.correspondence.entities.common.FlatFile;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.service.ITrackingServiceMethods;
import com.cerner.hdxts.correspondence.service.impl.BatchErrorHandler;
import com.cerner.hdxts.correspondence.service.util.FileArchivePathUtility;
import com.cerner.hdxts.correspondence.service.util.FileUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestBatchErrorHandler {

	
	BatchError batchError=new BatchError();
	@Mock
	ITrackingServiceMethods trackingService;
	
	@Mock
	FileArchivePathUtility archivePathUtility;
	
	@Mock
	FileUtil fileUtil;
	
	@Mock
	FlatFile flatFile;
	
	@InjectMocks
	BatchErrorHandler batchErrorHandler;
	
	@Before
	public void setUp()
	{
		batchError.setGroupID((long)111111);
		batchError.setFailureString("failureString");
		batchError.setFileContent("fileContent");
		batchError.setTrxnType("CORRESPONDENCE_REQUEST_BO");
		batchError.setBase("base");
		batchError.setErrorSource("errorSource");
	}
	
	@Test
	public void testHandleErrorWithTrackingExceptionFromAddError() 
	{
		try {
			when(trackingService.addErrorEvent(anyString(), anyString(), anyString())).thenThrow(new TrackingException());
			when(trackingService.updateGroupStatus(anyLong(), anyString(), anyString())).thenReturn(true);
			//when(batchError.getBase()).thenReturn("base");
			when(archivePathUtility.buildArchivePath(anyString(),anyString(), anyString(), anyString())).thenReturn("archivePath");
			when(fileUtil.createFlatFile(flatFile)).thenReturn(true);
			String errorString = batchErrorHandler.handleError(batchError);
			System.out.println(errorString);
			Assert.assertNotNull(errorString);
		} catch (TrackingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHandleErrorWithTrackingExceptionFromUpdateGroup() 
	{
		try {
			when(trackingService.addErrorEvent(anyString(), anyString(), anyString())).thenReturn("SAMPLE");
			when(trackingService.updateGroupStatus(anyLong(), anyString(), anyString())).thenThrow(new TrackingException());
			//when(batchError.getBase()).thenReturn("base");
			when(archivePathUtility.buildArchivePath(anyString(),anyString(), anyString(), anyString())).thenReturn("archivePath");
			when(fileUtil.createFlatFile(flatFile)).thenReturn(true);
			String errorString = batchErrorHandler.handleError(batchError);
			System.out.println(errorString);
			Assert.assertNotNull(errorString);
		} catch (TrackingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHandleErrorWithNoExceptions() 
	{
		try {
			when(trackingService.addErrorEvent(anyString(), anyString(), anyString())).thenReturn("SAMPLE");
			when(trackingService.updateGroupStatus(anyLong(), anyString(), anyString())).thenReturn(true);
			//when(batchError.getBase()).thenReturn("base");
			when(archivePathUtility.buildArchivePath(anyString(),anyString(), anyString(), anyString())).thenReturn("archivePath");
			when(fileUtil.createFlatFile(flatFile)).thenReturn(true);
			String errorString = batchErrorHandler.handleError(batchError);
			System.out.println(errorString);
			Assert.assertNotNull(errorString);
		} catch (TrackingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
