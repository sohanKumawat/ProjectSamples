package com.demo.slk.application.simpleSpringbatch.step.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
@JobScope
public class Tasklet2 extends AbstracTasklet implements Tasklet {
	public Tasklet2() {
		log.info("Contruction - # Tasklet 2");
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		String pathFile = getFolder() + "\\" + getFileName();
		log.info("### Processing! Read content of File: " + pathFile);
		/*
		 * try (Stream<String> stream = Files.lines(Paths.get(pathFile))) {
		 * stream.forEach(System.out::println); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */

		return RepeatStatus.FINISHED;
	}

}
