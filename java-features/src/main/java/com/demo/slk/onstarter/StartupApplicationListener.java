package com.demo.slk.onstarter;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener {
   	 public static int counter;
	    @EventListener
	    public void onApplicationEvent(ContextRefreshedEvent event) {
	        counter++;
	    }
}
