package com.demo.slk.application.client;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HttpHeaderHelper {

	public static HttpEntity<String> getHttpHeader(String clientId){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("clientId", clientId);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}

}
