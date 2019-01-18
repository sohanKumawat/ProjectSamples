package com.slk.main.learning.concurrence;

import java.util.concurrent.CountDownLatch;

public class CountDownThread {

	public void multiThreads(int nThread) {
		CountDownLatch countdown = new CountDownLatch(nThread);
		for (int i = 0; i < nThread; ++i) {
		//	System.out.println(i);
			Thread t = new Thread() {
				public void run() {
					
					doSomething();
					countdown.countDown();
					System.out.println("Waiting on %d other threads."+ countdown.getCount());
					try {
						countdown.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // waits until everyone reaches this point
					finish();
				}
			};
		//	System.out.println(t.getName());
			t.start();
		}
	}

	public void doSomething() {
		System.out.println("doSomething");
	}

	public void finish() {
		System.out.println("finish");
	}

	public static void main(String[] str) {
		new CountDownThread().multiThreads(10);
	}
}
