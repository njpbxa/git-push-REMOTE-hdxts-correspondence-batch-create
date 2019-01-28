package com.cerner.hdxts.correspondence.statements.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.cerner.hdxts.correspondence.statements.model.FormalPaymentPlan;


/**
 * <p>Java class for encounter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="encounter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="seqNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="placeOfService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dunningMessage" type="{http://www.cerner.com/edi/correspondence/statements}dunningMessage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dateOfService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="registrationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dischargeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="medicalService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="patientBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="patientAmtPaidSinceLastStmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalCharges" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalPatientPayments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalPatientAdjustments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalInsurancePayments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalInsuranceAdjustments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attendingPhysician" type="{http://www.cerner.com/edi/correspondence/statements}attendingPhysician" minOccurs="0"/&gt;
 *         &lt;element name="insuranceBalanceForwardAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="patientBalanceForwardAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastStatementDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="healthPlan" type="{http://www.cerner.com/edi/correspondence/statements}healthPlan" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="charge" type="{http://www.cerner.com/edi/correspondence/statements}charge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="paymentAdjustment" type="{http://www.cerner.com/edi/correspondence/statements}paymentAdjustment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="enctrBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="enctrType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="formalPaymentPlan" type="{http://CorrespondenceStatementsLib/com/cerner/edi/ibm/correspondence/statements/model}formalPaymentPlan" minOccurs="0"/&gt;
 *         &lt;element name="serviceFromDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="serviceThruDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="encounterLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "encounter", propOrder = {
    "seqNumber",
    "placeOfService",
    "dunningMessage",
    "dateOfService",
    "number",
    "registrationDate",
    "dischargeDate",
    "medicalService",
    "patientBalance",
    "patientAmtPaidSinceLastStmt",
    "totalCharges",
    "totalPatientPayments",
    "totalPatientAdjustments",
    "totalInsurancePayments",
    "totalInsuranceAdjustments",
    "attendingPhysician",
    "insuranceBalanceForwardAmount",
    "patientBalanceForwardAmount",
    "lastStatementDate",
    "healthPlan",
    "charge",
    "paymentAdjustment",
    "enctrBalance",
    "enctrType",
    "formalPaymentPlan",
    "serviceFromDate",
    "serviceThruDate",
    "encounterLocation"
})
public class Encounter {

    protected String seqNumber;
    protected String placeOfService;
    protected List<DunningMessage> dunningMessage;
    protected String dateOfService;
    protected String number;
    protected String registrationDate;
    protected String dischargeDate;
    protected String medicalService;
    protected String patientBalance;
    protected String patientAmtPaidSinceLastStmt;
    protected String totalCharges;
    protected String totalPatientPayments;
    protected String totalPatientAdjustments;
    protected String totalInsurancePayments;
    protected String totalInsuranceAdjustments;
    protected AttendingPhysician attendingPhysician;
    protected String insuranceBalanceForwardAmount;
    protected String patientBalanceForwardAmount;
    protected String lastStatementDate;
    protected List<HealthPlan> healthPlan;
    protected List<Charge> charge;
    protected List<PaymentAdjustment> paymentAdjustment;
    protected String enctrBalance;
    protected String enctrType;
    protected FormalPaymentPlan formalPaymentPlan;
    protected String serviceFromDate;
    protected String serviceThruDate;
    protected String encounterLocation;

    /**
     * Gets the value of the seqNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqNumber() {
        return seqNumber;
    }

    /**
     * Sets the value of the seqNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqNumber(String value) {
        this.seqNumber = value;
    }

    /**
     * Gets the value of the placeOfService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOfService() {
        return placeOfService;
    }

    /**
     * Sets the value of the placeOfService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOfService(String value) {
        this.placeOfService = value;
    }

    /**
     * Gets the value of the dunningMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dunningMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDunningMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DunningMessage }
     * 
     * 
     */
    public List<DunningMessage> getDunningMessage() {
        if (dunningMessage == null) {
            dunningMessage = new ArrayList<DunningMessage>();
        }
        return this.dunningMessage;
    }

    /**
     * Gets the value of the dateOfService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfService() {
        return dateOfService;
    }

    /**
     * Sets the value of the dateOfService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfService(String value) {
        this.dateOfService = value;
    }

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
     * Gets the value of the registrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the value of the registrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationDate(String value) {
        this.registrationDate = value;
    }

    /**
     * Gets the value of the dischargeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDischargeDate() {
        return dischargeDate;
    }

    /**
     * Sets the value of the dischargeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDischargeDate(String value) {
        this.dischargeDate = value;
    }

    /**
     * Gets the value of the medicalService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalService() {
        return medicalService;
    }

    /**
     * Sets the value of the medicalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalService(String value) {
        this.medicalService = value;
    }

    /**
     * Gets the value of the patientBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientBalance() {
        return patientBalance;
    }

    /**
     * Sets the value of the patientBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientBalance(String value) {
        this.patientBalance = value;
    }

    /**
     * Gets the value of the patientAmtPaidSinceLastStmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientAmtPaidSinceLastStmt() {
        return patientAmtPaidSinceLastStmt;
    }

    /**
     * Sets the value of the patientAmtPaidSinceLastStmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientAmtPaidSinceLastStmt(String value) {
        this.patientAmtPaidSinceLastStmt = value;
    }

    /**
     * Gets the value of the totalCharges property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalCharges() {
        return totalCharges;
    }

    /**
     * Sets the value of the totalCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalCharges(String value) {
        this.totalCharges = value;
    }

    /**
     * Gets the value of the totalPatientPayments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalPatientPayments() {
        return totalPatientPayments;
    }

    /**
     * Sets the value of the totalPatientPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPatientPayments(String value) {
        this.totalPatientPayments = value;
    }

    /**
     * Gets the value of the totalPatientAdjustments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalPatientAdjustments() {
        return totalPatientAdjustments;
    }

    /**
     * Sets the value of the totalPatientAdjustments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPatientAdjustments(String value) {
        this.totalPatientAdjustments = value;
    }

    /**
     * Gets the value of the totalInsurancePayments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalInsurancePayments() {
        return totalInsurancePayments;
    }

    /**
     * Sets the value of the totalInsurancePayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalInsurancePayments(String value) {
        this.totalInsurancePayments = value;
    }

    /**
     * Gets the value of the totalInsuranceAdjustments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalInsuranceAdjustments() {
        return totalInsuranceAdjustments;
    }

    /**
     * Sets the value of the totalInsuranceAdjustments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalInsuranceAdjustments(String value) {
        this.totalInsuranceAdjustments = value;
    }

    /**
     * Gets the value of the attendingPhysician property.
     * 
     * @return
     *     possible object is
     *     {@link AttendingPhysician }
     *     
     */
    public AttendingPhysician getAttendingPhysician() {
        return attendingPhysician;
    }

    /**
     * Sets the value of the attendingPhysician property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttendingPhysician }
     *     
     */
    public void setAttendingPhysician(AttendingPhysician value) {
        this.attendingPhysician = value;
    }

    /**
     * Gets the value of the insuranceBalanceForwardAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceBalanceForwardAmount() {
        return insuranceBalanceForwardAmount;
    }

    /**
     * Sets the value of the insuranceBalanceForwardAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceBalanceForwardAmount(String value) {
        this.insuranceBalanceForwardAmount = value;
    }

    /**
     * Gets the value of the patientBalanceForwardAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientBalanceForwardAmount() {
        return patientBalanceForwardAmount;
    }

    /**
     * Sets the value of the patientBalanceForwardAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientBalanceForwardAmount(String value) {
        this.patientBalanceForwardAmount = value;
    }

    /**
     * Gets the value of the lastStatementDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastStatementDate() {
        return lastStatementDate;
    }

    /**
     * Sets the value of the lastStatementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastStatementDate(String value) {
        this.lastStatementDate = value;
    }

    /**
     * Gets the value of the healthPlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the healthPlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHealthPlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HealthPlan }
     * 
     * 
     */
    public List<HealthPlan> getHealthPlan() {
        if (healthPlan == null) {
            healthPlan = new ArrayList<HealthPlan>();
        }
        return this.healthPlan;
    }

    /**
     * Gets the value of the charge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the charge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Charge }
     * 
     * 
     */
    public List<Charge> getCharge() {
        if (charge == null) {
            charge = new ArrayList<Charge>();
        }
        return this.charge;
    }

    /**
     * Gets the value of the paymentAdjustment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentAdjustment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentAdjustment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentAdjustment }
     * 
     * 
     */
    public List<PaymentAdjustment> getPaymentAdjustment() {
        if (paymentAdjustment == null) {
            paymentAdjustment = new ArrayList<PaymentAdjustment>();
        }
        return this.paymentAdjustment;
    }

    /**
     * Gets the value of the enctrBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnctrBalance() {
        return enctrBalance;
    }

    /**
     * Sets the value of the enctrBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnctrBalance(String value) {
        this.enctrBalance = value;
    }

    /**
     * Gets the value of the enctrType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnctrType() {
        return enctrType;
    }

    /**
     * Sets the value of the enctrType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnctrType(String value) {
        this.enctrType = value;
    }

    /**
     * Gets the value of the formalPaymentPlan property.
     * 
     * @return
     *     possible object is
     *     {@link FormalPaymentPlan }
     *     
     */
    public FormalPaymentPlan getFormalPaymentPlan() {
        return formalPaymentPlan;
    }

    /**
     * Sets the value of the formalPaymentPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormalPaymentPlan }
     *     
     */
    public void setFormalPaymentPlan(FormalPaymentPlan value) {
        this.formalPaymentPlan = value;
    }

    /**
     * Gets the value of the serviceFromDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceFromDate() {
        return serviceFromDate;
    }

    /**
     * Sets the value of the serviceFromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceFromDate(String value) {
        this.serviceFromDate = value;
    }

    /**
     * Gets the value of the serviceThruDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceThruDate() {
        return serviceThruDate;
    }

    /**
     * Sets the value of the serviceThruDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceThruDate(String value) {
        this.serviceThruDate = value;
    }

    /**
     * Gets the value of the encounterLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncounterLocation() {
        return encounterLocation;
    }

    /**
     * Sets the value of the encounterLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncounterLocation(String value) {
        this.encounterLocation = value;
    }

}
