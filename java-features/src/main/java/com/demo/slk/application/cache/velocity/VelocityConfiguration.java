package com.demo.slk.application.cache.velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class VelocityConfiguration {
	static {
		Velocity.init();
	}

	@Bean
	@Scope("prototype")
	public VelocityContext velocityCOntext() {
		VelocityContext context = new VelocityContext();
		return context;
	}
}
