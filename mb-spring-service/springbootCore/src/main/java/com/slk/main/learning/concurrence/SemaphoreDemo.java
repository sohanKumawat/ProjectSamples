package com.slk.main.learning.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SemaphoreDemo {
	public static void main(String[] str) {
		int slots = 2;
		ExecutorService executorService = Executors.newFixedThreadPool(slots + 20);
		LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
		IntStream.range(0, 5).forEach(user -> executorService.execute(loginQueue::tryLogin));
		executorService.shutdown();
		int aSlot = loginQueue.availableSlots();
		System.out.println("Available slot - "+aSlot);
		loginQueue.tryLogin();

	}
}
