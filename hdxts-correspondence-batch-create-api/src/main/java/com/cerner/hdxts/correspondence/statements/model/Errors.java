package com.cerner.hdxts.correspondence.statements.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Errors 
{
	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_NULL)
	protected List<Error> error;

	/**
	 * Gets the value of the error property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the error property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getError().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Error }
	 * 
	 * 
	 */
	public List<Error> getError() {
		if (error == null) {
			error = new ArrayList<Error>();
		}
		return this.error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}
}
