package com.cerner.hdxts.correspondence.utils.performance.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.cerner.hdxts.correspondence.utils.performance.PerformanceLogger;

@RunWith(MockitoJUnitRunner.class)
public class TestPerformanceLogger {

	@InjectMocks
	PerformanceLogger performanceLogger;
	
	@Test
	public void TestProcessFail()
	{
		performanceLogger.processFail("abcd");
	}
	
	@Test
	public void TestServiceFail()
	{
		performanceLogger.serviceFail("abcd");
	}
}
