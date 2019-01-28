package com.cerner.hdxts.correspondence.entities;

public class BatchConfigRequestWrapper
{
  private BatchConfiguration batchConfiguration;
  private BatchRequest batchRequest;
  
  public BatchConfiguration getBatchConfiguration()
  {
    return this.batchConfiguration;
  }
  
  public void setBatchConfiguration(BatchConfiguration batchConfiguration)
  {
    this.batchConfiguration = batchConfiguration;
  }
  
  public BatchRequest getBatchRequest()
  {
    return this.batchRequest;
  }
  
  public void setBatchRequest(BatchRequest batchRequest)
  {
    this.batchRequest = batchRequest;
  }
}
