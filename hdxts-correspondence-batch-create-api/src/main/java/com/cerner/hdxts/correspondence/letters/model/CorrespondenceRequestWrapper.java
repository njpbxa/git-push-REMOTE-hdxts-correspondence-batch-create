package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.cerner.hdxts.correspondence.domain.model.EdiRequestAttributes;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for CorrespondenceRequestWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CorrespondenceRequestWrapper"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CORRESPONDENCE_REQUEST" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}CorrespondenceRequest" minOccurs="0"/&gt;
 *         &lt;element name="ediRequestAttributes" type="{http://RealtimeCommonLib/bo/common}EdiRequestAttributes" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrespondenceRequestWrapper", propOrder = {
    "correspondencerequest",
    "ediRequestAttributes"
})
@XmlRootElement(name = "CorrespondenceRequestWrapper",namespace="http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model")
public class CorrespondenceRequestWrapper {

    @XmlElement(name = "CORRESPONDENCE_REQUEST")
    @JsonProperty(value="CORRESPONDENCE_REQUEST")
    protected CorrespondenceRequest correspondencerequest;
    protected EdiRequestAttributes ediRequestAttributes;

    /**
     * Gets the value of the correspondencerequest property.
     * 
     * @return
     *     possible object is
     *     {@link CorrespondenceRequest }
     *     
     */
    public CorrespondenceRequest getCORRESPONDENCEREQUEST() {
        return correspondencerequest;
    }

    /**
     * Sets the value of the correspondencerequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorrespondenceRequest }
     *     
     */
    public void setCORRESPONDENCEREQUEST(CorrespondenceRequest value) {
        this.correspondencerequest = value;
    }

    /**
     * Gets the value of the ediRequestAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link EdiRequestAttributes }
     *     
     */
    public EdiRequestAttributes getEdiRequestAttributes() {
        return ediRequestAttributes;
    }

    /**
     * Sets the value of the ediRequestAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link EdiRequestAttributes }
     *     
     */
    public void setEdiRequestAttributes(EdiRequestAttributes value) {
        this.ediRequestAttributes = value;
    }

}
