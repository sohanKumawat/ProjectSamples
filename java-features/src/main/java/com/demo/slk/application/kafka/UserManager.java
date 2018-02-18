package com.demo.slk.application.kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
	private Map<String, Integer> usersMap;

	public UserManager() {
		usersMap = new HashMap<>();
		usersMap.put("Tom", 1);
		usersMap.put("Mary", 2);
		usersMap.put("Alice", 3);
		usersMap.put("Daisy", 4);
		usersMap.put("Helen", 5);
	}

	public Integer findUserId(String userName) {
		return usersMap.get(userName);
	}

	public List<String> findAllUsers() {
		return new ArrayList<>(usersMap.keySet());

	}

}
