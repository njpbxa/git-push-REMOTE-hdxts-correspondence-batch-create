package com.cerner.hdxts.correspondence.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="processBatch", propOrder={"parentGroupId", "serviceType", "partnerAlias"})
@XmlRootElement(name="processBatch", namespace="http://BatchOutboundLib/IBatchOutToPartnerService")
public class ProcessBatch
{
  private String parentGroupId;
  private String serviceType;
  private String partnerAlias;
  
  public String getParentGroupId()
  {
    return this.parentGroupId;
  }
  
  public void setParentGroupId(String parentGroupId)
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
