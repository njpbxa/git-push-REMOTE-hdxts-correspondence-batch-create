package com.cerner.hdxts.correspondence;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.cerner.edi.tracking.service.TrackingService;
import com.cerner.edi.tracking.service.TrackingServiceImpl;
import com.cerner.edi.tracking.service.utils.MQUtils;
import com.cerner.edi.tracking.service.utils.MQUtilsImpl;
import com.cerner.hdxts.correspondence.entities.BatchCriteria;
import com.cerner.hdxts.correspondence.entities.ProcessBatch;
import com.cerner.hdxts.correspondence.letters.model.CorrespondenceRequestWrapper;
import com.cerner.hdxts.correspondence.service.config.NameSpacePrefix;
import com.cerner.hdxts.correspondence.service.impl.BatchRequestListner;
import com.cerner.hdxts.correspondence.service.impl.ProcessQueuedServiceImpl;
import com.cerner.hdxts.correspondence.statements.model.StatementRequestWrapper;

@Configuration
@ImportResource({"classpath:correspondence-aop-config.xml"})
@ComponentScan({"com.cerner.edi.*.dao", "com.cerner.edi.dep.*.dao", "com.cerner.edi.*.service", "com.cerner.edi.dep.*.service", "com.cerner.hdxts.*"})
public class CorrespondenceConfig
{
	@Bean({"ediDataSource"})
	public DataSource jndiDataSource()
			throws NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName("jdbc/EDI");
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.afterPropertiesSet();
		return (DataSource)bean.getObject();
	}

	@Bean
	public CacheManager ehCacheManager()
	{
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	@Qualifier("cacheManager")
	public EhCacheManagerFactoryBean ehCacheCacheManager()
	{
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}

	@Bean({"marshaller"})
	public XStreamMarshaller getMarshaller()
	{
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setAutodetectAnnotations(true);
		Map<String, String> aliasMap = new HashMap<String, String>();
		aliasMap.put("category", "com.cerner.edi.dep.submitter.dto.xstream.ServiceConfigsDTO");
		aliasMap.put("profile", "com.cerner.edi.dep.partner.xstream.PayerProfile");
		marshaller.setAliases(aliasMap);
		return marshaller;
	}

	@Bean({"sessionFactory"})
	public AnnotationSessionFactoryBean getSessionFactory(@Qualifier("ediDataSource") DataSource ediDataSource)
	{
		AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
		sessionFactory.setDataSource(ediDataSource);
		sessionFactory.setPackagesToScan(new String[] { "com.cerner.edi.*.entity", "com.cerner.edi.dep.*.entity", "com.cerner.edi.reporting.*.entity" });

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.put("hibernate.query.substitutions", "true=1 false=0");
		hibernateProperties.put("hibernate.show_sql", "false");

		sessionFactory.setHibernateProperties(hibernateProperties);

		return sessionFactory;
	}

	@Bean({"transactionManager"})
	public HibernateTransactionManager getTransactionManager(@Qualifier("sessionFactory") SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

	@Bean({"springMonitoringAspectInterceptor"})
	public PerformanceMonitorInterceptor getSpringMonitoringAspectInterceptor()
	{
		return new PerformanceMonitorInterceptor();
	}

	@Bean("eventTopic")
	public Queue mqEventTopic() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/TrackingTopic");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (Queue)bean.getObject();
	}

	@Bean("topicConnectionFactory")
	public QueueConnectionFactory mqTopicFactory() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/TrackingTopicCF");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (QueueConnectionFactory)bean.getObject();
	}

	@Bean
	@Primary
	public MQUtils mqUtils() throws IllegalArgumentException, NamingException
	{
		MQUtilsImpl mqUtils = new MQUtilsImpl();
		mqUtils.setTopicConnectionFactory(mqTopicFactory());
		mqUtils.setEventTopic(mqEventTopic());
		return mqUtils;
	}

	@Bean({"mqCorrespondenceQueue"})
	public Queue mqCorrespondenceQueue() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/CERN.BATCH.PARTNER");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (Queue)bean.getObject();
	}

	@Bean({"mqCorrespondenceConnectionFactory"})
	@Primary
	public QueueConnectionFactory mqCorrespondenceConnectionFactory() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/BatchCreateQCF");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (QueueConnectionFactory)bean.getObject();
	}

	@Bean({"mqCorrespondenceBatchRequestQueue"})
	public Queue mqCorrespondenceBatchRequestQueue() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/CERN.BATCH.CREATE.REQ");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (Queue)bean.getObject();
	}

	@Bean({"mqCorrespondenceBatchRequestCF"})
	public QueueConnectionFactory mqCorrespondenceBatchRequestCF() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/BatchCreateReqQCF");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (QueueConnectionFactory)bean.getObject();
	}

	@Bean({"mqCorrespondenceBatchRequestQCFSecondary"})
	public QueueConnectionFactory mqCorrespondenceBatchRequestQCFSecondary() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/BatchCreateReqQCFSecondary");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (QueueConnectionFactory)bean.getObject();
	}

	@Bean({"mqCorrespondenceBatchRequestQCFTertiary"})
	public QueueConnectionFactory mqCorrespondenceBatchRequestQCFTertiary() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/BatchCreateReqQCFTertiary");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (QueueConnectionFactory)bean.getObject();
	}

	@Bean({"mqCorrespondenceOutboundQueue"})
	public Queue mqCorrespondenceOutboundQueue() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/CERN.BATCH.ROUTE.OUT");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (Queue)bean.getObject();
	}

	@Bean({"mqCorrespondenceOutboundConnectionFactory"})
	public QueueConnectionFactory mqCorrespondenceOutboundConnectionFactory() throws IllegalArgumentException, NamingException
	{
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();

		bean.setJndiName("jms/BatchRouteOUTQCF");
		bean.setLookupOnStartup(true);
		bean.afterPropertiesSet();
		return (QueueConnectionFactory)bean.getObject();
	}

	@Bean
	public BatchRequestListner batchRequestListner()
	{
		return new BatchRequestListner();
	}

	@Bean
	public MessageListenerContainer batchReqListenerContainer() throws IllegalArgumentException, NamingException, JMSException
	{
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(mqCorrespondenceBatchRequestCF());
		container.setDestinationName(mqCorrespondenceBatchRequestQueue().getQueueName());
		container.setMessageListener(batchRequestListner());
		return container;
	}

	@Bean
	public ProcessQueuedServiceImpl processQueuedServiceImpl()
	{
		return new ProcessQueuedServiceImpl();
	}

	@Bean
	public MessageListenerContainer listenerContainer() throws IllegalArgumentException, NamingException, JMSException
	{
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(mqCorrespondenceConnectionFactory());
		container.setDestinationName(mqCorrespondenceQueue().getQueueName());
		container.setMessageListener(processQueuedServiceImpl());
		return container;
	}

	@Bean(name={"threadPoolTaskExecutor"})
	public Executor threadPoolTaskExecutor()
	{
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setThreadNamePrefix("ThreadPoolTaskExecutor : ");
		return executor;
	}

	@Bean({"marshallerForClientRequest"})
	public Jaxb2Marshaller marshallerForClientRequest()
	{
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(new Class[] { BatchCriteria.class });
		return marshaller;
	}

	@Bean({"marshallerForBatchRequest"})
	public Jaxb2Marshaller marshallerForBatchRequest()
	{
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(new Class[] { ProcessBatch.class });
		return marshaller;
	}

	@Bean({"marshallerForCernerStandardRequestStatement"})
	public Jaxb2Marshaller marshallerForCernerStandardRequestStatement()
	{
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(new Class[] { StatementRequestWrapper.class });
		Map<String, Object> propertiesMap = new HashMap<>();
		propertiesMap.put("jaxb.formatted.output", Boolean.valueOf(true));
		propertiesMap.put("com.sun.xml.bind.namespacePrefixMapper", new NameSpacePrefix());
		propertiesMap.put("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
		marshaller.setMarshallerProperties(propertiesMap);
		return marshaller;
	}

	@Bean({"marshallerForCernerStandardRequestLetter"})
	public Jaxb2Marshaller marshallerForCernerStandardRequestLetter()
	{
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(new Class[] { CorrespondenceRequestWrapper.class });
		Map<String, Object> propertiesMap = new HashMap<>();
		propertiesMap.put("jaxb.formatted.output", Boolean.valueOf(true));
		propertiesMap.put("com.sun.xml.bind.namespacePrefixMapper", new NameSpacePrefix());
		propertiesMap.put("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
		marshaller.setMarshallerProperties(propertiesMap);
		return marshaller;
	}

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

	@Bean({"transformationServiceURL"})
	public String transformationServiceURL() throws NamingException
	{
		InitialContext context = new InitialContext();
		return (String)context.lookup("cell/persistent/text/TRANSFORMATION_SERVICE_URL");
	}

	@Bean({"batchCreateTempDirLocation"})
	public String batchCreateTempDirLocation() throws NamingException
	{
		InitialContext context = new InitialContext();
		return (String)context.lookup("cell/persistent/text/batchCreateTempDirLocation");
	}

	@Bean({"batchCreateStagingDirPath"})
	public String batchCreateStagingDirPath() throws NamingException
	{
		InitialContext context = new InitialContext();
		return (String)context.lookup("cell/persistent/text/batchCreateStagingDirPath");
	}

	@Bean({"batchCreateBaseErrorPath"})
	public String batchCreateBaseErrorPath() throws NamingException
	{
		InitialContext context = new InitialContext();
		return (String)context.lookup("cell/persistent/text/batchCreateBaseErrorPath");
	}

	@Bean({"statementMapLocation"})
	public String statementMapLocation() throws NamingException
	{
		InitialContext context = new InitialContext();
		return (String)context.lookup("cell/persistent/text/statementMapLocation");
	}
	@Bean({"lettersMapLocation"})
	public String lettersMapLocation() throws NamingException
	{
		InitialContext context = new InitialContext();
		return (String)context.lookup("cell/persistent/text/lettersMapLocation");
	}

	@Bean({"maxResults"})
	public Long maxResults() throws NamingException
	{
		InitialContext context = new InitialContext();
		String strMaxResult = (String) context.lookup("cell/persistent/text/maxResults");
		return Long.valueOf(strMaxResult);
	}

	@Bean({"expirationTime"})
	public Long expirationTime() throws NamingException
	{
		InitialContext context = new InitialContext();
		String expirationTime = (String) context.lookup("cell/persistent/text/correspondenceExpiryTime");
		return Long.valueOf(expirationTime);
	}

	@Bean({"numberOfQueueManagers"})
	public Long numberOfQueueManagers() throws NamingException
	{
		InitialContext context = new InitialContext();
		String numberOfQueueManagers = (String) context.lookup("jndi/numberOfQueueManagers");
		return Long.valueOf(numberOfQueueManagers);
	}

	@Bean({"parsingIndicator"})
	public String parsingIndicator() throws NamingException
	{
		InitialContext context = new InitialContext();
		return (String)context.lookup("string/parsingIndicator");
	}

	@Bean
	public TrackingService trackingService() throws NamingException
	{
		TrackingServiceImpl trackingServiceImpl = new TrackingServiceImpl();
		trackingServiceImpl.setParsingInd(parsingIndicator());
		return trackingServiceImpl;
	}
}
