package com.demo.slk.application.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication

public class KafkaApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(KafkaApplication.class, args);
	}
}
