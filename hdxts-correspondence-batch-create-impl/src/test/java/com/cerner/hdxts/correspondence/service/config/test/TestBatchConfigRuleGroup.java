package com.cerner.hdxts.correspondence.service.config.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cerner.hdxts.correspondence.entities.BatchConfiguration;
import com.cerner.hdxts.correspondence.entities.BatchRequest;
import com.cerner.hdxts.correspondence.service.config.BatchConfigRuleGroup;

@RunWith(MockitoJUnitRunner.class)
public class TestBatchConfigRuleGroup {

	BatchRequest batchRequest = new BatchRequest();
	BatchConfiguration batchConfiguration;
	@InjectMocks
	BatchConfigRuleGroup batchConfigRuleGroup;
	@Test
	public void testGetConfigByBatchRequestForStatements()
	{
		batchRequest.setTransactionType("CORRESPONDENCE_STATEMENTS");
		batchConfiguration = batchConfigRuleGroup.getConfigByBatchRequest(batchRequest);
		Assert.assertNotNull(batchConfiguration);
	}
	@Test
	public void testGetConfigByBatchRequestForLetter()
	{
		batchRequest.setTransactionType("CORRESPONDENCE_LETTERS");
		batchConfiguration = batchConfigRuleGroup.getConfigByBatchRequest(batchRequest);
		Assert.assertNotNull(batchConfiguration);
	}
}
