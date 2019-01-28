package com.cerner.hdxts.correspondence.domain.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Solution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Solution"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="solutionApplication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="solutionVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="originSolutionApplication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="clientDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Solution", propOrder = {
    "solutionApplication",
    "solutionVersion",
    "originSolutionApplication",
    "clientDomain"
})
public class Solution {

    protected String solutionApplication;
    protected String solutionVersion;
    protected String originSolutionApplication;
    protected String clientDomain;

    /**
     * Gets the value of the solutionApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSolutionApplication() {
        return solutionApplication;
    }

    /**
     * Sets the value of the solutionApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSolutionApplication(String value) {
        this.solutionApplication = value;
    }

    /**
     * Gets the value of the solutionVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSolutionVersion() {
        return solutionVersion;
    }

    /**
     * Sets the value of the solutionVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSolutionVersion(String value) {
        this.solutionVersion = value;
    }

    /**
     * Gets the value of the originSolutionApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginSolutionApplication() {
        return originSolutionApplication;
    }

    /**
     * Sets the value of the originSolutionApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginSolutionApplication(String value) {
        this.originSolutionApplication = value;
    }

    /**
     * Gets the value of the clientDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientDomain() {
        return clientDomain;
    }

    /**
     * Sets the value of the clientDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientDomain(String value) {
        this.clientDomain = value;
    }

}
