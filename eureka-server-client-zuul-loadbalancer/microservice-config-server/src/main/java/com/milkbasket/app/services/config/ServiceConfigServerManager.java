package com.milkbasket.app.services.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServiceConfigServerManager {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceConfigServerManager.class).run(args);
	}

}
