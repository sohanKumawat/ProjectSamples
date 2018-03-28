package com.demo.slk.application.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class PIClientCacheService {
	
	private Map<String, PIClient> cacheMap = new HashMap<>();

	public PIClient clientInfo(String clientId) {
		return cacheMap.get(clientId);
	}

	public PIClient getByClientId(String clientId) {
		return new PIClient();
	}

	public void setClientAsCache() {
		cacheMap.put("1", new PIClient());
		List<PIClient> piClient=new ArrayList<>();
		PIClient client=new PIClient();
		client.setClientId("1");
		PIClient client1=new PIClient();
		client1.setClientId("12");
		piClient.add(client);
		piClient.add(client1);
		cacheMap=(Map<String, PIClient>)piClient.stream().collect(
                Collectors.toMap(PIClient::getClientId, x->x));
	}
	@SuppressWarnings("unused")
	public static void main(String str[]){
		PIClientCacheService s=new PIClientCacheService();
		s.setClientAsCache();
		PIClient client=s.clientInfo("1");
	}

}
