package com.mb.demo.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mb.demo.redis.processor.NodeItemMetdaDataProcessor;
import com.mb.demo.redis.processor.RedisOrderDataStoreProcess;

@Component
public class RedisCronScheduler {

	@Autowired
	NodeItemMetdaDataProcessor nodeItemMetaDataProcessor;
	@Autowired
	RedisOrderDataStoreProcess redisOrderProcess;

	@Scheduled(initialDelay = 3000, fixedDelay = 6000)
	public void updateOrders() {
		redisOrderProcess.processOrderAndUpdateRedisCache();
	}

	@Scheduled(initialDelay = 3000, fixedDelay = 6000)
	public void updateNodeProductMapping() {
		nodeItemMetaDataProcessor.creatNodeItemStorage();
	}

}
