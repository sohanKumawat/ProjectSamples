package com.mb.demo.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobMangerService {

	@Autowired
	SchedulerOrchestrator schedulerOrchestrator;

	public void startJob(String jobName) {
		stopJob(jobName);
		schedulerOrchestrator.start(jobName);
	}

	public void stopJob(String jobName) {
		schedulerOrchestrator.stop(jobName);
	}

	public void stopAll() {
		schedulerOrchestrator.startAll();
	}

}
