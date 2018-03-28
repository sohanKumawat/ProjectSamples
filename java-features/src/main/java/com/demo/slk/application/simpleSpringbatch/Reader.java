package com.demo.slk.application.simpleSpringbatch;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

@StepScope
public class Reader implements ItemReader<String>{

	private String[] messages = {"Hello World!", "Welcome to Spring Batch!"};
	
	private int count=0;
	
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("Inside reader"+count);
		if(count < messages.length){
			return messages[count++];
		}else{
			count=0;
		}
		return "sohan";
	}
}
