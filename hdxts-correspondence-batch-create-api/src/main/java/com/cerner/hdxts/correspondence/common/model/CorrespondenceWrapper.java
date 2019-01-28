package com.cerner.hdxts.correspondence.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.cerner.hdxts.correspondence.letters.model.CorrespondenceRequest;
import com.cerner.hdxts.correspondence.statements.model.StatementRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrespondenceWrapper", propOrder = {
    "correspondenceRequest",
    "statementRequest"
})
public class CorrespondenceWrapper 
{
	@XmlElement(name = "letterReq")
	private CorrespondenceRequest correspondenceRequest;
	@XmlElement(name = "statementsReq")
	private StatementRequest statementRequest;
	
	public CorrespondenceRequest getCorrespondenceRequest() {
		return correspondenceRequest;
	}
	public void setCorrespondenceRequest(CorrespondenceRequest correspondenceRequest) {
		this.correspondenceRequest = correspondenceRequest;
	}
	public StatementRequest getStatementRequest() {
		return statementRequest;
	}
	public void setStatementRequest(StatementRequest statementRequest) {
		this.statementRequest = statementRequest;
	}
}
