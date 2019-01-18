package com.mb.test.http.client;

import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class Httpclient {

	static HttpClient client = HttpClientBuilder.create().build();

	public static String call(String url) {

		HttpPost post = new HttpPost(url);

		// add header
		// post.setHeader("User-Agent", USER_AGENT);
		//
		// List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		// urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		// urlParameters.add(new BasicNameValuePair("cn", ""));
		// urlParameters.add(new BasicNameValuePair("locale", ""));
		// urlParameters.add(new BasicNameValuePair("caller", ""));
		// urlParameters.add(new BasicNameValuePair("num", "12345"));
		//
		// post.set
		// post.setEntity(inputRequest);
		//
		// HttpResponse response = client.execute(post);
		//
		//
		// //srequest.addHeader("User-Agent", USER_AGENT);
		// HttpResponse response = client.execute(request);
		//
		// post.setEntity(new UrlEncodedFormEntity(postParams));
		//
		//
		// post.setHeader("Host", "accounts.google.com");
		// post.setHeader("User-Agent", USER_AGENT);
		// post.setHeader("Accept",
		// "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		// post.setHeader("Accept-Language", "en-US,en;q=0.5");
		// post.setHeader("Cookie", getCookies());
		// post.setHeader("Connection", "keep-alive");
		// post.setHeader("Referer", "https://accounts.google.com/ServiceLoginAuth");
		// post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		// CloseableHttpClient client = HttpClients.custom().build();
		return null;
	}

	public static class HttpHeader {

		HttpHeaders header;
		// HttpHeaders.CONTENT_TYPE, "application/json",

		public HttpHeaders addHeader() {
			return header;
		}

	}

}
