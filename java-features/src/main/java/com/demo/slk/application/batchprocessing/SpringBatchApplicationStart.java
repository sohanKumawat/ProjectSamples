package com.demo.slk.application.batchprocessing;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@SpringBootApplication
@EnableJpaRepositories
@EnableBatchProcessing
@EnableScheduling
public class SpringBatchApplicationStart {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBatchApplicationStart.class, args);
	}
}
