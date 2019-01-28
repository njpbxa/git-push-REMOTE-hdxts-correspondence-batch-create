package com.cerner.hdxts.correspondence.controller;

import com.cerner.hdxts.correspondence.service.IBatchOutService;
import com.cerner.hdxts.correspondence.service.config.CorrespondenceConstant;
import com.cerner.hdxts.correspondence.utils.performance.PerformanceLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Correspondence Service Controller 
 * @author DS042009
 *
 */
@RestController
@RequestMapping({"/BatchOutService"})
public class CorrespondenceController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(CorrespondenceController.class);

	@Autowired
	private IBatchOutService batchOutService;

	@RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public ResponseEntity<String> processBatch(@RequestBody(required=false) String clientRequest, HttpServletRequest httpRequest, HttpServletResponse httpResponse)
	{
		LOGGER.debug("Called processBatch with request {} ", clientRequest);
		PerformanceLogger.processStart(CorrespondenceConstant.PERF_SUBMIT);
		this.batchOutService.processBatchRequest(clientRequest);
		PerformanceLogger.processEnd(CorrespondenceConstant.PERF_SUBMIT);
		return new ResponseEntity<String>("", null, HttpStatus.OK);
	}
}
