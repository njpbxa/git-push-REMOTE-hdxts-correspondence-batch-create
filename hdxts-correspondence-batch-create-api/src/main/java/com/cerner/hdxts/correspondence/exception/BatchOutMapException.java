package com.cerner.hdxts.correspondence.exception;

import com.cerner.hdxts.correspondence.entities.BatchError;

public class BatchOutMapException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String faultOrigin;
	private String faultStack;
	private String faultCode;
	private String exceptionMessage;
	private String exceptionTpe;
	private String groupId;
	private String operation;
	private String eventId;
	private String message;
	private String transactionType;
	private BatchError batchError;
	
	public BatchOutMapException() 
	{
	}
	public BatchOutMapException(String faultOrigin, String exceptionMessage, String groupId, String transactionType, String message) 
	{
		this.faultOrigin = faultOrigin;
		this.exceptionMessage = exceptionMessage;
		this.groupId = groupId;
		this.transactionType = transactionType;
		this.message = message;
	}
	public BatchOutMapException(BatchError batchError) 
	{
		this.batchError = batchError;
	}
	
	public String getFaultOrigin() {
		return faultOrigin;
	}
	public void setFaultOrigin(String faultOrigin) {
		this.faultOrigin = faultOrigin;
	}
	public String getFaultStack() {
		return faultStack;
	}
	public void setFaultStack(String faultStack) {
		this.faultStack = faultStack;
	}
	public String getFaultCode() {
		return faultCode;
	}
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getExceptionTpe() {
		return exceptionTpe;
	}
	public void setExceptionTpe(String exceptionTpe) {
		this.exceptionTpe = exceptionTpe;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
