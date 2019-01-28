package com.cerner.hdxts.correspondence.transformation.dto;

import lombok.Data;

/**
 * TX Transformation Business Exception that does NOT extend Exception in order
 * to return the error without the stack trace.
 * 
 */
@Data
public class TxTransformationServiceBusinessException {

    private String txErrorCode;
    private String txErrorMessage;
    private String auditLog;
    
	public String getTxErrorCode() {
		return txErrorCode;
	}
	public void setTxErrorCode(String txErrorCode) {
		this.txErrorCode = txErrorCode;
	}
	public String getTxErrorMessage() {
		return txErrorMessage;
	}
	public void setTxErrorMessage(String txErrorMessage) {
		this.txErrorMessage = txErrorMessage;
	}
	public String getAuditLog() {
		return auditLog;
	}
	public void setAuditLog(String auditLog) {
		this.auditLog = auditLog;
	}
}
