package com.cerner.hdxts.correspondence.service.mqutils;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MQUtilsImpl implements MQUtils
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MQUtilsImpl.class);

	@Autowired
	@Qualifier("numberOfQueueManagers")
	private Long numberOfQueueManagers;

	@Qualifier("mqCorrespondenceBatchRequestCF")
	@Autowired
	private QueueConnectionFactory mqCorrespondenceBatchRequestQCFPrimary;

	@Qualifier("mqCorrespondenceBatchRequestQCFSecondary")
	@Autowired
	private QueueConnectionFactory mqCorrespondenceBatchRequestQCFSecondary;

	@Qualifier("mqCorrespondenceBatchRequestQCFTertiary")
	@Autowired
	private QueueConnectionFactory mqCorrespondenceBatchRequestQCFTertiary;

	public void send(String message, String correlationId, QueueConnectionFactory queueConnectionFactory, Queue queue, Long expirationTime) throws JMSException
	{
		MessageProducer messageProducer = null;
		QueueSession queueSession = null;
		QueueConnection queueConnection = null;
		TextMessage msg = null;
		try
		{
			LOGGER.debug("Putting message for correlationId {} ", correlationId);

			queueConnection = queueConnectionFactory.createQueueConnection();
			LOGGER.debug("Connection opened");
			queueSession = queueConnection.createQueueSession(false, 1);
			LOGGER.debug("Session opened");
			messageProducer = queueSession.createProducer(queue);
			msg = queueSession.createTextMessage(message);
			msg.setJMSCorrelationID("");
			if(expirationTime != null)
			{
				msg.setJMSExpiration(expirationTime);
			}
			messageProducer.send(msg); 
			return;
		}
		finally
		{
			try
			{
				if (queueConnection != null) {
					queueConnection.close();
				}
				if (queueSession != null) {
					queueSession.close();
				}
				if (messageProducer != null) {
					messageProducer.close();
				}
			}
			catch (Exception e)
			{
				LOGGER.error("Caught error while closing queue connection" + e.getMessage());
			}
		}
	}

	@Override
	public Long getQueueDepth(Queue queue) throws JMSException 
	{
		Long count = 0L;
		if(numberOfQueueManagers >= 1)
		{
			Connection conn = mqCorrespondenceBatchRequestQCFPrimary.createConnection();
			conn.start();

			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			QueueBrowser qb = session.createBrowser(queue);
			Enumeration queueMessageEnum = qb.getEnumeration();
			
			while(queueMessageEnum.hasMoreElements()) 
			{
				queueMessageEnum.nextElement();
				count++;
			}
		}
		
		if(numberOfQueueManagers >= 2)
		{
			Connection conn = mqCorrespondenceBatchRequestQCFSecondary.createConnection();
			conn.start();

			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			QueueBrowser qb = session.createBrowser(queue);
			Enumeration queueMessageEnum = qb.getEnumeration();
			
			while(queueMessageEnum.hasMoreElements()) 
			{
				queueMessageEnum.nextElement();
				count++;
			}
		}
		
		if(numberOfQueueManagers >= 3)
		{
			Connection conn = mqCorrespondenceBatchRequestQCFTertiary.createConnection();
			conn.start();

			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			QueueBrowser qb = session.createBrowser(queue);
			Enumeration queueMessageEnum = qb.getEnumeration();
			
			while(queueMessageEnum.hasMoreElements()) 
			{
				queueMessageEnum.nextElement();
				count++;
			}
		}

		return count;
	}
}
