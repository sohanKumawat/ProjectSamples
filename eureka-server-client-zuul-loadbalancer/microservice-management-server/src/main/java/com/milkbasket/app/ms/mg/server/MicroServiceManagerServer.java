package com.milkbasket.app.ms.mg.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceManagerServer {
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceManagerServer.class, args);
	}
}
