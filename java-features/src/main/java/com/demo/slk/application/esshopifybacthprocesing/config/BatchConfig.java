package com.demo.slk.application.esshopifybacthprocesing.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.demo.slk.application.esshopifybacthprocesing.batch.listener.JobListener;

@Configuration
@Import({StepConfig.class})
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	@Qualifier("productProcessStep")
	Step productProcessStep;
	@Autowired
	@Qualifier("collectionProcessStep")
	Step collectionProcessStep;
	
	@Bean
	public Job piDataJob() {
		return jobs.get("piDataJob").start(collectionProcessStep).next(productProcessStep).listener(listener()).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobListener();
	}

	@Bean
	public ResourcelessTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}
}
