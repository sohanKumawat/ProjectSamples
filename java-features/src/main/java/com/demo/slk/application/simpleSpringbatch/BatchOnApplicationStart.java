package com.demo.slk.application.simpleSpringbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BatchOnApplicationStart {
	public static int counter;
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		counter++;
		try {
			JobParameters jobParameters = new JobParametersBuilder()
					.addString("name", "Sohan")
					.addString("filename", "sohan.txt")
					.addString("folder", "Director")
					.toJobParameters();
			jobLauncher.run(job, jobParameters);
		} catch (Exception e) {
		}
	}

}
