package com.demo.slk.application.simpleSpringbatch.step;

import java.util.Collection;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.StepExecutionSplitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import com.demo.slk.application.simpleSpringbatch.Processor;
import com.demo.slk.application.simpleSpringbatch.Reader;
import com.demo.slk.application.simpleSpringbatch.SamplePartitioner;
import com.demo.slk.application.simpleSpringbatch.Writer;
import com.demo.slk.application.simpleSpringbatch.step.tasklet.Tasklet1;
import com.demo.slk.application.simpleSpringbatch.step.tasklet.Tasklet2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class StepConfig {
	@Autowired
	public StepBuilderFactory stepBuilder;

	@Autowired
	Tasklet1 tasklet1;

	@Autowired
	Tasklet2 tasklet2;
	@Autowired
	SamplePartitioner partitioner;

	@Bean
	public Step step1() {
		return stepBuilder.get("step1").tasklet(tasklet1).build()
		/*
		 * .<String, String> chunk(1) .reader(new Reader()) .processor(new
		 * Processor()) .writer(new Writer()) .build()
		 */;
	}

	@Bean
	public Step partitionerStep() {
		return stepBuilder.get("partitionerStep").partitioner("slave", partitioner).gridSize(5)
				.taskExecutor(new SimpleAsyncTaskExecutor()).partitionHandler(new PartitionHandler() {
					@Override
					public Collection<StepExecution> handle(StepExecutionSplitter stepSplitter,
							StepExecution stepExecution) throws Exception {
						log.info("insdie the PartitionHandler " + stepExecution.getCommitCount());
						return null;
					}
				}).build()
		/*
		 * .<String, String> chunk(1) .reader(new Reader()) .processor(new
		 * Processor()) .writer(new Writer()) .build()
		 */;
	}

	@Bean
	public Step slave() {
		return stepBuilder.get("slave").<String, String>chunk(1).reader(new Reader()).processor(new Processor())
				.writer(new Writer()).build();
	}

	@Bean
	public Step step2() {
		return stepBuilder.get("step2").tasklet(tasklet2).build();
	}
}
