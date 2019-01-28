package com.cerner.hdxts.correspondence.service.config.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.cerner.hdxts.correspondence.service.config.NameSpacePrefix;

@RunWith(MockitoJUnitRunner.class)
public class TestNameSpacePrefix {

	String result;
	private static final String ST_URI = "http://www.cerner.com/edi/correspondence/statements";
	private static final String ST_PREFIX = "st";
	private static final String MODEL_URI = "http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model";
	private static final String MODEL_PREFIX = "model";
	
	@InjectMocks
	NameSpacePrefix nameSpacePrefix;
	@Test
	public void TestGetPreferredPrefixUsingST_URI()
	{
		result = nameSpacePrefix.getPreferredPrefix(ST_URI, "suggestion", true);
		assertEquals(ST_PREFIX, result);
		//System.out.println(result);
	}
	
	@Test
	public void TestGetPreferredPrefixUsingMODEL_URI()
	{
		result = nameSpacePrefix.getPreferredPrefix(MODEL_URI, "suggestion", true);
		assertEquals(MODEL_PREFIX, result);
		//System.out.println(result);
	}
	
	@Test
	public void TestGetPreferredPrefix()
	{
		result = nameSpacePrefix.getPreferredPrefix("sample", "suggestion", true);
		assertEquals("suggestion", result);
		//System.out.println(result);
	}
}
