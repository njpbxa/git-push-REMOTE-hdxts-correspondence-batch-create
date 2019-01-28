package com.cerner.hdxts.correspondence.statements.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.cerner.hdxts.correspondence.domain.model.EdiRequestAttributes;


/**
 * <p>Java class for statementRequestWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statementRequestWrapper"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="statementRequest" type="{http://www.cerner.com/edi/correspondence/statements}statementRequest" minOccurs="0"/&gt;
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
@XmlType(name = "statementRequestWrapper", propOrder = {
    "statementRequest",
    "ediRequestAttributes"
})
@XmlRootElement(name = "statementRequestWrapper",namespace="http://www.cerner.com/edi/correspondence/statements")
public class StatementRequestWrapper {

    protected StatementRequest statementRequest;
    protected EdiRequestAttributes ediRequestAttributes;

    /**
     * Gets the value of the statementRequest property.
     * 
     * @return
     *     possible object is
     *     {@link StatementRequest }
     *     
     */
    public StatementRequest getStatementRequest() {
        return statementRequest;
    }

    /**
     * Sets the value of the statementRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatementRequest }
     *     
     */
    public void setStatementRequest(StatementRequest value) {
        this.statementRequest = value;
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
