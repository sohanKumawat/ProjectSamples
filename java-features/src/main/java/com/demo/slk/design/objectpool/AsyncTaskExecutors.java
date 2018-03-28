package com.demo.slk.design.objectpool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
	public static void main(String[] str){
		Queue<Integer> queueNumbers = new ArrayBlockingQueue<>(3);
		Queue<Integer> priorityQueue = new LinkedBlockingQueue<>(3);
		 
		System.out.println(priorityQueue.offer(1));
		System.out.println(priorityQueue.offer(2));
		System.out.println(priorityQueue.offer(3));
		System.out.println(priorityQueue.offer(4));
		System.out.println("** queue size ** "+priorityQueue.size());
	}
}
