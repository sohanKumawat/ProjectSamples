package com.demo.slk.application.esshopifybacthprocesing.batch.writter.impl;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import com.demo.slk.application.esshopifybacthprocesing.batch.writter.DataItemWritter;

@StepScope
@Component(value="platformDataWritter")
public class DataItemWritterImpl<DataWriteItem> implements DataItemWritter<DataWriteItem> {
	@Override
	public void write(List<? extends DataWriteItem> items) throws Exception {
		System.out.println("Inside the data writter");
	}
}
