package com.cerner.hdxts.correspondence.exception;

public class CorrespondenceServiceException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private String message;
  
  public CorrespondenceServiceException() {}
  
  public CorrespondenceServiceException(String message)
  {
    this.message = message;
  }
  
  public String getMessage()
  {
    return this.message;
  }
}
