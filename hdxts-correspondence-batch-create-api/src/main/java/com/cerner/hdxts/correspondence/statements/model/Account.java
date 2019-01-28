package com.cerner.hdxts.correspondence.statements.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for account complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="account"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="patientAmtPaidSinceLastStmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="patient" type="{http://www.cerner.com/edi/correspondence/statements}patient" minOccurs="0"/&gt;
 *         &lt;element name="encounter" type="{http://www.cerner.com/edi/correspondence/statements}encounter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account", propOrder = {
    "number",
    "patientAmtPaidSinceLastStmt",
    "patient",
    "encounter"
})
public class Account {

    protected String number;
    protected String patientAmtPaidSinceLastStmt;
    protected Patient patient;
    protected List<Encounter> encounter;

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
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link Patient }
     *     
     */
    public Patient getPatient() {
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
    public void setPatient(Patient value) {
        this.patient = value;
    }

    /**
     * Gets the value of the encounter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encounter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncounter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Encounter }
     * 
     * 
     */
    public List<Encounter> getEncounter() {
        if (encounter == null) {
            encounter = new ArrayList<Encounter>();
        }
        return this.encounter;
    }

}
