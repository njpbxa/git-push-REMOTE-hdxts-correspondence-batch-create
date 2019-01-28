package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for Encounter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Encounter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="REGISTRATION_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DISCHARGE_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FACILITY" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Facility" minOccurs="0"/&gt;
 *         &lt;element name="FINANCIAL" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Financial" minOccurs="0"/&gt;
 *         &lt;element name="GUARANTOR" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Guarantor" minOccurs="0"/&gt;
 *         &lt;element name="INSURANCE" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Insurance" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Encounter", propOrder = {
    "number",
    "registrationdate",
    "dischargedate",
    "facility",
    "financial",
    "guarantor",
    "insurance"
})
public class Encounter {

    @XmlElement(name = "NUMBER")
    @JsonProperty(value="NUMBER")
    protected String number;
    @XmlElement(name = "REGISTRATION_DATE")
    @JsonProperty(value="REGISTRATION_DATE")
    protected String registrationdate;
    @XmlElement(name = "DISCHARGE_DATE")
    @JsonProperty(value="DISCHARGE_DATE")
    protected String dischargedate;
    @XmlElement(name = "FACILITY")
    @JsonProperty(value="FACILITY")
    protected Facility facility;
    @XmlElement(name = "FINANCIAL")
    @JsonProperty(value="FINANCIAL")
    protected Financial financial;
    @XmlElement(name = "GUARANTOR")
    @JsonProperty(value="GUARANTOR")
    protected Guarantor guarantor;
    @XmlElement(name = "INSURANCE")
    @JsonProperty(value="INSURANCE")
    protected Insurance insurance;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNUMBER() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNUMBER(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the registrationdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREGISTRATIONDATE() {
        return registrationdate;
    }

    /**
     * Sets the value of the registrationdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREGISTRATIONDATE(String value) {
        this.registrationdate = value;
    }

    /**
     * Gets the value of the dischargedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISCHARGEDATE() {
        return dischargedate;
    }

    /**
     * Sets the value of the dischargedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISCHARGEDATE(String value) {
        this.dischargedate = value;
    }

    /**
     * Gets the value of the facility property.
     * 
     * @return
     *     possible object is
     *     {@link Facility }
     *     
     */
    public Facility getFACILITY() {
        return facility;
    }

    /**
     * Sets the value of the facility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Facility }
     *     
     */
    public void setFACILITY(Facility value) {
        this.facility = value;
    }

    /**
     * Gets the value of the financial property.
     * 
     * @return
     *     possible object is
     *     {@link Financial }
     *     
     */
    public Financial getFINANCIAL() {
        return financial;
    }

    /**
     * Sets the value of the financial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Financial }
     *     
     */
    public void setFINANCIAL(Financial value) {
        this.financial = value;
    }

    /**
     * Gets the value of the guarantor property.
     * 
     * @return
     *     possible object is
     *     {@link Guarantor }
     *     
     */
    public Guarantor getGUARANTOR() {
        return guarantor;
    }

    /**
     * Sets the value of the guarantor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Guarantor }
     *     
     */
    public void setGUARANTOR(Guarantor value) {
        this.guarantor = value;
    }

    /**
     * Gets the value of the insurance property.
     * 
     * @return
     *     possible object is
     *     {@link Insurance }
     *     
     */
    public Insurance getINSURANCE() {
        return insurance;
    }

    /**
     * Sets the value of the insurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Insurance }
     *     
     */
    public void setINSURANCE(Insurance value) {
        this.insurance = value;
    }

}
