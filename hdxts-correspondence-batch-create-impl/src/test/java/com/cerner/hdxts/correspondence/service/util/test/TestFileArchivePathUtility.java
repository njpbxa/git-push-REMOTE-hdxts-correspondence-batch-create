package com.cerner.hdxts.correspondence.service.util.test;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
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

import com.cerner.hdxts.correspondence.service.util.FileArchivePathUtility;


@RunWith(MockitoJUnitRunner.class)
public class TestFileArchivePathUtility {

	@InjectMocks
	FileArchivePathUtility fileArchivePathUtility;
	
	@Test
	public void TestFileArchivePathUtilityWithoutMapping()
	{
		String returnValue = fileArchivePathUtility.buildArchivePath("base", "quad","trxnType", "direction");
		File archiveFile = new File(returnValue);
		archiveFile.delete();
		assertNotNull(returnValue);
	}

	@Test(expected=IllegalArgumentException.class)
	public void TestFileArchivePathUtilityNoTextInBase()
	{
		fileArchivePathUtility.buildArchivePath("", "quad","CORRESPONDENCE_REQUEST_BO", "direction");
	}
	
	@Test
	public void TestFileArchivePathUtility()
	{
		String returnValue = fileArchivePathUtility.buildArchivePath("base", "quad","CORRESPONDENCE_REQUEST_BO", "direction");
		File archiveFile = new File(returnValue);
		archiveFile.delete();
		assertNotNull(returnValue);
	}
}
