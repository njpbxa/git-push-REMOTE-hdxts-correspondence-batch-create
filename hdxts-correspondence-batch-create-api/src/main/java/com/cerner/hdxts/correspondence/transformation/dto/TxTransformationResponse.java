package com.cerner.hdxts.correspondence.transformation.dto;

import java.util.List;

import lombok.Data;

/**
 * TX Transformation Response with all map outputs.
 * 
 */
@Data
public class TxTransformationResponse 
{
    private List<MapData> mapOutputs;
    private String executionWarningCode;
    private String executionWarningMessage;
    private String auditLog;
	
    public List<MapData> getMapOutputs() {
		return mapOutputs;
	}
	public void setMapOutputs(List<MapData> mapOutputs) {
		this.mapOutputs = mapOutputs;
	}
	public String getExecutionWarningCode() {
		return executionWarningCode;
	}
	public void setExecutionWarningCode(String executionWarningCode) {
		this.executionWarningCode = executionWarningCode;
	}
	public String getExecutionWarningMessage() {
		return executionWarningMessage;
	}
	public void setExecutionWarningMessage(String executionWarningMessage) {
		this.executionWarningMessage = executionWarningMessage;
	}
	public String getAuditLog() {
		return auditLog;
	}
	public void setAuditLog(String auditLog) {
		this.auditLog = auditLog;
	}
}
