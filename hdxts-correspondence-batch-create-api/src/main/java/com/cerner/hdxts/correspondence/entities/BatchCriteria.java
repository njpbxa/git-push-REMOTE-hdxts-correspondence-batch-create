package com.cerner.hdxts.correspondence.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="batchCriteria", propOrder={"transactionType", "category", "status"})
@XmlRootElement(name="batchCriteria")
public class BatchCriteria
{
  private String transactionType;
  private String category;
  private String status;
  
  public String getTransactionType()
  {
    return this.transactionType;
  }
  
  public void setTransactionType(String transactionType)
  {
    this.transactionType = transactionType;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public void setCategory(String category)
  {
    this.category = category;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
}
