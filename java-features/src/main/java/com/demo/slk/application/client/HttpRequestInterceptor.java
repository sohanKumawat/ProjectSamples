package com.demo.slk.application.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
public class HttpRequestInterceptor implements ClientHttpRequestInterceptor {
	@Autowired
	PIClientCacheService cacheService;
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        	String clientId=request.getHeaders().get("clinetId").get(0);
        	request.getHeaders().set(HttpHeaders.AUTHORIZATION, cacheService.clientInfo(clientId).getAuthType()+" : "+cacheService.clientInfo(clientId).getAccessToken());
            return execution.execute(request, body);
        }
}
