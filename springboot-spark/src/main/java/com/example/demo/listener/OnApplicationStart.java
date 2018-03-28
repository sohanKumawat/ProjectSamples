package com.example.demo.listener;

import org.apache.spark.sql.SparkSession;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OnApplicationStart {
   	 public static int counter;
	    @EventListener
	    public void onApplicationEvent(ContextRefreshedEvent event) {
	        counter++;
	        SparkSession sparkSession = SparkSession
	  		      .builder()
	  		      .appName("SparkWithSpring")
	  		      .master("local")
	  		      .getOrCreate();
	  		      System.out.println("Spark Version: " + sparkSession.version());
	    }
}
