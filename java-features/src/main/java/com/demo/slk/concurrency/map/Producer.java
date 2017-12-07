package com.demo.slk.concurrency.map;

import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("unused")
class Producer implements Runnable {
	private final Map<String, String> taskQueue;
	private final int MAX_CAPACITY;
	public Producer(Map<String, String> sharedQueue, int size) {
		this.taskQueue = sharedQueue;
		this.MAX_CAPACITY = size;
	}

	@Override
	public void run() {
		int counter = 0;
		while (true) {
			try {
				produce(counter++);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		Iterator<String> it1 = taskQueue.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			taskQueue.put("sohan", "sohan");
		}
	}
}