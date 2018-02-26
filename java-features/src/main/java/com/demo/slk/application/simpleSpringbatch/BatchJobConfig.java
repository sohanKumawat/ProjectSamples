package com.demo.slk.application.simpleSpringbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.demo.slk.application.simpleSpringbatch.step.StepConfig;

@Configuration
@Import({ StepConfig.class })
public class BatchJobConfig {

	@Autowired
	private JobBuilderFactory jobBuilder;

	@Autowired
	private Step step1;

	@Autowired
	private Step step2;
	@Autowired
	private Step partitionerStep;
	
	

	@Bean
	public Job job() {
		return jobBuilder.get("job").incrementer(new RunIdIncrementer()).flow(step1).next(step2).next(partitionerStep).end()
				// .listener(interceptingJob)
				.build();
	}
}