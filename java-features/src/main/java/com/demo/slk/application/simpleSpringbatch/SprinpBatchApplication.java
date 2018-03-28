package com.demo.slk.application.simpleSpringbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//http://javasampleapproach.com/spring-framework/spring-batch/use-spring-batch-late-binding-step-scope-job-scope
@SpringBootApplication
@EnableBatchProcessing
public class SprinpBatchApplication {
	public static void main(String[] args) {
		SpringApplication.run(SprinpBatchApplication.class, args);
	}
}