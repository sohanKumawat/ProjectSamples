package com.demo.slk.application.kafka;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class UserPatitioner implements Partitioner {
	private UserManager userManager;

	public UserPatitioner() {
		userManager = new UserManager();
	}

	@Override
	public void configure(Map<String, ?> configs) {

	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

		int partition = 0;
		String userName = (String) key;
		Integer userId = userManager.findUserId(userName);
		if (userId != null) {
			partition = userId;
		}
		return partition;
	}

	@Override
	public void close() {

	}
}
