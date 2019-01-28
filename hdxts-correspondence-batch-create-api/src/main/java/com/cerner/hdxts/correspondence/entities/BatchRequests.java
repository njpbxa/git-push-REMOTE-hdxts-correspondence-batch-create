package com.cerner.hdxts.correspondence.entities;

import java.util.List;

public class BatchRequests
{
  private List<BatchRequest> batchRequests;
  
  public List<BatchRequest> getBatchRequests()
  {
    return this.batchRequests;
  }
  
  public void setBatchRequests(List<BatchRequest> batchRequests)
  {
    this.batchRequests = batchRequests;
  }
}
