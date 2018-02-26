package com.demo.slk.application.esshopifybacthprocesing.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.slk.application.esshopifybacthprocesing.batch.listener.JobListener;
import com.demo.slk.application.esshopifybacthprocesing.batch.listener.StepExecutionListenerImpl;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.DataItemRead;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.DataItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl.PlatformDataProcessor;
import com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl.PlatformDataReaderImpl;
import com.demo.slk.application.esshopifybacthprocesing.batch.writter.impl.DataItemWritterImpl;

@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;
	@SuppressWarnings("rawtypes")
	@Autowired
	PlatformDataReaderImpl platformDataReader;
	@SuppressWarnings("rawtypes")
	@Autowired
	PlatformDataProcessor platformDataProcessor;
	@SuppressWarnings("rawtypes")
	@Autowired
	DataItemWritterImpl platformDataWritter;

	@Bean
	public Job piDataJob(@Qualifier("dataProcessStep") Step dataProcessStep) {
		return jobs.get("piDataJob").start(dataProcessStep).listener(listener()).build();
	}

	@SuppressWarnings("unchecked")
	@Bean
	protected Step dataProcessStep() {
		return ((SimpleStepBuilder<DataItemRead, DataItemWrite>) steps.get("dataProcessStep")
				.<DataItemRead, DataItemWrite>chunk(10).reader(platformDataReader).processor(platformDataProcessor)
				.writer(platformDataWritter).chunk(100).listener(stepListener())).build();
		/*
		 * .faultTolerant().retryLimit(retryLimit)
		 * .retry(DeadlockLoserDataAccessException.class).skipLimit(1) //
		 * default is 0 .skip(Exception.class).build();
		 */ }

	@Bean
	public JobExecutionListener listener() {
		return new JobListener();
	}

	@Bean
	public ResourcelessTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}

	@Bean
	public StepExecutionListener stepListener() {
		return new StepExecutionListenerImpl();
	}

}
