package com.cerner.hdxts.correspondence.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.cerner.hdxts.correspondence.letters.model.Address;
import com.cerner.hdxts.correspondence.letters.model.Errors;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrespondenceStatus", propOrder = {
    "status",
    "description",
    "image",
    "standardizedName",
    "addressType",
    "address",
    "errors",
    "forward",
    "moveEffectiveDate"
})
public class CorrespondenceStatus 
{
	@XmlElement(name = "STATUS")
	private String status;
	@XmlElement(name = "DESCRIPTION")
	private String description;
	@XmlElement(name = "IMAGE")
	private String image;
	@XmlElement(name = "STANDARDIZED_NAME")
	private String standardizedName;
	@XmlElement(name = "ADDRESS_TYPE")
	private String addressType;
	@XmlElement(name = "ADDRESS")
	private Address address;
	@XmlElement(name = "ERRORS")
	private Errors errors;
	@XmlElement(name = "FORWARD")
	private String forward;
	@XmlElement(name = "MOVE_EFFECTIVE_DATE")
	private String moveEffectiveDate;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStandardizedName() {
		return standardizedName;
	}
	public void setStandardizedName(String standardizedName) {
		this.standardizedName = standardizedName;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Errors getErrors() {
		return errors;
	}
	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	public String getMoveEffectiveDate() {
		return moveEffectiveDate;
	}
	public void setMoveEffectiveDate(String moveEffectiveDate) {
		this.moveEffectiveDate = moveEffectiveDate;
	}
}
