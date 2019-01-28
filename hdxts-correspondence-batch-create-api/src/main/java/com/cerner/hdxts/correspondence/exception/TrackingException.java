package com.cerner.hdxts.correspondence.exception;


/**
 * @author ds042009
 *
 */
public class TrackingException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private String message;

	public TrackingException() 
	{
	}

	public TrackingException(String message) 
	{
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
