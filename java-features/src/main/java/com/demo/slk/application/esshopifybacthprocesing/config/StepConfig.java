package com.demo.slk.application.esshopifybacthprocesing.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.slk.application.esshopifybacthprocesing.batch.listener.StepExecutionListenerImpl;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemRead;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl.PICollectionDataProcessor;
import com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl.PIProductDataProcessor;
import com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl.PICollectionDataReaderImpl;
import com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl.PIProductDataReaderImpl;
import com.demo.slk.application.esshopifybacthprocesing.batch.writter.impl.PICollectionItemWritterImpl;
import com.demo.slk.application.esshopifybacthprocesing.batch.writter.impl.PIProductItemWritterImpl;

@Configuration
public class StepConfig {
	@Autowired
	private StepBuilderFactory steps;

	@SuppressWarnings("rawtypes")
	@Autowired
	PIProductDataReaderImpl piproductDataReader;
	@SuppressWarnings("rawtypes")
	@Autowired
	PIProductDataProcessor piproductDataProcessor;
	@SuppressWarnings("rawtypes")
	@Autowired
	PIProductItemWritterImpl piproductDataWritter;

	@SuppressWarnings("rawtypes")
	@Autowired
	PICollectionDataReaderImpl picollectionDataReader;
	@SuppressWarnings("rawtypes")
	@Autowired
	PICollectionDataProcessor picollectionDataProcessor;
	@SuppressWarnings("rawtypes")
	@Autowired
	PICollectionItemWritterImpl picollectionDataWritter;

	@SuppressWarnings("unchecked")
	@Bean("productProcessStep")
	public Step productProcessStep() {
		return ((SimpleStepBuilder<DataItemRead, DataItemWrite>) steps.get("productProcessStep")
				.<DataItemRead, DataItemWrite>chunk(10).reader(piproductDataReader).processor(piproductDataProcessor)
				.writer(piproductDataWritter).chunk(100).listener(stepListener())).build();
	}

	@SuppressWarnings("unchecked")
	@Bean("collectionProcessStep")
	public Step collectionProcessStep() {
		return ((SimpleStepBuilder<DataItemRead, DataItemWrite>) steps.get("collectionProcessStep")
				.<DataItemRead, DataItemWrite>chunk(10).reader(picollectionDataReader)
				.processor(picollectionDataProcessor).writer(picollectionDataWritter).chunk(100)
				.listener(stepListener())).build();
	}

	@Bean
	public StepExecutionListener stepListener() {
		return new StepExecutionListenerImpl();
	}
}

/*
 * .faultTolerant().retryLimit(retryLimit)
 * .retry(DeadlockLoserDataAccessException.class).skipLimit(1) // default is 0
 * .skip(Exception.class).build();
 */
