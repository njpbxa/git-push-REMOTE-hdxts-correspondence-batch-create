package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for Name complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Name"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FORMATTED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MIDDLE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NAME_PREFIX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NAME_SUFFIX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Name", propOrder = {
    "formattedname",
    "firstname",
    "middlename",
    "lastname",
    "nameprefix",
    "namesuffix"
})
public class Name {

    @XmlElement(name = "FORMATTED_NAME")
    @JsonProperty(value="FORMATTED_NAME")
    protected String formattedname;
    @XmlElement(name = "FIRST_NAME")
    @JsonProperty(value="FIRST_NAME")
    protected String firstname;
    @XmlElement(name = "MIDDLE_NAME")
    @JsonProperty(value="MIDDLE_NAME")
    protected String middlename;
    @XmlElement(name = "LAST_NAME")
    @JsonProperty(value="LAST_NAME")
    protected String lastname;
    @XmlElement(name = "NAME_PREFIX")
    @JsonProperty(value="NAME_PREFIX")
    protected String nameprefix;
    @XmlElement(name = "NAME_SUFFIX")
    @JsonProperty(value="NAME_SUFFIX")
    protected String namesuffix;

    /**
     * Gets the value of the formattedname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFORMATTEDNAME() {
        return formattedname;
    }

    /**
     * Sets the value of the formattedname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFORMATTEDNAME(String value) {
        this.formattedname = value;
    }

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIRSTNAME() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIRSTNAME(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the middlename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMIDDLENAME() {
        return middlename;
    }

    /**
     * Sets the value of the middlename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMIDDLENAME(String value) {
        this.middlename = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTNAME() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTNAME(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the nameprefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAMEPREFIX() {
        return nameprefix;
    }

    /**
     * Sets the value of the nameprefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAMEPREFIX(String value) {
        this.nameprefix = value;
    }

    /**
     * Gets the value of the namesuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAMESUFFIX() {
        return namesuffix;
    }

    /**
     * Sets the value of the namesuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAMESUFFIX(String value) {
        this.namesuffix = value;
    }

}
