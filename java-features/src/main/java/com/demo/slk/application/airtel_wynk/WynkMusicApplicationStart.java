package com.demo.slk.application.airtel_wynk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
public class WynkMusicApplicationStart {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WynkMusicApplicationStart.class, args);
	}
}
