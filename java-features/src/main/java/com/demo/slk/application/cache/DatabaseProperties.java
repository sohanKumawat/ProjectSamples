package com.demo.slk.application.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@ConfigurationProperties(prefix="database.config")
@Component
public class DatabaseProperties {
	private String url;
	private String userName;//in properties file - >database.config.userName
	private String password;//in properties file - >database.config.password

}
