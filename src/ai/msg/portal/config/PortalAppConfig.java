package ai.msg.portal.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import ai.msg.training.portal.common.utils.RabbitMQConfigHelper;
import ai.msg.training.portal.common.utils.StringUtility;
import ai.msg.training.portal.restclient.config.SocialApiConfig;

@Configuration
@EnableWebMvc
@EnableTransactionManagement()
@ComponentScan(basePackages = "ai.msg")
@PropertySource(value={"classpath:application.properties"})
@EnableJpaRepositories("ai.msg")
@EnableScheduling
public class PortalAppConfig implements SchedulingConfigurer {
	private static Logger LOGGER = LoggerFactory.getLogger(PortalAppConfig.class);

    @Autowired
    private transient static ApplicationContext applicationContext;
 
    @Autowired
    private Environment environment;
 
    /** RabbitMQ */
    @Bean
    public org.springframework.amqp.rabbit.connection.ConnectionFactory rabbitMQConnectionFactory() {
    	try {
			return RabbitMQConfigHelper.connectionFactory(environment.getRequiredProperty("rabbitmq.uri"));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IllegalStateException(ex.getMessage());
		}
    }

    @Bean
    public RabbitTemplate rabbitTemplate(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
    	RabbitTemplate rmqTemplate = new RabbitTemplate(connectionFactory);
    	rmqTemplate.setMessageConverter(RabbitMQConfigHelper.jsonMessageConverter());
    	return rmqTemplate;
    }

	@Override
	public void configureTasks(ScheduledTaskRegistrar registrar) {
	}

	@Bean 
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	
	 /** Database */
		@Bean(name="dataSource")
		public DataSource dataSource() {
			ComboPooledDataSource dataSource = new com.mchange.v2.c3p0.ComboPooledDataSource();

	        try {
				dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClassName"));
		        dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
		        dataSource.setUser(environment.getRequiredProperty("jdbc.username"));
		        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

		        dataSource.setAcquireIncrement(
		        		StringUtility.toInteger(environment.getProperty("jdbc.c3p0.acquireIncrement"), 2));
		        dataSource.setMinPoolSize(StringUtility.toInteger(environment.getProperty("jdbc.c3p0.minPoolSize"), 2));
		        //dataSource.setMaxPoolSize(StringUtility.toInteger(environment.getProperty("jdbc.c3p0.maxPoolSize"), 25));
		        dataSource.setMaxIdleTime(StringUtility.toInteger(environment.getProperty("jdbc.c3p0.maxIdleTime"), 180));

		        //LOGGER.debug("Connected to Database - {}", environment.getRequiredProperty("test.jdbc.url"));
	        } catch (Throwable th) {
				LOGGER.error("***** FATAL Failed to create DataSource", th);
				th.printStackTrace();
			}
	        
	        return dataSource;
		}

		@Bean
		public JdbcTemplate jdbcTemplate() {
			return new JdbcTemplate(dataSource());
		}

		//@Bean(name = "entityManager")
//		@DependsOn("transactionManager")
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
			LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
			entityManagerFactoryBean.setDataSource(dataSource());
			entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
			entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty("entitymanager.packages.to.scan"));
			entityManagerFactoryBean.setJpaProperties(hibProperties());
			return entityManagerFactoryBean;
		}

		private Properties hibProperties() {
			Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	        properties.put("hibernate.id.new_generator_mappings", Boolean.FALSE);
	        
			return properties;
		}

//		@Bean(name = "transactionManager")
		@Bean
		public JpaTransactionManager transactionManager() {
			JpaTransactionManager transactionManager = new JpaTransactionManager();
			transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
			transactionManager.afterPropertiesSet();
			System.out.println("JPA initilized");
			return transactionManager;
		}
	

	@Bean
	public ThreadPoolTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(512);
        executor.setThreadNamePrefix("msgai-executor-");
        executor.initialize();

        return executor;
    }

	@Bean 
	public SocialApiConfig getSocialApiConfig(){
		SocialApiConfig socialApiConfig=new SocialApiConfig();
		socialApiConfig.setHostName(environment.getRequiredProperty("socialChannelHost"));
		socialApiConfig.setContextPath(environment.getRequiredProperty("socialContextPath"));
		socialApiConfig.setPortNumber(environment.getRequiredProperty("socialChannelPort"));
		Map<String,String> map = new HashMap<String,String>();
		map.put("startService",environment.getRequiredProperty("startService"));
		map.put("stopService",environment.getRequiredProperty("stopService"));
		map.put("validConfig",environment.getRequiredProperty("validConfig"));
		map.put("allActiveList",environment.getRequiredProperty("allActiveList"));
		
		socialApiConfig.setApiUrls(map);
		return socialApiConfig;
	}

	public final static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static <T> T getBean(Class<? extends T> clazzType) {
		return getApplicationContext().getBean(clazzType);
	}

	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}

	public static <T> T getBean(String beanName, Class<? extends T> clazzType) {
		return getApplicationContext().getBean(beanName, clazzType);
	}

	/** Utility methods */
	public static String getEnv(String key) {
		return getApplicationContext().getEnvironment().getProperty(key);
	}
	
	/** used for using @Value annotation */
 	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
