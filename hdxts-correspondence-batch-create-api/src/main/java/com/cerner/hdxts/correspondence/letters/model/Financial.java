package com.cerner.hdxts.correspondence.letters.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <p>Java class for Financial complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Financial"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AMOUNT_OWED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SELF_PAY_AMOUNT_OWED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LAST_STATEMENT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LAST_STATEMENT_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ACCOUNT" type="{http://CorrespondenceLettersLib/com/cerner/edi/ibm/correspondence/model}Account" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Financial", propOrder = {
    "balance",
    "amountowed",
    "selfpayamountowed",
    "laststatementnumber",
    "laststatementdate",
    "account"
})
public class Financial {

    @XmlElement(name = "BALANCE")
    @JsonProperty(value="BALANCE")
    protected String balance;
    @XmlElement(name = "AMOUNT_OWED")
    @JsonProperty(value="AMOUNT_OWED")
    protected String amountowed;
    @XmlElement(name = "SELF_PAY_AMOUNT_OWED")
    @JsonProperty(value="SELF_PAY_AMOUNT_OWED")
    protected String selfpayamountowed;
    @XmlElement(name = "LAST_STATEMENT_NUMBER")
    @JsonProperty(value="LAST_STATEMENT_NUMBER")
    protected String laststatementnumber;
    @XmlElement(name = "LAST_STATEMENT_DATE")
    @JsonProperty(value="LAST_STATEMENT_DATE")
    protected String laststatementdate;
    @XmlElement(name = "ACCOUNT")
    @JsonProperty(value="ACCOUNT")
    protected Account account;

    /**
     * Gets the value of the balance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBALANCE() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBALANCE(String value) {
        this.balance = value;
    }

    /**
     * Gets the value of the amountowed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMOUNTOWED() {
        return amountowed;
    }

    /**
     * Sets the value of the amountowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMOUNTOWED(String value) {
        this.amountowed = value;
    }

    /**
     * Gets the value of the selfpayamountowed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSELFPAYAMOUNTOWED() {
        return selfpayamountowed;
    }

    /**
     * Sets the value of the selfpayamountowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSELFPAYAMOUNTOWED(String value) {
        this.selfpayamountowed = value;
    }

    /**
     * Gets the value of the laststatementnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTSTATEMENTNUMBER() {
        return laststatementnumber;
    }

    /**
     * Sets the value of the laststatementnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTSTATEMENTNUMBER(String value) {
        this.laststatementnumber = value;
    }

    /**
     * Gets the value of the laststatementdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTSTATEMENTDATE() {
        return laststatementdate;
    }

    /**
     * Sets the value of the laststatementdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTSTATEMENTDATE(String value) {
        this.laststatementdate = value;
    }

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getACCOUNT() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setACCOUNT(Account value) {
        this.account = value;
    }

}
