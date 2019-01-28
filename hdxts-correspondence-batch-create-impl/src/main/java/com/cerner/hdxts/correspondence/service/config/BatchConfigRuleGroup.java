package com.cerner.hdxts.correspondence.service.config;

import com.cerner.hdxts.correspondence.entities.BatchConfiguration;
import com.cerner.hdxts.correspondence.entities.BatchRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author DS042009
 *
 */
@Component
public class BatchConfigRuleGroup
{
	@Autowired
	@Qualifier("statementMapLocation")
	private String statementMapLocation;
	
	@Autowired
	@Qualifier("lettersMapLocation")
	private String lettersMapLocation;
	
	public BatchConfiguration getConfigByBatchRequest(BatchRequest batchRequest)
	{
		BatchConfiguration batchConfiguration = null;
		if ((batchRequest != null) && (batchRequest.getTransactionType() != null) && (!batchRequest.getTransactionType().isEmpty())) {
			if (batchRequest.getTransactionType().equals("CORRESPONDENCE_STATEMENTS"))
			{
				batchConfiguration = new BatchConfiguration();
				batchConfiguration.setMapLocation(statementMapLocation);
				batchConfiguration.setFileExtension("STA");
				batchConfiguration.setSourceName("BatchCreate");
				batchConfiguration.setBatchTypeCDF("PARTNER_REQUEST");
				batchConfiguration.setServiceCDF("CORRESPONDENCE_STATEMENTS");
			}
			else if (batchRequest.getTransactionType().equals("CORRESPONDENCE_LETTERS"))
			{
				batchConfiguration = new BatchConfiguration();
				batchConfiguration.setMapLocation(lettersMapLocation);
				batchConfiguration.setFileExtension("ELE");
				batchConfiguration.setSourceName("BatchCreate");
				batchConfiguration.setBatchTypeCDF("PARTNER_REQUEST");
				batchConfiguration.setServiceCDF("CORRESPONDENCE_LETTERS");
			}
		}
		return batchConfiguration;
	}
}
