package com.demo.slk.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//http://www.baeldung.com/circular-dependencies-in-spring
@Configuration
@ComponentScan(basePackages = { "com.demo.slk.spring" })
public class AppConfig {

}
