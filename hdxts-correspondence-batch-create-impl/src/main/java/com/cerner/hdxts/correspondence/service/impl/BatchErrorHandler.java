package com.cerner.hdxts.correspondence.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cerner.hdxts.correspondence.entities.BatchError;
import com.cerner.hdxts.correspondence.entities.common.FlatFile;
import com.cerner.hdxts.correspondence.exception.TrackingException;
import com.cerner.hdxts.correspondence.service.ITrackingServiceMethods;
import com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant;
import com.cerner.hdxts.correspondence.service.util.FileArchivePathUtility;
import com.cerner.hdxts.correspondence.service.util.FileUtil;
import com.cerner.hdxts.correspondence.utils.performance.PerformanceLogger;

@Component
public class BatchErrorHandler 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchErrorHandler.class);

	@Autowired
	private ITrackingServiceMethods trackingService;
	
	@Autowired
	private FileArchivePathUtility archivePathUtility;
	
	@Autowired
	private FileUtil fileUtil;
	
	@Autowired
	private String batchCreateBaseErrorPath;

	public String handleError(BatchError batchError)
	{
		PerformanceLogger.serviceStart(CorrespondenceConstant.PERF_HANDLE_ERROR);
		String dateTimePath = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String groupId = String.valueOf(batchError.getGroupID());

		if(groupId != null && !groupId.isEmpty())
		{
			try 
			{
				trackingService.addErrorEvent(groupId, "ERROR", batchError.getFailureString());
			} 
			catch (TrackingException e) 
			{
				LOGGER.error("Failed to add error event, Reason: {}",e.getMessage());
			}
			try 
			{
				trackingService.updateGroupStatus(Long.valueOf(groupId), "ERROR", "NONE");
			} 
			catch (TrackingException e) 
			{
				LOGGER.error("Failed to update the Group Status, Reason: {}",e.getMessage());
			}
		}
		else
		{
			LOGGER.info("Bypassing ErrorHandler UpdateErrorStatus. No groupId provided.");
		}
		
		String fileContent = batchError.getFileContent();
		if(fileContent != null && !fileContent.isEmpty())
		{
			batchError.setDirection("outbound");
			batchError.setQuad("error");
			batchError.setBase(batchCreateBaseErrorPath);
			
			FlatFile flatFile = new FlatFile();
			String archivePath = archivePathUtility.buildArchivePath(batchError.getBase(), batchError.getQuad(), batchError.getTrxnType(), batchError.getDirection());
			flatFile.setDirectoryPath(archivePath);
			flatFile.setFileName(dateTimePath + "_" + batchError.getTrxnType() + "_" + groupId + ".ERROR");
			flatFile.setContent(batchError.getFileContent() + dateTimePath + batchError.getErrorSource() + batchError.getFailureString());
			flatFile.setCreateFileIfNotExists(true);
			
			try 
			{
				fileUtil.createFlatFile(flatFile);
			} 
			catch (IOException e) 
			{
				LOGGER.error("Failed to create error flat file, Reason: {}",e.getMessage());
			}
		}
		else
		{
			LOGGER.info("Bypassing ErrorHandler CreateErrorFile. No fileContent provided.");
		}

		String errorMessage = "Processing ErrorHandler [GroupId="+ batchError.getGroupID() + ", ErrorSource="+ batchError.getErrorSource() + ", FailureString=" 
				+batchError.getFailureString() + ", FileContent=" + batchError.getFileContent() + ", DateTime=" + dateTimePath + "]";
		LOGGER.debug(errorMessage);

		PerformanceLogger.serviceEnd(CorrespondenceConstant.PERF_HANDLE_ERROR);

		return errorMessage;
	}
}
