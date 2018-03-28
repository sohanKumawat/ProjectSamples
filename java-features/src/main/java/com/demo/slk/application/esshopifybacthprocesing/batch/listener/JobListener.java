package com.demo.slk.application.esshopifybacthprocesing.batch.listener;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobListener extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {
			System.out.println("BATCH JOB Failed");
			 List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
	            for(Throwable th : exceptionList){
	                System.err.println("exception :" +th.getLocalizedMessage());
	            }
		}
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
	}
}
