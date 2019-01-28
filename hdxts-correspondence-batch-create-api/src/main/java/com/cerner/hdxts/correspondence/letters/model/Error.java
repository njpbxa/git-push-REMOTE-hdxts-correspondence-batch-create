package com.cerner.hdxts.correspondence.letters.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(value={"errorcode","errormsg"})
public class Error {

    @JsonProperty(value="ERROR_CODE")
	@JsonInclude(JsonInclude.Include.NON_NULL)
    protected String errorcode;

    @JsonProperty(value="ERROR_MSG")
	@JsonInclude(JsonInclude.Include.NON_NULL)
    protected String errormsg;

    /**
     * Gets the value of the errorcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORCODE() {
        return errorcode;
    }

    /**
     * Sets the value of the errorcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORCODE(String value) {
        this.errorcode = value;
    }

    /**
     * Gets the value of the errormsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORMSG() {
        return errormsg;
    }

    /**
     * Sets the value of the errormsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORMSG(String value) {
        this.errormsg = value;
    }

}
