package com.cerner.hdxts.correspondence.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cerner.hdxts.correspondence.exception.CorrespondenceServiceException;
import com.cerner.hdxts.correspondence.transformation.dto.TxTransformationRequest;
import com.cerner.hdxts.correspondence.transformation.dto.TxTransformationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author DS042009
 *
 */
@Component
public class TransformationRestClient
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TransformationRestClient.class);
	@Autowired
	private RestTemplate restTemplate;

	public TxTransformationResponse transformMap(TxTransformationRequest txTransformationRequest, String transformationServiceURL)
			throws CorrespondenceServiceException
	{
		TxTransformationResponse txTransformationResponse = new TxTransformationResponse();
		HttpHeaders httpHeader = new HttpHeaders();
		ObjectMapper mapper = new ObjectMapper();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		try
		{
			HttpEntity<String> request = new HttpEntity<String>(mapper.writeValueAsString(txTransformationRequest), httpHeader);
			txTransformationResponse = mapper.readValue((String)this.restTemplate.postForEntity(transformationServiceURL, request, String.class, new Object[0]).getBody(), TxTransformationResponse.class);
		}
		catch (JsonProcessingException e)
		{
			LOGGER.error("Caught JsonProcessingException, Reason: {}", e.getMessage());
			throw new CorrespondenceServiceException("JsonProcessingException while marshalling TransformationRequest");
		}
		catch (RestClientException|IOException e)
		{
			LOGGER.error("Caught RestClientException|IOException, Reason: {}", e.getMessage());
			throw new CorrespondenceServiceException("RestClientException during rest call to transformationService");
		}
		catch(Exception e)
		{
			LOGGER.error("Caught Exception, Reason: {}", e.getMessage());
			throw new CorrespondenceServiceException("Exception during rest call to transformationService");
		}
		return txTransformationResponse;
	}
}
