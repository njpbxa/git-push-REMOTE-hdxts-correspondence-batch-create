package com.cerner.hdxts.correspondence.statements.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for billingProvider complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="billingProvider"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="federalTaxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="visaCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="masterCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="americanExpress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="discoverCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="otherCards" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statementType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://www.cerner.com/edi/correspondence/statements}Address" minOccurs="0"/&gt;
 *         &lt;element name="contactInfo" type="{http://www.cerner.com/edi/correspondence/statements}ContactInformation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "billingProvider", propOrder = {
    "name",
    "federalTaxId",
    "visaCard",
    "masterCard",
    "americanExpress",
    "discoverCard",
    "otherCards",
    "statementType",
    "address",
    "contactInfo"
})
public class BillingProvider {

    protected String name;
    protected String federalTaxId;
    protected String visaCard;
    protected String masterCard;
    protected String americanExpress;
    protected String discoverCard;
    protected String otherCards;
    protected String statementType;
    protected Address address;
    protected ContactInformation contactInfo;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
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
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the federalTaxId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFederalTaxId() {
        return federalTaxId;
    }

    /**
     * Sets the value of the federalTaxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFederalTaxId(String value) {
        this.federalTaxId = value;
    }

    /**
     * Gets the value of the visaCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisaCard() {
        return visaCard;
    }

    /**
     * Sets the value of the visaCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisaCard(String value) {
        this.visaCard = value;
    }

    /**
     * Gets the value of the masterCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterCard() {
        return masterCard;
    }

    /**
     * Sets the value of the masterCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterCard(String value) {
        this.masterCard = value;
    }

    /**
     * Gets the value of the americanExpress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmericanExpress() {
        return americanExpress;
    }

    /**
     * Sets the value of the americanExpress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmericanExpress(String value) {
        this.americanExpress = value;
    }

    /**
     * Gets the value of the discoverCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscoverCard() {
        return discoverCard;
    }

    /**
     * Sets the value of the discoverCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscoverCard(String value) {
        this.discoverCard = value;
    }

    /**
     * Gets the value of the otherCards property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherCards() {
        return otherCards;
    }

    /**
     * Sets the value of the otherCards property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherCards(String value) {
        this.otherCards = value;
    }

    /**
     * Gets the value of the statementType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatementType() {
        return statementType;
    }

    /**
     * Sets the value of the statementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatementType(String value) {
        this.statementType = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
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
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the contactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInformation }
     *     
     */
    public ContactInformation getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the contactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInformation }
     *     
     */
    public void setContactInfo(ContactInformation value) {
        this.contactInfo = value;
    }

}
