package com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.processor.PIDataProcessorFactory;


@StepScope
@Component(value="piproductDataProcessor")
public class PIProductDataProcessor<R, W extends DataItemWrite> implements ItemProcessor<R, DataItemWrite> {
	@Value("#{jobParameters['platform']}")
	private String platform="shopify";

	@SuppressWarnings("unchecked")
	@Override
	public DataItemWrite process(R item) throws Exception {
		System.out.println("inside the data processor");
		return PIDataProcessorFactory.getPIDataProcessor(platform,"product").process(item);
	}
}
