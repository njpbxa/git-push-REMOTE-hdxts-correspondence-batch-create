package com.cerner.hdxts.correspondence.statements.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for charge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="charge"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="seqNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="units" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cptDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="revenueCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="revenueCodeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderMgmtActivityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dateOfService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="insurancePending" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docNameLast" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "charge", propOrder = {
    "seqNumber",
    "description",
    "units",
    "cptCode",
    "cptDescription",
    "revenueCode",
    "revenueCodeDescription",
    "orderMgmtActivityType",
    "dateOfService",
    "insurancePending",
    "amount",
    "docNameLast",
    "billingDate",
    "transType",
    "payment"
})
public class Charge {

    protected String seqNumber;
    protected String description;
    protected String units;
    protected String cptCode;
    protected String cptDescription;
    protected String revenueCode;
    protected String revenueCodeDescription;
    protected String orderMgmtActivityType;
    protected String dateOfService;
    protected String insurancePending;
    protected String amount;
    protected String docNameLast;
    protected String billingDate;
    protected String transType;
    protected String payment;

    /**
     * Gets the value of the seqNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqNumber() {
        return seqNumber;
    }

    /**
     * Sets the value of the seqNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqNumber(String value) {
        this.seqNumber = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnits(String value) {
        this.units = value;
    }

    /**
     * Gets the value of the cptCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCptCode() {
        return cptCode;
    }

    /**
     * Sets the value of the cptCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCptCode(String value) {
        this.cptCode = value;
    }

    /**
     * Gets the value of the cptDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCptDescription() {
        return cptDescription;
    }

    /**
     * Sets the value of the cptDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCptDescription(String value) {
        this.cptDescription = value;
    }

    /**
     * Gets the value of the revenueCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevenueCode() {
        return revenueCode;
    }

    /**
     * Sets the value of the revenueCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevenueCode(String value) {
        this.revenueCode = value;
    }

    /**
     * Gets the value of the revenueCodeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevenueCodeDescription() {
        return revenueCodeDescription;
    }

    /**
     * Sets the value of the revenueCodeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevenueCodeDescription(String value) {
        this.revenueCodeDescription = value;
    }

    /**
     * Gets the value of the orderMgmtActivityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderMgmtActivityType() {
        return orderMgmtActivityType;
    }

    /**
     * Sets the value of the orderMgmtActivityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderMgmtActivityType(String value) {
        this.orderMgmtActivityType = value;
    }

    /**
     * Gets the value of the dateOfService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfService() {
        return dateOfService;
    }

    /**
     * Sets the value of the dateOfService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfService(String value) {
        this.dateOfService = value;
    }

    /**
     * Gets the value of the insurancePending property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsurancePending() {
        return insurancePending;
    }

    /**
     * Sets the value of the insurancePending property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsurancePending(String value) {
        this.insurancePending = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the docNameLast property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNameLast() {
        return docNameLast;
    }

    /**
     * Sets the value of the docNameLast property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNameLast(String value) {
        this.docNameLast = value;
    }

    /**
     * Gets the value of the billingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingDate() {
        return billingDate;
    }

    /**
     * Sets the value of the billingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingDate(String value) {
        this.billingDate = value;
    }

    /**
     * Gets the value of the transType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransType() {
        return transType;
    }

    /**
     * Sets the value of the transType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransType(String value) {
        this.transType = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayment(String value) {
        this.payment = value;
    }

}
