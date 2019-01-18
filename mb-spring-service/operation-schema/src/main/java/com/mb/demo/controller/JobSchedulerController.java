package com.mb.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.constants.PickPackConstants;
import com.mb.demo.cron.JobMangerService;
import com.mb.demo.redis.service.HubTeamOrderService;

@RequestMapping("/v1/cron")
@RestController
public class JobSchedulerController {

	@Autowired
	JobMangerService jobManagerService;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Autowired
	HubTeamOrderService hubTeamOrderService;

	@GetMapping("/{name}")
	public String reStartScheduler(@PathVariable String name) {

		jobManagerService.startJob(name);
		return "Restarted job ;- " + name;

	}

	@DeleteMapping("/chache/{key}")
	public void deleteByKey(@PathVariable String key) {
		redisTemplate.delete(key);

	}

	@DeleteMapping("/chache/all")
	public void deleteAll() {
		 hubTeamOrderService.deleteAll();
		Set<String> keys = redisTemplate.keys(PickPackConstants.REDIS_KEY_PREFIX + "*");
		for (String rKey : keys) {
			redisTemplate.delete(rKey);
		}
		// redisTemplate.get

	}
}
