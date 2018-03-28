package com.demo.slk.application.cache.dozer;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitilization {
	@Bean
	public DozerBeanMapper mapper() throws Exception {
		return new DozerBeanMapper();
	}
	
}
