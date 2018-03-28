package com.demo.slk.application.simpleSpringbatch.step.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
@StepScope
public class Tasklet1 extends AbstracTasklet implements Tasklet {
	public Tasklet1() {
		log.info("Contruction - # Tasklet 1");
	}
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		String pathFile = getFolder() + "\\" + getFileName();
		log.info("### Processing! Write to File: " + pathFile);
		/*
		 * if (!new File(pathFile).exists()) { try (BufferedWriter bw = new
		 * BufferedWriter(new FileWriter(pathFile))) { bw.write("Line 1");
		 * bw.newLine(); bw.write("Line 2"); bw.newLine(); bw.write("Line 3");
		 * bw.newLine(); bw.write("Line 4"); bw.newLine(); bw.write("Line 5"); }
		 * catch (IOException e) { e.printStackTrace(); } }
		 */
		return RepeatStatus.FINISHED;
	}
}
