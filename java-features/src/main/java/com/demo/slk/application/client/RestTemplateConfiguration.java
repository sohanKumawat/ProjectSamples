package com.demo.slk.application.client;

import java.util.Collections;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate=new RestTemplate(getClientHttpRequestFactory());
		//restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		//restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		restTemplate.setInterceptors(Collections.singletonList(new HttpRequestInterceptor()));
		return  restTemplate;
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    int timeout = 5000;
	    RequestConfig config = RequestConfig.custom()
	      .setConnectTimeout(timeout)
	      .setConnectionRequestTimeout(timeout)
	      .setSocketTimeout(timeout)
	      .build();
	    CloseableHttpClient client = HttpClientBuilder
	      .create()
	      .setDefaultRequestConfig(config)
	      .build();
	    return new HttpComponentsClientHttpRequestFactory(client);
	}
}
