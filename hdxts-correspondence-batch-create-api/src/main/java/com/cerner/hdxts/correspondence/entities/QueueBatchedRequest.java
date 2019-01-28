package com.cerner.hdxts.correspondence.entities;

public class QueueBatchedRequest
{
  private BatchRequests batchRequests;
  private Long parentGroupId;
  private String serviceType;
  private String partnerAlias;
  
  public BatchRequests getBatchRequests()
  {
    return this.batchRequests;
  }
  
  public void setBatchRequests(BatchRequests batchRequests)
  {
    this.batchRequests = batchRequests;
  }
  
  public Long getParentGroupId()
  {
    return this.parentGroupId;
  }
  
  public void setParentGroupId(Long parentGroupId)
  {
    this.parentGroupId = parentGroupId;
  }
  
  public String getServiceType()
  {
    return this.serviceType;
  }
  
  public void setServiceType(String serviceType)
  {
    this.serviceType = serviceType;
  }
  
  public String getPartnerAlias()
  {
    return this.partnerAlias;
  }
  
  public void setPartnerAlias(String partnerAlias)
  {
    this.partnerAlias = partnerAlias;
  }
}
