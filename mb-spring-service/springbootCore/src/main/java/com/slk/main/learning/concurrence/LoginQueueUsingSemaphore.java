package com.slk.main.learning.concurrence;

import java.util.concurrent.Semaphore;

public class LoginQueueUsingSemaphore {

	private Semaphore semaphore;

	public LoginQueueUsingSemaphore(int slotLimit) {
		semaphore = new Semaphore(slotLimit);
	}

	boolean tryLogin() {
		semaphore.tryAcquire();
		System.out.println("tryLogin");
		return false;
	}

	void logout() {
		System.out.println("logout");
		semaphore.release();
	}

	int availableSlots() {
		return semaphore.availablePermits();
	}
}
