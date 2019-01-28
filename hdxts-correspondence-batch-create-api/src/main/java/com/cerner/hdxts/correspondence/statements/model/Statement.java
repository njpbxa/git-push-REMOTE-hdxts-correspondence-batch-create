package com.cerner.hdxts.correspondence.statements.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amountDue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dateDue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="generationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="insurancePendingBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newCharges" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="balanceOver30" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="balanceOver60" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="balanceOver90" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="date2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="date3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalChgsAdj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payAdjTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primHealthPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="secHealthPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terHealthPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="broadcastMessage" type="{http://www.cerner.com/edi/correspondence/statements}broadcastMessage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="account" type="{http://www.cerner.com/edi/correspondence/statements}account" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statement", propOrder = {
    "number",
    "amountDue",
    "dateDue",
    "generationDate",
    "insurancePendingBalance",
    "newCharges",
    "balanceOver30",
    "balanceOver60",
    "balanceOver90",
    "totalAmount",
    "date2",
    "date3",
    "totalChgsAdj",
    "payAdjTotal",
    "primHealthPlanName",
    "secHealthPlanName",
    "terHealthPlanName",
    "broadcastMessage",
    "account"
})
public class Statement {

    protected String number;
    protected String amountDue;
    protected String dateDue;
    protected String generationDate;
    protected String insurancePendingBalance;
    protected String newCharges;
    protected String balanceOver30;
    protected String balanceOver60;
    protected String balanceOver90;
    protected String totalAmount;
    protected String date2;
    protected String date3;
    protected String totalChgsAdj;
    protected String payAdjTotal;
    protected String primHealthPlanName;
    protected String secHealthPlanName;
    protected String terHealthPlanName;
    protected List<BroadcastMessage> broadcastMessage;
    protected List<Account> account;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the amountDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountDue() {
        return amountDue;
    }

    /**
     * Sets the value of the amountDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountDue(String value) {
        this.amountDue = value;
    }

    /**
     * Gets the value of the dateDue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateDue() {
        return dateDue;
    }

    /**
     * Sets the value of the dateDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateDue(String value) {
        this.dateDue = value;
    }

    /**
     * Gets the value of the generationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerationDate() {
        return generationDate;
    }

    /**
     * Sets the value of the generationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerationDate(String value) {
        this.generationDate = value;
    }

    /**
     * Gets the value of the insurancePendingBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsurancePendingBalance() {
        return insurancePendingBalance;
    }

    /**
     * Sets the value of the insurancePendingBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsurancePendingBalance(String value) {
        this.insurancePendingBalance = value;
    }

    /**
     * Gets the value of the newCharges property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewCharges() {
        return newCharges;
    }

    /**
     * Sets the value of the newCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewCharges(String value) {
        this.newCharges = value;
    }

    /**
     * Gets the value of the balanceOver30 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceOver30() {
        return balanceOver30;
    }

    /**
     * Sets the value of the balanceOver30 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceOver30(String value) {
        this.balanceOver30 = value;
    }

    /**
     * Gets the value of the balanceOver60 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceOver60() {
        return balanceOver60;
    }

    /**
     * Sets the value of the balanceOver60 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceOver60(String value) {
        this.balanceOver60 = value;
    }

    /**
     * Gets the value of the balanceOver90 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceOver90() {
        return balanceOver90;
    }

    /**
     * Sets the value of the balanceOver90 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceOver90(String value) {
        this.balanceOver90 = value;
    }

    /**
     * Gets the value of the totalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalAmount(String value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the date2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate2() {
        return date2;
    }

    /**
     * Sets the value of the date2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate2(String value) {
        this.date2 = value;
    }

    /**
     * Gets the value of the date3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate3() {
        return date3;
    }

    /**
     * Sets the value of the date3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate3(String value) {
        this.date3 = value;
    }

    /**
     * Gets the value of the totalChgsAdj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalChgsAdj() {
        return totalChgsAdj;
    }

    /**
     * Sets the value of the totalChgsAdj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalChgsAdj(String value) {
        this.totalChgsAdj = value;
    }

    /**
     * Gets the value of the payAdjTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayAdjTotal() {
        return payAdjTotal;
    }

    /**
     * Sets the value of the payAdjTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayAdjTotal(String value) {
        this.payAdjTotal = value;
    }

    /**
     * Gets the value of the primHealthPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimHealthPlanName() {
        return primHealthPlanName;
    }

    /**
     * Sets the value of the primHealthPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimHealthPlanName(String value) {
        this.primHealthPlanName = value;
    }

    /**
     * Gets the value of the secHealthPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecHealthPlanName() {
        return secHealthPlanName;
    }

    /**
     * Sets the value of the secHealthPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecHealthPlanName(String value) {
        this.secHealthPlanName = value;
    }

    /**
     * Gets the value of the terHealthPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerHealthPlanName() {
        return terHealthPlanName;
    }

    /**
     * Sets the value of the terHealthPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerHealthPlanName(String value) {
        this.terHealthPlanName = value;
    }

    /**
     * Gets the value of the broadcastMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the broadcastMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBroadcastMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BroadcastMessage }
     * 
     * 
     */
    public List<BroadcastMessage> getBroadcastMessage() {
        if (broadcastMessage == null) {
            broadcastMessage = new ArrayList<BroadcastMessage>();
        }
        return this.broadcastMessage;
    }

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Account }
     * 
     * 
     */
    public List<Account> getAccount() {
        if (account == null) {
            account = new ArrayList<Account>();
        }
        return this.account;
    }

}
