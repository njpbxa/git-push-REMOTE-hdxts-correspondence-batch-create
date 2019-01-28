package com.cerner.hdxts.correspondence.entities;

public class BatchConfiguration
{
  private String mapLocation;
  private String fileExtension;
  private String sourceName;
  private String batchTypeCDF;
  private String outboundFileType;
  private String serviceCDF;
  
  public String getMapLocation()
  {
    return this.mapLocation;
  }
  
  public void setMapLocation(String mapLocation)
  {
    this.mapLocation = mapLocation;
  }
  
  public String getFileExtension()
  {
    return this.fileExtension;
  }
  
  public void setFileExtension(String fileExtension)
  {
    this.fileExtension = fileExtension;
  }
  
  public String getSourceName()
  {
    return this.sourceName;
  }
  
  public void setSourceName(String sourceName)
  {
    this.sourceName = sourceName;
  }
  
  public String getBatchTypeCDF()
  {
    return this.batchTypeCDF;
  }
  
  public void setBatchTypeCDF(String batchTypeCDF)
  {
    this.batchTypeCDF = batchTypeCDF;
  }
  
  public String getOutboundFileType()
  {
    return this.outboundFileType;
  }
  
  public void setOutboundFileType(String outboundFileType)
  {
    this.outboundFileType = outboundFileType;
  }
  
  public String getServiceCDF()
  {
    return this.serviceCDF;
  }
  
  public void setServiceCDF(String serviceCDF)
  {
    this.serviceCDF = serviceCDF;
  }
}
