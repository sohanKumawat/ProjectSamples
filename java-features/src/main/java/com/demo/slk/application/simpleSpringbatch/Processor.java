package com.demo.slk.application.simpleSpringbatch;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;

@StepScope
public class Processor implements ItemProcessor<String, String>{

	@Override
	public String process(String content) throws Exception {
		System.out.println("Inside processor");
		return content.toUpperCase();
	}
}
