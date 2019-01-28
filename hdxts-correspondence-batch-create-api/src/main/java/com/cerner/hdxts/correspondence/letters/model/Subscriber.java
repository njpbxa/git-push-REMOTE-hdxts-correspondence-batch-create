package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for Subscriber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Subscriber"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NAME" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Name" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Address" minOccurs="0"/&gt;
 *         &lt;element name="CONTACT_INFO" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}ContactInformation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subscriber", propOrder = {
    "name",
    "address",
    "contactinfo"
})
public class Subscriber {

    @XmlElement(name = "NAME")
    @JsonProperty(value="NAME")
    protected Name name;
    @XmlElement(name = "ADDRESS")
    @JsonProperty(value="ADDRESS")
    protected Address address;
    @XmlElement(name = "CONTACT_INFO")
    @JsonProperty(value="CONTACT_INFO")
    protected ContactInformation contactinfo;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getNAME() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setNAME(Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getADDRESS() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setADDRESS(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the contactinfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInformation }
     *     
     */
    public ContactInformation getCONTACTINFO() {
        return contactinfo;
    }

    /**
     * Sets the value of the contactinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInformation }
     *     
     */
    public void setCONTACTINFO(ContactInformation value) {
        this.contactinfo = value;
    }

}
