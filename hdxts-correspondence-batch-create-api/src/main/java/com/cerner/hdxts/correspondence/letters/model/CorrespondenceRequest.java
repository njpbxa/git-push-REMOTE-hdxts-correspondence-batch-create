package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for CorrespondenceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CorrespondenceRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SUBMITTER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CORRESPONDENCE_DELIVERY_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PDF_PUSH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RECIPIENT" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Recipient" minOccurs="0"/&gt;
 *         &lt;element name="ENCOUNTER" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Encounter" minOccurs="0"/&gt;
 *         &lt;element name="PATIENT" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Patient" minOccurs="0"/&gt;
 *         &lt;element name="MESSAGE" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Message" minOccurs="0"/&gt;
 *         &lt;element name="CUSTOM_FIELDS" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}CustomFields" minOccurs="0"/&gt;
 *         &lt;element name="ATTACHMENTS" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Attachments" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrespondenceRequest", propOrder = {
    "submitterid",
    "correspondencedeliverytype",
    "date",
    "pdfpush",
    "recipient",
    "encounter",
    "patient",
    "message",
    "customfields",
    "attachments"
})
@XmlRootElement(name = "CORRESPONDENCE_REQUEST")
public class CorrespondenceRequest {

    @XmlElement(name = "SUBMITTER_ID")
    @JsonProperty(value="SUBMITTER_ID")
    protected String submitterid;
    @XmlElement(name = "CORRESPONDENCE_DELIVERY_TYPE")
    @JsonProperty(value="CORRESPONDENCE_DELIVERY_TYPE")
    protected String correspondencedeliverytype;
    @XmlElement(name = "DATE")
    @JsonProperty(value="DATE")
    protected String date;
    @XmlElement(name = "PDF_PUSH")
    @JsonProperty(value="PDF_PUSH")
    protected String pdfpush;
    @XmlElement(name = "RECIPIENT")
    @JsonProperty(value="RECIPIENT")
    protected Recipient recipient;
    @XmlElement(name = "ENCOUNTER")
    @JsonProperty(value="ENCOUNTER")
    protected Encounter encounter;
    @XmlElement(name = "PATIENT")
    @JsonProperty(value="PATIENT")
    protected Patient patient;
    @XmlElement(name = "MESSAGE")
    @JsonProperty(value="MESSAGE")
    protected Message message;
    @XmlElement(name = "CUSTOM_FIELDS")
    @JsonProperty(value="CUSTOM_FIELDS")
    protected CustomFields customfields;
    @XmlElement(name = "ATTACHMENTS")
    @JsonProperty(value="ATTACHMENTS")
    protected Attachments attachments;

    /**
     * Gets the value of the submitterid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUBMITTERID() {
        return submitterid;
    }

    /**
     * Sets the value of the submitterid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUBMITTERID(String value) {
        this.submitterid = value;
    }

    /**
     * Gets the value of the correspondencedeliverytype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCORRESPONDENCEDELIVERYTYPE() {
        return correspondencedeliverytype;
    }

    /**
     * Sets the value of the correspondencedeliverytype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCORRESPONDENCEDELIVERYTYPE(String value) {
        this.correspondencedeliverytype = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATE() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATE(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the pdfpush property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDFPUSH() {
        return pdfpush;
    }

    /**
     * Sets the value of the pdfpush property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDFPUSH(String value) {
        this.pdfpush = value;
    }

    /**
     * Gets the value of the recipient property.
     * 
     * @return
     *     possible object is
     *     {@link Recipient }
     *     
     */
    public Recipient getRECIPIENT() {
        return recipient;
    }

    /**
     * Sets the value of the recipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Recipient }
     *     
     */
    public void setRECIPIENT(Recipient value) {
        this.recipient = value;
    }

    /**
     * Gets the value of the encounter property.
     * 
     * @return
     *     possible object is
     *     {@link Encounter }
     *     
     */
    public Encounter getENCOUNTER() {
        return encounter;
    }

    /**
     * Sets the value of the encounter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Encounter }
     *     
     */
    public void setENCOUNTER(Encounter value) {
        this.encounter = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link Patient }
     *     
     */
    public Patient getPATIENT() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Patient }
     *     
     */
    public void setPATIENT(Patient value) {
        this.patient = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link Message }
     *     
     */
    public Message getMESSAGE() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link Message }
     *     
     */
    public void setMESSAGE(Message value) {
        this.message = value;
    }

    /**
     * Gets the value of the customfields property.
     * 
     * @return
     *     possible object is
     *     {@link CustomFields }
     *     
     */
    public CustomFields getCUSTOMFIELDS() {
        return customfields;
    }

    /**
     * Sets the value of the customfields property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomFields }
     *     
     */
    public void setCUSTOMFIELDS(CustomFields value) {
        this.customfields = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * @return
     *     possible object is
     *     {@link Attachments }
     *     
     */
    public Attachments getATTACHMENTS() {
        return attachments;
    }

    /**
     * Sets the value of the attachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Attachments }
     *     
     */
    public void setATTACHMENTS(Attachments value) {
        this.attachments = value;
    }

}
