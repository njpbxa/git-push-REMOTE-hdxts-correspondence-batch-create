package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CorrespondenceBatchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CorrespondenceBatchResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="INTERCHANGE_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ACCOUNT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FILE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AMOUNT_DUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="STATEMENT_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ERROR" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Error" minOccurs="0"/&gt;
 *         &lt;element name="STANDARDIZED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ORIGINAL_ADDRESS" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Address" minOccurs="0"/&gt;
 *         &lt;element name="STANDARDIZED_ADDRESS" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Address" minOccurs="0"/&gt;
 *         &lt;element name="MOVED_ADDRESS" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Address" minOccurs="0"/&gt;
 *         &lt;element name="FORWARD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MOVE_EFFECTIVE_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PHYSICAL_PAGES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrespondenceBatchResponse", propOrder = {
    "interchangeid",
    "accountnumber",
    "filename",
    "amountdue",
    "statementdate",
    "status",
    "addresstype",
    "error",
    "standardizedname",
    "originaladdress",
    "standardizedaddress",
    "movedaddress",
    "forward",
    "moveeffectivedate",
    "physicalpages"
})
public class CorrespondenceBatchResponse {

    @XmlElement(name = "INTERCHANGE_ID")
    protected String interchangeid;
    @XmlElement(name = "ACCOUNT_NUMBER")
    protected String accountnumber;
    @XmlElement(name = "FILE_NAME")
    protected String filename;
    @XmlElement(name = "AMOUNT_DUE")
    protected String amountdue;
    @XmlElement(name = "STATEMENT_DATE")
    protected String statementdate;
    @XmlElement(name = "STATUS")
    protected String status;
    @XmlElement(name = "ADDRESS_TYPE")
    protected String addresstype;
    @XmlElement(name = "ERROR")
    protected Error error;
    @XmlElement(name = "STANDARDIZED_NAME")
    protected String standardizedname;
    @XmlElement(name = "ORIGINAL_ADDRESS")
    protected Address originaladdress;
    @XmlElement(name = "STANDARDIZED_ADDRESS")
    protected Address standardizedaddress;
    @XmlElement(name = "MOVED_ADDRESS")
    protected Address movedaddress;
    @XmlElement(name = "FORWARD")
    protected String forward;
    @XmlElement(name = "MOVE_EFFECTIVE_DATE")
    protected String moveeffectivedate;
    @XmlElement(name = "PHYSICAL_PAGES")
    protected String physicalpages;

    /**
     * Gets the value of the interchangeid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTERCHANGEID() {
        return interchangeid;
    }

    /**
     * Sets the value of the interchangeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTERCHANGEID(String value) {
        this.interchangeid = value;
    }

    /**
     * Gets the value of the accountnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCOUNTNUMBER() {
        return accountnumber;
    }

    /**
     * Sets the value of the accountnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCOUNTNUMBER(String value) {
        this.accountnumber = value;
    }

    /**
     * Gets the value of the filename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFILENAME() {
        return filename;
    }

    /**
     * Sets the value of the filename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFILENAME(String value) {
        this.filename = value;
    }

    /**
     * Gets the value of the amountdue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMOUNTDUE() {
        return amountdue;
    }

    /**
     * Sets the value of the amountdue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMOUNTDUE(String value) {
        this.amountdue = value;
    }

    /**
     * Gets the value of the statementdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATEMENTDATE() {
        return statementdate;
    }

    /**
     * Sets the value of the statementdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATEMENTDATE(String value) {
        this.statementdate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUS(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the addresstype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRESSTYPE() {
        return addresstype;
    }

    /**
     * Sets the value of the addresstype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRESSTYPE(String value) {
        this.addresstype = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getERROR() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setERROR(Error value) {
        this.error = value;
    }

    /**
     * Gets the value of the standardizedname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTANDARDIZEDNAME() {
        return standardizedname;
    }

    /**
     * Sets the value of the standardizedname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTANDARDIZEDNAME(String value) {
        this.standardizedname = value;
    }

    /**
     * Gets the value of the originaladdress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getORIGINALADDRESS() {
        return originaladdress;
    }

    /**
     * Sets the value of the originaladdress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setORIGINALADDRESS(Address value) {
        this.originaladdress = value;
    }

    /**
     * Gets the value of the standardizedaddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getSTANDARDIZEDADDRESS() {
        return standardizedaddress;
    }

    /**
     * Sets the value of the standardizedaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setSTANDARDIZEDADDRESS(Address value) {
        this.standardizedaddress = value;
    }

    /**
     * Gets the value of the movedaddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getMOVEDADDRESS() {
        return movedaddress;
    }

    /**
     * Sets the value of the movedaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setMOVEDADDRESS(Address value) {
        this.movedaddress = value;
    }

    /**
     * Gets the value of the forward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFORWARD() {
        return forward;
    }

    /**
     * Sets the value of the forward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFORWARD(String value) {
        this.forward = value;
    }

    /**
     * Gets the value of the moveeffectivedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMOVEEFFECTIVEDATE() {
        return moveeffectivedate;
    }

    /**
     * Sets the value of the moveeffectivedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMOVEEFFECTIVEDATE(String value) {
        this.moveeffectivedate = value;
    }

    /**
     * Gets the value of the physicalpages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHYSICALPAGES() {
        return physicalpages;
    }

    /**
     * Sets the value of the physicalpages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHYSICALPAGES(String value) {
        this.physicalpages = value;
    }

}
