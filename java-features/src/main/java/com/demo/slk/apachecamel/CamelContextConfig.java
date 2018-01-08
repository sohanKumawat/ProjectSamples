package com.demo.slk.apachecamel;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelContextConfig {
	@Bean
	CamelContextConfiguration contextConfiguration() {
		return new CamelContextConfiguration() {
			@Override
			public void beforeApplicationStart(CamelContext context) {
				/*
				 * play with camel context before application start
				 * 
				 */
			};
			@Override
			public void afterApplicationStart(CamelContext context) {
				/*
				 * 
				 */

			}
		};
	}
}
