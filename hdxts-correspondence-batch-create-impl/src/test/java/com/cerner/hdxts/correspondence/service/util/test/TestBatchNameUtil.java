package com.cerner.hdxts.correspondence.service.util.test;

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

import com.cerner.hdxts.correspondence.service.util.BatchNameUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestBatchNameUtil {

	@InjectMocks
	BatchNameUtil batchNameUtil;
	@Test
	public void TestRemoveTMPExtensionErrorScenario()
	{
		String returnValue = batchNameUtil.removeTMPExtension("DoesNotContainTMPExtension");
		assertEquals(returnValue,"DoesNotContainTMPExtension");
	}
	
	@Test
	public void TestRemoveTMPExtension()
	{
		String returnValue = batchNameUtil.removeTMPExtension("DoesContainExtension.TMP");
		assertEquals(returnValue,"DoesContainExtension");
	}
	@Test
	public void TestCreateErrorFilename()
	{
		String returnValue = batchNameUtil.createErrorFilename("detail");
		System.out.println(returnValue);
	}
	
	@Test(expected = IllegalStateException.class)
	public void TestGetBatchIDWithoutMatch()
	{
		batchNameUtil.getBatchId("filename");
	}
}
