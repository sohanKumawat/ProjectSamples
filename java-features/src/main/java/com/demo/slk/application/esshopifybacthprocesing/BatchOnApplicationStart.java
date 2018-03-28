package com.demo.slk.application.esshopifybacthprocesing;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BatchOnApplicationStart {
	public static int counter;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		counter++;
		System.out.println("** Application start counter ** " + counter);
	}

}
