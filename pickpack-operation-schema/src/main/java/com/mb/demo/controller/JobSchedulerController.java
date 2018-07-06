package com.mb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.cron.JobMangerService;

@RestController
public class JobSchedulerController {

	@Autowired
	JobMangerService jobManagerService;

	@GetMapping("/cron/{name}")
	public String reStartScheduler(@PathVariable String name) {

		jobManagerService.startJob(name);
		return "Restarted job ;- " + name;

	}
}
