package com.cerner.hdxts.correspondence.statements.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.cerner.hdxts.correspondence.statements.model.EdiAttributes;


/**
 * <p>Java class for statementRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statementRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="submitterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="submitterAlias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="correspondenceDeliveryType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="procStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pdfPush" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="templateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billingProvider" type="{http://www.cerner.com/edi/correspondence/statements}billingProvider" minOccurs="0"/&gt;
 *         &lt;element name="remitTo" type="{http://www.cerner.com/edi/correspondence/statements}remitTo" minOccurs="0"/&gt;
 *         &lt;element name="recipient" type="{http://www.cerner.com/edi/correspondence/statements}recipient" minOccurs="0"/&gt;
 *         &lt;element name="statement" type="{http://www.cerner.com/edi/correspondence/statements}statement" minOccurs="0"/&gt;
 *         &lt;element name="ediAttributes" type="{http://CorrespondenceStatementsLib/com/cerner/edi/ibm/correspondence/statements/model}ediAttributes" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statementRequest", propOrder = {
		"submitterId",
		"submitterAlias",
		"correspondenceDeliveryType",
		"procStatus",
		"pdfPush",
		"templateId",
		"date",
		"billingProvider",
		"remitTo",
		"recipient",
		"statement",
		"ediAttributes"
})
@XmlRootElement(name = "statementRequest")
public class StatementRequest {

	protected String submitterId;
	protected String submitterAlias;
	protected String correspondenceDeliveryType;
	protected String procStatus;
	protected String pdfPush;
	protected String templateId;
	protected String date;
	protected BillingProvider billingProvider;
	protected RemitTo remitTo;
	protected Recipient recipient;
	protected Statement statement;
	protected EdiAttributes ediAttributes;

	/**
	 * Gets the value of the submitterId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getSubmitterId() {
		return submitterId;
	}

	/**
	 * Sets the value of the submitterId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setSubmitterId(String value) {
		this.submitterId = value;
	}

	/**
	 * Gets the value of the submitterAlias property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getSubmitterAlias() {
		return submitterAlias;
	}

	/**
	 * Sets the value of the submitterAlias property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setSubmitterAlias(String value) {
		this.submitterAlias = value;
	}

	/**
	 * Gets the value of the correspondenceDeliveryType property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getCorrespondenceDeliveryType() {
		return correspondenceDeliveryType;
	}

	/**
	 * Sets the value of the correspondenceDeliveryType property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setCorrespondenceDeliveryType(String value) {
		this.correspondenceDeliveryType = value;
	}

	/**
	 * Gets the value of the procStatus property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getProcStatus() {
		return procStatus;
	}

	/**
	 * Sets the value of the procStatus property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setProcStatus(String value) {
		this.procStatus = value;
	}

	/**
	 * Gets the value of the pdfPush property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getPdfPush() {
		return pdfPush;
	}

	/**
	 * Sets the value of the pdfPush property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setPdfPush(String value) {
		this.pdfPush = value;
	}

	/**
	 * Gets the value of the templateId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * Sets the value of the templateId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setTemplateId(String value) {
		this.templateId = value;
	}

	/**
	 * Gets the value of the billingProvider property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link BillingProvider }
	 *     
	 */
	public BillingProvider getBillingProvider() {
		return billingProvider;
	}

	/**
	 * Sets the value of the billingProvider property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link BillingProvider }
	 *     
	 */
	public void setBillingProvider(BillingProvider value) {
		this.billingProvider = value;
	}

	/**
	 * Gets the value of the remitTo property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link RemitTo }
	 *     
	 */
	public RemitTo getRemitTo() {
		return remitTo;
	}

	/**
	 * Sets the value of the remitTo property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link RemitTo }
	 *     
	 */
	public void setRemitTo(RemitTo value) {
		this.remitTo = value;
	}

	/**
	 * Gets the value of the recipient property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Recipient }
	 *     
	 */
	public Recipient getRecipient() {
		return recipient;
	}

	/**
	 * Sets the value of the recipient property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Recipient }
	 *     
	 */
	public void setRecipient(Recipient value) {
		this.recipient = value;
	}

	/**
	 * Gets the value of the statement property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Statement }
	 *     
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * Sets the value of the statement property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Statement }
	 *     
	 */
	public void setStatement(Statement value) {
		this.statement = value;
	}

	/**
	 * Gets the value of the ediAttributes property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link EdiAttributes }
	 *     
	 */
	public EdiAttributes getEdiAttributes() {
		return ediAttributes;
	}

	/**
	 * Sets the value of the ediAttributes property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link EdiAttributes }
	 *     
	 */
	public void setEdiAttributes(EdiAttributes value) {
		this.ediAttributes = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
