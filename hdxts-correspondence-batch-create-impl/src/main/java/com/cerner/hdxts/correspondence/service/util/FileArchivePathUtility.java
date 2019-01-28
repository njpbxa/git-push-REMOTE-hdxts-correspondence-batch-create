package com.cerner.hdxts.correspondence.service.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class  FileArchivePathUtility {

	private FileArchivePathUtility(){

	}

	private static final String DATE_FORMAT_yyyyMMdd ="yyyyMMdd";	
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static final Logger logger = LoggerFactory.getLogger(FileArchivePathUtility.class);
	private static final Map<String,String> SERVICE_MAP = new HashMap<String,String>(3);
	private static final Map<String,String> ALIAS_MAP = new HashMap<String,String>(3);	
	static
	{
		SERVICE_MAP.put("CORRESPONDENCE_REQUEST_BO", "CORRESPONDENCE_LETTERS");
		SERVICE_MAP.put("CREDIT_VERIFICATION_REQUEST_BO", "CREDIT_VERIFICATION_BATCH");
		SERVICE_MAP.put("STATEMENTS_REQUEST_BO", "CORRESPONDENCE_STATEMENTS");

		ALIAS_MAP.put("CORRESPONDENCE_REQUEST_BO", "EXPB");
		ALIAS_MAP.put("CREDIT_VERIFICATION_REQUEST_BO", "SA");
		ALIAS_MAP.put("STATEMENTS_REQUEST_BO", "EXPB");
	}

	public String buildArchivePath(String base,String quad,String trxnType,String direction){			

		String currentDate = getCurrentDate();
		String partnerAlias = "BATCH_CREATE";
		String service = "SERVICE";
		if(StringUtils.hasText(trxnType)){
			partnerAlias = ALIAS_MAP.get(trxnType.trim().toUpperCase());
			service  = SERVICE_MAP.get(trxnType.trim().toUpperCase());
			if(partnerAlias==null)
			{
				partnerAlias = "BATCH_CREATE";
			}
			if(service==null)
			{
				service = "SERVICE";
			}
		}		


		if(!StringUtils.hasText(base)){
			throw new IllegalArgumentException("arguments:null or empty in FileArchivePathUtility");
		}	

		StringBuilder archivePath = new StringBuilder(base);

		if(StringUtils.hasText(quad)){
			archivePath.append(FILE_SEPARATOR).append(quad);
		}
		if(StringUtils.hasText(partnerAlias)){
			archivePath.append(FILE_SEPARATOR).append(partnerAlias);
		}
		if(StringUtils.hasText(service)){
			archivePath.append(FILE_SEPARATOR).append(service);
		}
		if(StringUtils.hasText(direction)){
			archivePath.append(FILE_SEPARATOR).append(direction);
		}
		archivePath.append(FILE_SEPARATOR).append(currentDate);

		File archiveFile = new File(archivePath.toString());
		if (!archiveFile.exists()) {            
			archiveFile.mkdirs();
			logger.debug("Created directory for batch create error handler service: " + archivePath.toString());
		}

		return archivePath.toString();		
	}


	private static String getCurrentDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_yyyyMMdd);
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());

	}
}