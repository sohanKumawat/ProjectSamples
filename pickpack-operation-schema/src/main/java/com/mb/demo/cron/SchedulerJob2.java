package com.mb.demo.cron;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.mb.demo.repository.JobRepository;

@Component
//@Slf4j
public class SchedulerJob2 implements SchedulerObjectInterface {

	public static final String JOB = "job2";

	@Autowired
	JobRepository jobRepository;
	//ThreadPoolTaskScheduler taskScheduler;

	@SuppressWarnings("rawtypes")
	private ScheduledFuture future;

	@Autowired
	private TaskScheduler scheduler;

	@Override
	public void start() {
		future = scheduler.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println(JOB + "  Hello World! " + new Date());
			}
		}, new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				String cron = cronConfig();
				System.out.println(cron);
				CronTrigger trigger = new CronTrigger(cron);
				return trigger.nextExecutionTime(triggerContext);
			}
		});

	}

	@Override
	public void stop() {
		future.cancel(false);
	}

	// retrieve cron from database
	private String cronConfig() {
		JobScheduledEntity byJobNameIgnoreCase = jobRepository.findByNameIgnoreCase(JOB);
		return byJobNameIgnoreCase.getCronJobExpression();
	}

}
