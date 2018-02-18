package com.demo.slk.application.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@SpringBootApplication
@EnableJpaRepositories
public class ORMApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ORMApplication.class, args);
	}
}
