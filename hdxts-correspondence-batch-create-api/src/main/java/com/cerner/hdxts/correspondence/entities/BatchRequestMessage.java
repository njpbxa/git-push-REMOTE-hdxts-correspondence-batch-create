package com.cerner.hdxts.correspondence.entities;

public class BatchRequestMessage 
{
	private Long submitterId;
	private String serviceCategory;
	private String serviceCode;
	private String trxnStatus;
	
	public Long getSubmitterId() {
		return submitterId;
	}
	public void setSubmitterId(Long submitterId) {
		this.submitterId = submitterId;
	}
	public String getServiceCategory() {
		return serviceCategory;
	}
	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getTrxnStatus() {
		return trxnStatus;
	}
	public void setTrxnStatus(String trxnStatus) {
		this.trxnStatus = trxnStatus;
	}
}
