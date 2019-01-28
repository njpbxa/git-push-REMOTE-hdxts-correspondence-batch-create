package com.cerner.hdxts.correspondence.entities;

public class BatchError 
{
	private long groupID;
	private String errorSource;
	private String failureString;
	private String fileContent;
	private String dateTime;
	private String trxnType;
	private String base;
	private String quad;
	private String direction;

	public long getGroupID() {
		return groupID;
	}
	public void setGroupID(long groupID) {
		this.groupID = groupID;
	}
	public String getErrorSource() {
		return errorSource;
	}
	public void setErrorSource(String errorSource) {
		this.errorSource = errorSource;
	}
	public String getFailureString() {
		return failureString;
	}
	public void setFailureString(String failureString) {
		this.failureString = failureString;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getTrxnType() {
		return trxnType;
	}
	public void setTrxnType(String trxnType) {
		this.trxnType = trxnType;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getQuad() {
		return quad;
	}
	public void setQuad(String quad) {
		this.quad = quad;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
