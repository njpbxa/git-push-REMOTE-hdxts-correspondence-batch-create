package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for Insurance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Insurance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FINANCIAL" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Financial" minOccurs="0"/&gt;
 *         &lt;element name="PAYER" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Payer" minOccurs="0"/&gt;
 *         &lt;element name="SUBSCRIBER" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Subscriber" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Insurance", propOrder = {
    "financial",
    "payer",
    "subscriber"
})
public class Insurance {

    @XmlElement(name = "FINANCIAL")
    @JsonProperty(value="FINANCIAL")
    protected Financial financial;
    @XmlElement(name = "PAYER")
    @JsonProperty(value="PAYER")
    protected Payer payer;
    @XmlElement(name = "SUBSCRIBER")
    @JsonProperty(value="SUBSCRIBER")
    protected Subscriber subscriber;

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
     * Gets the value of the payer property.
     * 
     * @return
     *     possible object is
     *     {@link Payer }
     *     
     */
    public Payer getPAYER() {
        return payer;
    }

    /**
     * Sets the value of the payer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Payer }
     *     
     */
    public void setPAYER(Payer value) {
        this.payer = value;
    }

    /**
     * Gets the value of the subscriber property.
     * 
     * @return
     *     possible object is
     *     {@link Subscriber }
     *     
     */
    public Subscriber getSUBSCRIBER() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscriber }
     *     
     */
    public void setSUBSCRIBER(Subscriber value) {
        this.subscriber = value;
    }

}
