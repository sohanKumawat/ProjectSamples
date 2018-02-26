package com.demo.slk.application.esshopifybacthprocesing;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RestAPIExchange {

	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<String> exchange(String url) throws Exception {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set(HttpHeaders.AUTHORIZATION, "Basic Y2VjMTYzZDY1MzU4Y2I0NmFlOTlkOTFhMWU0MjgxYWQ6NTAwNGM0ZmVjZGVkMDYxNTAwZjkyMGFlZWY1ZDY5Yjc=");
		try {
			url="https://sullivan-ponds.myshopify.com/admin"+url;
			HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
			return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		} catch (RestClientException e) {
			throw new Exception(e.getMessage(), e.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(" Exception message -" + e.getMessage());
			throw new Exception(e.getMessage(), e.getCause());
		}
	}

	@SuppressWarnings("unused")
	public String urlMaker() throws JsonProcessingException {
		String url = "https://sullivan-ponds.myshopify.com/admin/products.json?";
		// uri param replace

		Map<String, Object> uriParams = new HashMap<String, Object>();
		uriParams.put("title", "Arrow Smartwear T");

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set(HttpHeaders.AUTHORIZATION,
				"Basic Y2VjMTYzZDY1MzU4Y2I0NmFlOTlkOTFhMWU0MjgxYWQ6NTAwNGM0ZmVjZGVkMDYxNTAwZjkyMGFlZWY1ZDY5Yjc=");

		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

		String json = new ObjectMapper().writeValueAsString(uriParams);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("query", json);
		URI completeUrl = builder.build().encode().toUri();
		URI completeUrl1 = builder.build().toUri();
		ResponseEntity<String> reposne = restTemplate.exchange(completeUrl, HttpMethod.GET, httpEntity, String.class);
		String body = reposne.getBody();
		System.out.println("Response " + reposne.getBody().toString());
		return body;
	}
}