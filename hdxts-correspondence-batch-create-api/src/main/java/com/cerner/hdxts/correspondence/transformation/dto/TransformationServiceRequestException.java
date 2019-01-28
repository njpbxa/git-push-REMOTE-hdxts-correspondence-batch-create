package com.cerner.hdxts.correspondence.transformation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request validation exception.
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TransformationServiceRequestException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 9115607557745363929L;

    private String message;

    public TransformationServiceRequestException(String msg) {
        super(msg);
        this.message = msg;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
