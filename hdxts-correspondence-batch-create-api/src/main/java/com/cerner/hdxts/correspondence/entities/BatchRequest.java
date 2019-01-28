package com.cerner.hdxts.correspondence.entities;

public class BatchRequest
{
  private Long groupId;
  private Long eventId;
  private String transactionType;
  private String message;
  private String submitterId;
  
  public Long getGroupId()
  {
    return this.groupId;
  }
  
  public void setGroupId(Long groupId)
  {
    this.groupId = groupId;
  }
  
  public Long getEventId()
  {
    return this.eventId;
  }
  
  public void setEventId(Long eventId)
  {
    this.eventId = eventId;
  }
  
  public String getTransactionType()
  {
    return this.transactionType;
  }
  
  public void setTransactionType(String transactionType)
  {
    this.transactionType = transactionType;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }
  
  public String getSubmitterId()
  {
    return this.submitterId;
  }
  
  public void setSubmitterId(String submitterId)
  {
    this.submitterId = submitterId;
  }
}
