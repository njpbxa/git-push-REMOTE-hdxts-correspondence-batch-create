package com.cerner.hdxts.correspondence.statements.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for formalPaymentPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="formalPaymentPlan"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="originalAmountDue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="installmentAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beginDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numberOfPayments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cycleLength" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="endingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "formalPaymentPlan", propOrder = {
    "originalAmountDue",
    "installmentAmount",
    "beginDate",
    "numberOfPayments",
    "cycleLength",
    "endingDate"
})
public class FormalPaymentPlan {

    protected String originalAmountDue;
    protected String installmentAmount;
    protected String beginDate;
    protected String numberOfPayments;
    protected String cycleLength;
    protected String endingDate;

    /**
     * Gets the value of the originalAmountDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalAmountDue() {
        return originalAmountDue;
    }

    /**
     * Sets the value of the originalAmountDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalAmountDue(String value) {
        this.originalAmountDue = value;
    }

    /**
     * Gets the value of the installmentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstallmentAmount() {
        return installmentAmount;
    }

    /**
     * Sets the value of the installmentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstallmentAmount(String value) {
        this.installmentAmount = value;
    }

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDate(String value) {
        this.beginDate = value;
    }

    /**
     * Gets the value of the numberOfPayments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfPayments() {
        return numberOfPayments;
    }

    /**
     * Sets the value of the numberOfPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfPayments(String value) {
        this.numberOfPayments = value;
    }

    /**
     * Gets the value of the cycleLength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCycleLength() {
        return cycleLength;
    }

    /**
     * Sets the value of the cycleLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCycleLength(String value) {
        this.cycleLength = value;
    }

    /**
     * Gets the value of the endingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndingDate() {
        return endingDate;
    }

    /**
     * Sets the value of the endingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndingDate(String value) {
        this.endingDate = value;
    }

}
