package com.demo.slk.application.simpleSpringbatch;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
@StepScope
public class Writer implements ItemWriter<String> {
	@Override
	public void write(List<? extends String> messages) throws Exception {
		for(String msg : messages){
			System.out.println("#Writer Step: " + msg);
		}
	}
}
