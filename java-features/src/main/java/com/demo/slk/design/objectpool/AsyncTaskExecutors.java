package com.demo.slk.design.objectpool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public class AsyncTaskExecutors {
	static ThreadPoolTaskExecutor taskExecutor;
	static ThreadPoolTaskScheduler schedulerTaskExecutor;
	public static ThreadPoolTaskExecutor getTaskExecutor() {
		if (null != taskExecutor)
			return taskExecutor;
		taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(20);
		taskExecutor.setMaxPoolSize(50);
		taskExecutor.setQueueCapacity(512);
		taskExecutor.setThreadGroupName("task-executor");
		taskExecutor.setThreadNamePrefix("connection-");
		taskExecutor.initialize();
		return taskExecutor;
	}
	public static ThreadPoolTaskScheduler  getSchedulerTaskExecutor(){
		if(schedulerTaskExecutor!=null) return schedulerTaskExecutor;
	    ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
	    taskScheduler.setPoolSize(30);
	    taskScheduler.setThreadNamePrefix("schedule-task-executor");
	    taskScheduler.setThreadGroupName("connection");
	    return  taskScheduler;
	}
}
