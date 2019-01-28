package com.cerner.hdxts.correspondence.transformation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TX Transformation Processing Exception
 * 
 * @author Andy G. Nelson (AN024531)
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TxTransformationProcessingException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1660837176521081018L;

    private String txErrorCode;
    private String txErrorMessage;
    private String auditLog;

    public TxTransformationProcessingException(String txErrorCode, String txErrorMessage, String auditLog) {
        super(txErrorMessage);
        this.txErrorCode = txErrorCode;
        this.txErrorMessage = txErrorMessage;
        this.auditLog = auditLog;
    }

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
