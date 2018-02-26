package com.demo.slk.application.esshopifybacthprocesing.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJobScheduler {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job piDataJob;

	@Scheduled(fixedRate = 5000)
	public void printMessage() {
		try {
			JobParameters jobParameters = new JobParametersBuilder().addString("botId", "123")
					.addString("readFlag", "yes").addString("platform", "shopify")
					.addLong("time", System.currentTimeMillis()).toJobParameters();
			jobLauncher.run(piDataJob, jobParameters);
			System.out.println("I have been scheduled with Spring scheduler");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
