package com.mb.demo.cron;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

//https://stackoverflow.com/questions/41186633/spring-update-scheduler?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
@Configuration
// @Slf4j
@EnableScheduling
public class SchedulerOrchestrator {

	private static Map<String, SchedulerObjectInterface> schduledJobsMap = new HashMap<>();

	@Autowired
	SchedulerJob1 myFirstJob;

	@Autowired
	SchedulerJob2 mySecondJob;

	//@PostConstruct
	public void initScheduler() {
		schduledJobsMap.put(SchedulerJob1.JOB, myFirstJob);
		schduledJobsMap.put(SchedulerJob2.JOB, mySecondJob);

		startAll();
	}

	public void restart(String job) {
		stop(job);
		start(job);
	}

	public void stop(String job) {
		schduledJobsMap.get(job).stop();
	}

	public void start(String job) {
		schduledJobsMap.get(job).start();
	}
	

	public void startAll() {
		for (SchedulerObjectInterface schedulerObjectInterface : schduledJobsMap.values()) {
			schedulerObjectInterface.start();
		}
	}

}
