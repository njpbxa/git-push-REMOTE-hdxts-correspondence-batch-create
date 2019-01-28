package com.cerner.hdxts.correspondence.service.mqutils;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;

public interface MQUtils 
{
	
	/**
	 * This method will put the message in all the queue managers
	 * @param message
	 * @param correlationId
	 * @param queueConnectionFactory
	 * @param queue
	 * @throws JMSException
	 */
	public void send(String message, String correlationId, QueueConnectionFactory queueConnectionFactory, Queue queue, Long expirationTime) throws JMSException;
	
	public Long getQueueDepth(Queue queue) throws JMSException;
}
