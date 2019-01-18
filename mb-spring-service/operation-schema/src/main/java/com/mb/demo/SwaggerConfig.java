package com.mb.demo;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
public class SwaggerConfig  {
	
	
     
	@Bean
	public Docket api() {  

		return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.mb"))
          .paths(regex("/v1.*"))
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		//Contact c=new Contact("John Doe", "www.example.com", "myeaddress@company.com"); 
		ApiInfo apiInfo= new ApiInfo(
	       "My REST API", 
	       "Some custom description of API.", 
	       "API TOS", 
	       "Terms of service", 
	       "License of API",
	       "API license URL",
	       null);
		return apiInfo;
	}
}
