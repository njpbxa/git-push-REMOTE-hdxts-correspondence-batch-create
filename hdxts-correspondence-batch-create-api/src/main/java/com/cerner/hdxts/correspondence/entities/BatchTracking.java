package com.cerner.hdxts.correspondence.entities;

public class BatchTracking 
{
	private String submitterId;
	private String serviceCDF;
	private String sourceName;
	private String type;
	public String getSubmitterId() {
		return submitterId;
	}
	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}
	public String getServiceCDF() {
		return serviceCDF;
	}
	public void setServiceCDF(String serviceCDF) {
		this.serviceCDF = serviceCDF;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
