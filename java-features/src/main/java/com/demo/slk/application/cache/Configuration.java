package com.demo.slk.application.cache;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Configurable
public class Configuration {
	
	static{
		Velocity.init();
	}
	@Bean
	@Scope("prototype")
	public VelocityContext velocityCOntext(){
		VelocityContext context = new VelocityContext();
		return context;
	}
	
	
}
