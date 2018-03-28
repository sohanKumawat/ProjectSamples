package com.demo.slk.application.simpleSpringbatch.step.tasklet;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public abstract class AbstracTasklet {
	@Value("#{jobParameters['folder']}")
	private String folder;
	@Value("#{jobParameters['filename']}")
	private String fileName;
}
