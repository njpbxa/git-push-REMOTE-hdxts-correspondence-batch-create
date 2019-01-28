package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for CustomFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomFields"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CUSTOM_FIELD1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELD2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELD3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELD4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELD5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELD6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELD7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELD8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELD9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELD10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomFields", propOrder = {
    "customfield1",
    "customfield2",
    "customfield3",
    "customfield4",
    "customfield5",
    "customfield6",
    "customfield7",
    "customfield8",
    "customfield9",
    "customfield10"
})
public class CustomFields {

    @XmlElement(name = "CUSTOM_FIELD1")
    @JsonProperty(value="CUSTOM_FIELD1")
    protected String customfield1;
    @XmlElement(name = "CUSTOM_FIELD2")
    @JsonProperty(value="CUSTOM_FIELD2")
    protected String customfield2;
    @XmlElement(name = "CUSTOM_FIELD3")
    @JsonProperty(value="CUSTOM_FIELD3")
    protected String customfield3;
    @XmlElement(name = "CUSTOM_FIELD4")
    @JsonProperty(value="CUSTOM_FIELD4")
    protected String customfield4;
    @XmlElement(name = "CUSTOM_FIELD5")
    @JsonProperty(value="CUSTOM_FIELD5")
    protected String customfield5;
    @XmlElement(name = "CUSTOM_FIELD6")
    @JsonProperty(value="CUSTOM_FIELD6")
    protected String customfield6;
    @XmlElement(name = "CUSTOM_FIELD7")
    @JsonProperty(value="CUSTOM_FIELD7")
    protected String customfield7;
    @XmlElement(name = "CUSTOM_FIELD8")
    @JsonProperty(value="CUSTOM_FIELD8")
    protected String customfield8;
    @XmlElement(name = "CUSTOM_FIELD9")
    @JsonProperty(value="CUSTOM_FIELD9")
    protected String customfield9;
    @XmlElement(name = "CUSTOM_FIELD10")
    @JsonProperty(value="CUSTOM_FIELD10")
    protected String customfield10;

    /**
     * Gets the value of the customfield1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD1() {
        return customfield1;
    }

    /**
     * Sets the value of the customfield1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD1(String value) {
        this.customfield1 = value;
    }

    /**
     * Gets the value of the customfield2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD2() {
        return customfield2;
    }

    /**
     * Sets the value of the customfield2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD2(String value) {
        this.customfield2 = value;
    }

    /**
     * Gets the value of the customfield3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD3() {
        return customfield3;
    }

    /**
     * Sets the value of the customfield3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD3(String value) {
        this.customfield3 = value;
    }

    /**
     * Gets the value of the customfield4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD4() {
        return customfield4;
    }

    /**
     * Sets the value of the customfield4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD4(String value) {
        this.customfield4 = value;
    }

    /**
     * Gets the value of the customfield5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD5() {
        return customfield5;
    }

    /**
     * Sets the value of the customfield5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD5(String value) {
        this.customfield5 = value;
    }

    /**
     * Gets the value of the customfield6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD6() {
        return customfield6;
    }

    /**
     * Sets the value of the customfield6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD6(String value) {
        this.customfield6 = value;
    }

    /**
     * Gets the value of the customfield7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD7() {
        return customfield7;
    }

    /**
     * Sets the value of the customfield7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD7(String value) {
        this.customfield7 = value;
    }

    /**
     * Gets the value of the customfield8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD8() {
        return customfield8;
    }

    /**
     * Sets the value of the customfield8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD8(String value) {
        this.customfield8 = value;
    }

    /**
     * Gets the value of the customfield9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD9() {
        return customfield9;
    }

    /**
     * Sets the value of the customfield9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD9(String value) {
        this.customfield9 = value;
    }

    /**
     * Gets the value of the customfield10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMFIELD10() {
        return customfield10;
    }

    /**
     * Sets the value of the customfield10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMFIELD10(String value) {
        this.customfield10 = value;
    }

}
