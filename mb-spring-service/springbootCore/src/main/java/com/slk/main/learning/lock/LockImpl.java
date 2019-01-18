package com.slk.main.learning.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockImpl {

	int count = 0;

	class A extends Thread {
		@Override
		public void run() {

		}
	}

	class SynchronizedHashMapWithReadWriteLock {

		Map<String, String> syncHashMap = new HashMap<>();
		ReadWriteLock lock = new ReentrantReadWriteLock();
		Lock writeLock = lock.writeLock();

		Lock readLock = lock.readLock();

		public void put(String key, String value) {
			try {
				writeLock.lock();
				System.out.println("** THREAD NAME ** " + Thread.currentThread().getName());
				syncHashMap.put(key, value);
			} finally {
				writeLock.unlock();
			}
		}

		public String get(String key) {
			try {
				readLock.lock();
				System.out.println("** THREAD NAME ** " + Thread.currentThread().getName());
				return syncHashMap.get(key);
			} finally {
				readLock.unlock();
			}
		}

		public void remove(String key) {
			try {
				writeLock.lock();
				System.out.println("** THREAD NAME ** " + Thread.currentThread().getName());
				syncHashMap.remove(key);
			} finally {
				writeLock.unlock();
			}
		}

		class CustomLock {
			ReentrantLock lock = new ReentrantLock();

			public void performTryLock() {
				try {
					boolean isLockAcquired;
					isLockAcquired = lock.tryLock(1, TimeUnit.SECONDS);
					if (isLockAcquired) {
						try {
							count++;
							System.out.println("** THREAD NAME ** " + Thread.currentThread().getName() + " **count ** " + count);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}

	public static void main(String str[]) {

	}
}
