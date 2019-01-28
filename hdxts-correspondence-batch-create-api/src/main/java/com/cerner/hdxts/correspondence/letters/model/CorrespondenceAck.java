package com.cerner.hdxts.correspondence.letters.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(value={"interchangeId", "errors", "status"})
public class CorrespondenceAck 
{
	@JsonProperty(value="INTERCHANGE_ID")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	protected String interchangeId;
	
	@JsonProperty(value="ERRORS")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	protected Errors errors;
	
	@JsonProperty(value="STATUS")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	protected String status;

	public String getInterchangeId() {
		return interchangeId;
	}
	public void setInterchangeId(String interchangeId) {
		this.interchangeId = interchangeId;
	}
	public Errors getErrors() {
		return errors;
	}
	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
