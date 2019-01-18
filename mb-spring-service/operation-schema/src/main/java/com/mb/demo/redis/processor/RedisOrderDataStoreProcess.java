package com.mb.demo.redis.processor;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.demo.redis.service.RedisOrderDataService;

@processor
public class RedisOrderDataStoreProcess {

	@Autowired
	RedisOrderDataService orderDataService;
	/*
	 * public void teamOrderProcessor(String hubId, String teamId) {
	 * teamOrderProcessor.addTeamOrders(teamId, hubId); }
	 * 
	 * public void orderDataProcessor() { for (int i = 0; i < 5; i++) {
	 * teamOrderProcessor(String.valueOf(i + 1), String.valueOf((i + 1) * 10)); } }
	 */

	public void processOrderAndUpdateRedisCache() {
		orderDataService.processOrder();
	}

	public void processOrderAndUpdateRedisCache(long hubId, long teamId) {
		orderDataService.processOrder(hubId, teamId);
	}
	public void processOrderAndUpdateRedisCache(long hubId) {
		orderDataService.processOrder(hubId);
	}

	/*
	 * public void hubOrderDataMapping() { String sql =
	 * "select tc.* , ch.hub_id from team_cluster tc , (select h.id as hub_id, c.id as c_id from hub h, clusters c where c.hub_id=h.id and h.flag=1 and c.flag=1) as ch where tc.cluster_id= ch.c_id  order by hub_id,team_id"
	 * ; }
	 */

}
