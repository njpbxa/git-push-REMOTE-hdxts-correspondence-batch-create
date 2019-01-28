package com.cerner.hdxts.correspondence.statements.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for healthPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="healthPlan"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cobSequence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="policyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="groupNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="claimTransmitDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="insuranceBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billedSinceLastStatement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "healthPlan", propOrder = {
    "cobSequence",
    "name",
    "policyNumber",
    "groupNumber",
    "claimTransmitDate",
    "insuranceBalance",
    "billedSinceLastStatement"
})
public class HealthPlan {

    protected String cobSequence;
    protected String name;
    protected String policyNumber;
    protected String groupNumber;
    protected String claimTransmitDate;
    protected String insuranceBalance;
    protected String billedSinceLastStatement;

    /**
     * Gets the value of the cobSequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCobSequence() {
        return cobSequence;
    }

    /**
     * Sets the value of the cobSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCobSequence(String value) {
        this.cobSequence = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the policyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the value of the policyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyNumber(String value) {
        this.policyNumber = value;
    }

    /**
     * Gets the value of the groupNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupNumber() {
        return groupNumber;
    }

    /**
     * Sets the value of the groupNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupNumber(String value) {
        this.groupNumber = value;
    }

    /**
     * Gets the value of the claimTransmitDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimTransmitDate() {
        return claimTransmitDate;
    }

    /**
     * Sets the value of the claimTransmitDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimTransmitDate(String value) {
        this.claimTransmitDate = value;
    }

    /**
     * Gets the value of the insuranceBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceBalance() {
        return insuranceBalance;
    }

    /**
     * Sets the value of the insuranceBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceBalance(String value) {
        this.insuranceBalance = value;
    }

    /**
     * Gets the value of the billedSinceLastStatement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBilledSinceLastStatement() {
        return billedSinceLastStatement;
    }

    /**
     * Sets the value of the billedSinceLastStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBilledSinceLastStatement(String value) {
        this.billedSinceLastStatement = value;
    }

}
