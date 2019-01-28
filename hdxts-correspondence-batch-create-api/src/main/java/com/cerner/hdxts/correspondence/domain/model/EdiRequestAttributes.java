package com.cerner.hdxts.correspondence.domain.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EdiRequestAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EdiRequestAttributes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transactionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="usageIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="externalReferenceIdentifiers" type="{http://RealtimeCommonLib/bo/common}ExternalReferenceIndentifiers" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="solution" type="{http://RealtimeCommonLib/bo/common}Solution" minOccurs="0"/&gt;
 *         &lt;element name="user" type="{http://RealtimeCommonLib/bo/common}User" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EdiRequestAttributes", propOrder = {
    "transactionType",
    "usageIndicator",
    "externalReferenceIdentifiers",
    "solution",
    "user"
})
public class EdiRequestAttributes {

    protected String transactionType;
    protected String usageIndicator;
    protected List<ExternalReferenceIndentifiers> externalReferenceIdentifiers;
    protected Solution solution;
    protected User user;

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the usageIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsageIndicator() {
        return usageIndicator;
    }

    /**
     * Sets the value of the usageIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsageIndicator(String value) {
        this.usageIndicator = value;
    }

    /**
     * Gets the value of the externalReferenceIdentifiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalReferenceIdentifiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalReferenceIdentifiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalReferenceIndentifiers }
     * 
     * 
     */
    public List<ExternalReferenceIndentifiers> getExternalReferenceIdentifiers() {
        if (externalReferenceIdentifiers == null) {
            externalReferenceIdentifiers = new ArrayList<ExternalReferenceIndentifiers>();
        }
        return this.externalReferenceIdentifiers;
    }

    /**
     * Gets the value of the solution property.
     * 
     * @return
     *     possible object is
     *     {@link Solution }
     *     
     */
    public Solution getSolution() {
        return solution;
    }

    /**
     * Sets the value of the solution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Solution }
     *     
     */
    public void setSolution(Solution value) {
        this.solution = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

}
