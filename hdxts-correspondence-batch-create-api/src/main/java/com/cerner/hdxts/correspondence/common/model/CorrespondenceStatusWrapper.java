package com.cerner.hdxts.correspondence.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.cerner.hdxts.correspondence.statements.model.Status;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrespondenceStatusWrapper", propOrder = {
    "correspondenceStatus",
    "status"
})
public class CorrespondenceStatusWrapper 
{
	@XmlElement(name = "CORRESPONDENCE_STATUS")
	private CorrespondenceStatus correspondenceStatus;
	
	@XmlElement(name = "status")
	private Status status;
	
	public CorrespondenceStatus getCorrespondenceStatus() {
		return correspondenceStatus;
	}
	public void setCorrespondenceStatus(CorrespondenceStatus correspondenceStatus) {
		this.correspondenceStatus = correspondenceStatus;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
