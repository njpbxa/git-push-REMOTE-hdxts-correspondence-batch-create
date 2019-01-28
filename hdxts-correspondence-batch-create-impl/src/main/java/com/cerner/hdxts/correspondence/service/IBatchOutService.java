package com.cerner.hdxts.correspondence.service;

/**
 * @author DS042009
 *
 */
public abstract interface IBatchOutService
{
  /**
   * Will process the transaction request
 * @param paramString
 */
public abstract void processBatchRequest(String request);
}
