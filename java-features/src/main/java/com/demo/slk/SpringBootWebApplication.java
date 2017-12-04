package com.demo.slk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.demo.slk.onstarter.CustomBanner;
//https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-cli-command-line-completion
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringBootWebApplication{
    public static void main(String[] args) {
    	//System.setProperty("spring.devtools.restart.enabled", "false");
    	//SpringApplication.setRegisterShutdownHook(false))
        SpringApplication application = new SpringApplication(SpringBootWebApplication.class);
    	//application.setBannerMode(Banner.Mode.OFF);
    	application.setBanner(new CustomBanner());
    	application.run(args);
    }

}
