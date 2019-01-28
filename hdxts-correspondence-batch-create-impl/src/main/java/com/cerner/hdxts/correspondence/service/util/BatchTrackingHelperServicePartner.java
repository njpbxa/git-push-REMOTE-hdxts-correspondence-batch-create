package com.cerner.hdxts.correspondence.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cerner.hdxts.correspondence.entities.BatchTracking;

@Component
public class BatchTrackingHelperServicePartner 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchTrackingHelperServicePartner.class);

	public BatchTracking parseFilename(String filename) 
	{
		LOGGER.debug("Called BatchTrackingHelperServicePartner.parseFilename for filename: {}",filename);
		BatchTracking batchTrackingBO = new BatchTracking(); 
		batchTrackingBO.setSubmitterId(BatchNameUtil.getSubmitterId(filename));
		batchTrackingBO.setSourceName(BatchNameUtil.getSourceName(filename));
		batchTrackingBO.setServiceCDF(BatchNameUtil.getServiceCdf(filename));
		batchTrackingBO.setType(BatchNameUtil.getType(filename));
		return batchTrackingBO;
	}
}
