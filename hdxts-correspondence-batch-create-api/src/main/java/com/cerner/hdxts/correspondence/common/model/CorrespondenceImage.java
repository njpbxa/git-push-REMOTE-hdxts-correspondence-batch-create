package com.cerner.hdxts.correspondence.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrespondenceImage", propOrder = {
		"status", "fileContents"

})
public class CorrespondenceImage 
{
	@XmlElement(name = "status")
	private String status;

	@XmlElement(name = "fileContents")
	@XmlSchemaType(name="hexBinary")
	private byte[] fileContents;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getFileContents() {
		return fileContents;
	}
	public void setFileContents(byte[] fileContents) {
		this.fileContents = fileContents;
	}
}
