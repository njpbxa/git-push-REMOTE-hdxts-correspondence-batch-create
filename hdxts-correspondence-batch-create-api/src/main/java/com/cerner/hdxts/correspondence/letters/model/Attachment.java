package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for Attachment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Attachment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ATTACHMENT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attachment", propOrder = {
    "attachmentid"
})
public class Attachment {

    @XmlElement(name = "ATTACHMENT_ID")
    @JsonProperty(value="ATTACHMENT_ID")
    protected String attachmentid;

    /**
     * Gets the value of the attachmentid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getATTACHMENTID() {
        return attachmentid;
    }

    /**
     * Sets the value of the attachmentid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setATTACHMENTID(String value) {
        this.attachmentid = value;
    }

}
