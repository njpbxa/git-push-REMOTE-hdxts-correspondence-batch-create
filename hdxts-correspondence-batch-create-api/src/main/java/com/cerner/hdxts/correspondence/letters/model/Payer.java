package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for Payer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Payer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GROUP_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GROUP_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="POLICY_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MEMBER_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payer", propOrder = {
    "name",
    "groupname",
    "groupnumber",
    "policynumber",
    "membernumber"
})
public class Payer {

    @XmlElement(name = "NAME")
    @JsonProperty(value="NAME")
    protected String name;
    @XmlElement(name = "GROUP_NAME")
    @JsonProperty(value="GROUP_NAME")
    protected String groupname;
    @XmlElement(name = "GROUP_NUMBER")
    @JsonProperty(value="GROUP_NUMBER")
    protected String groupnumber;
    @XmlElement(name = "POLICY_NUMBER")
    @JsonProperty(value="POLICY_NUMBER")
    protected String policynumber;
    @XmlElement(name = "MEMBER_NUMBER")
    @JsonProperty(value="MEMBER_NUMBER")
    protected String membernumber;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
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
    public void setNAME(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the groupname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUPNAME() {
        return groupname;
    }

    /**
     * Sets the value of the groupname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUPNAME(String value) {
        this.groupname = value;
    }

    /**
     * Gets the value of the groupnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUPNUMBER() {
        return groupnumber;
    }

    /**
     * Sets the value of the groupnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUPNUMBER(String value) {
        this.groupnumber = value;
    }

    /**
     * Gets the value of the policynumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOLICYNUMBER() {
        return policynumber;
    }

    /**
     * Sets the value of the policynumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOLICYNUMBER(String value) {
        this.policynumber = value;
    }

    /**
     * Gets the value of the membernumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMEMBERNUMBER() {
        return membernumber;
    }

    /**
     * Sets the value of the membernumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMEMBERNUMBER(String value) {
        this.membernumber = value;
    }

}
