package com.cerner.hdxts.correspondence.statements.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statementBatchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statementBatchResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="interchangeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amountDue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statementDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="error" type="{http://www.cerner.com/edi/correspondence/statements}error" minOccurs="0"/&gt;
 *         &lt;element name="standardizedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="originalAddress" type="{http://www.cerner.com/edi/correspondence/statements}Address" minOccurs="0"/&gt;
 *         &lt;element name="standardizedAddress" type="{http://www.cerner.com/edi/correspondence/statements}Address" minOccurs="0"/&gt;
 *         &lt;element name="movedAddress" type="{http://www.cerner.com/edi/correspondence/statements}Address" minOccurs="0"/&gt;
 *         &lt;element name="forward" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="moveEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="physicalPages" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statementBatchResponse", propOrder = {
    "interchangeId",
    "accountNumber",
    "fileName",
    "amountDue",
    "statementDate",
    "status",
    "addressType",
    "error",
    "standardizedName",
    "originalAddress",
    "standardizedAddress",
    "movedAddress",
    "forward",
    "moveEffectiveDate",
    "physicalPages"
})
public class StatementBatchResponse {

    protected String interchangeId;
    protected String accountNumber;
    protected String fileName;
    protected String amountDue;
    protected String statementDate;
    protected String status;
    protected String addressType;
    protected Error error;
    protected String standardizedName;
    protected Address originalAddress;
    protected Address standardizedAddress;
    protected Address movedAddress;
    protected String forward;
    protected String moveEffectiveDate;
    protected String physicalPages;

    /**
     * Gets the value of the interchangeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterchangeId() {
        return interchangeId;
    }

    /**
     * Sets the value of the interchangeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterchangeId(String value) {
        this.interchangeId = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the amountDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountDue() {
        return amountDue;
    }

    /**
     * Sets the value of the amountDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountDue(String value) {
        this.amountDue = value;
    }

    /**
     * Gets the value of the statementDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatementDate() {
        return statementDate;
    }

    /**
     * Sets the value of the statementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatementDate(String value) {
        this.statementDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
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
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressType(String value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getError() {
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
    public void setError(Error value) {
        this.error = value;
    }

    /**
     * Gets the value of the standardizedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandardizedName() {
        return standardizedName;
    }

    /**
     * Sets the value of the standardizedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandardizedName(String value) {
        this.standardizedName = value;
    }

    /**
     * Gets the value of the originalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getOriginalAddress() {
        return originalAddress;
    }

    /**
     * Sets the value of the originalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setOriginalAddress(Address value) {
        this.originalAddress = value;
    }

    /**
     * Gets the value of the standardizedAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getStandardizedAddress() {
        return standardizedAddress;
    }

    /**
     * Sets the value of the standardizedAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setStandardizedAddress(Address value) {
        this.standardizedAddress = value;
    }

    /**
     * Gets the value of the movedAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getMovedAddress() {
        return movedAddress;
    }

    /**
     * Sets the value of the movedAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setMovedAddress(Address value) {
        this.movedAddress = value;
    }

    /**
     * Gets the value of the forward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForward() {
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
    public void setForward(String value) {
        this.forward = value;
    }

    /**
     * Gets the value of the moveEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoveEffectiveDate() {
        return moveEffectiveDate;
    }

    /**
     * Sets the value of the moveEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoveEffectiveDate(String value) {
        this.moveEffectiveDate = value;
    }

    /**
     * Gets the value of the physicalPages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhysicalPages() {
        return physicalPages;
    }

    /**
     * Sets the value of the physicalPages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhysicalPages(String value) {
        this.physicalPages = value;
    }

}
