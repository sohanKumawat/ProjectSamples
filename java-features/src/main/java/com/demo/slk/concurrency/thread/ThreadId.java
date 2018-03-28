package com.demo.slk.concurrency.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {
	private static final AtomicInteger nextId = new AtomicInteger(0);
	private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return nextId.getAndIncrement();
		}
	};
public static Runnable r=new Runnable(){
	@Override
	public void run(){
		threadId.set((int) (Math.random() * 100));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(threadId.get());
	}
  } ;
	public static int get() {
		return threadId.get();
	}

	public static void main(String[] str) {
		ThreadId tid = new ThreadId();
		Thread t=new Thread(r);
		Thread t2=new Thread(r);
		t.start();
		try{
			t.join();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		t2.start();
		tid.threadId.set(123);
		for (int i = 0; i < 5; i++) {
			System.out.println(tid.threadId.get());
		}
	}
}
