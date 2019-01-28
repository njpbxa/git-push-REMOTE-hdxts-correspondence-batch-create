package com.cerner.hdxts.correspondence.service.mqutils.test;

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

import com.cerner.edi.tracking.service.utils.MQUtilsImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestMQUtilsImpl {

	@InjectMocks
	MQUtilsImpl mqUtilsImpl;
	
	@Test
	public void Test1()
	{
		
	}
}
