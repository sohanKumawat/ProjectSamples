package com.mb.demo.cron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class SchedulerCronConfig {

	@Bean
	public TaskScheduler scheduler() {
		 ThreadPoolTaskScheduler threadPoolTaskScheduler
         = new ThreadPoolTaskScheduler();
       threadPoolTaskScheduler.setPoolSize(5);
       threadPoolTaskScheduler.setThreadNamePrefix(
         "ThreadPoolTaskScheduler");
       return threadPoolTaskScheduler;
	}
}
