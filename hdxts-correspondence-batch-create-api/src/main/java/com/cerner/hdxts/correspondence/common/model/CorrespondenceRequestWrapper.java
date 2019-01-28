package com.cerner.hdxts.correspondence.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.cerner.hdxts.correspondence.letters.model.CorrespondenceRequest;
import com.cerner.hdxts.correspondence.statements.model.StatementRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrespondenceRequestWrapper", propOrder = {
		"correspondenceRequest",
		"statementRequest"
})
public class CorrespondenceRequestWrapper 
{
	/**
	 * Correspondence Request
	 */
	private CorrespondenceRequest correspondenceRequest;
	
	/**
	 * Statement Request
	 */
	private StatementRequest statementRequest;

	/**
	 * Return Correspondence Request
	 * @return
	 */
	public CorrespondenceRequest getCorrespondenceRequest() {
		return correspondenceRequest;
	}
	
	/**
	 * Set Correspondence Request
	 * @param correspondenceRequest
	 */
	public void setCorrespondenceRequest(CorrespondenceRequest correspondenceRequest) {
		this.correspondenceRequest = correspondenceRequest;
	}
	
	/**
	 * Returns statement request
	 * @return
	 */
	public StatementRequest getStatementRequest() {
		return statementRequest;
	}
	
	/**
	 * Set statement request
	 * @param statementRequest
	 */
	public void setStatementRequest(StatementRequest statementRequest) {
		this.statementRequest = statementRequest;
	}
}
