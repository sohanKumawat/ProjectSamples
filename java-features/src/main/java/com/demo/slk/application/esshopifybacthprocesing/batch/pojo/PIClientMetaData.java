package com.demo.slk.application.esshopifybacthprocesing.batch.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Session management required at client specific

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PIClientMetaData {
	private String botId;
	private String token;
	private String authType;
	private String platform;
	HttpHeaders httpHeaders = new HttpHeaders();
	Map<String, HttpHeaders> headerMap = new HashMap<>();

	public void setMetaData(HttpHeaders headers) {
		if (null == headers) {
			setMetaData();
		} else
			headerMap.put("botId" + "#" + platform, headers);
	}

	public void setMetaData() {
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("botId", botId);
		httpHeaders.set("platform", platform);
		httpHeaders.set(HttpHeaders.AUTHORIZATION, authType + " " + token);
		headerMap.put("botId" + "#" + platform, httpHeaders);
	}

	public HttpHeaders getMetaData(String botId, String platform) {
		Objects.requireNonNull(botId, "BotId is required parameter");
		Objects.requireNonNull(platform, "Platform is required parameter");
		return headerMap.get("botId" + "#" + platform);
	}
}
