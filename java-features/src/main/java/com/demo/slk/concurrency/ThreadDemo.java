package com.demo.slk.concurrency;

public class ThreadDemo {

	public static void main(String[] args) {
		Counter ctr = new Counter();
		Thread t= new Thread(() -> {
			System.out.println("hello"); 
		 });
		t.start();
		Thread t1=new Thread(new Thread1(ctr),"1st thread");
		Thread t2=new Thread(new Thread2(ctr),"2st thread");
		t1.start();
		t2.start();
	}

	private static class Thread1 implements Runnable {
		Counter ct;
		Thread1(Counter ct) {
			this.ct = ct;
		}
		@Override
		public void run() {
			for(int i=0;i<10;i++)
			System.out.println(Thread.currentThread().getName()+ "before dec Value " + ct.getValue() + "--" + ct.dec() + "After in" + ct.getValue());
		}
	}

	private static class Thread2 implements Runnable {
		Counter ct1;
		Thread2(Counter ct1) {
			this.ct1 = ct1;
		}
		@Override
		public void run() {
			for(int i=0;i<10;i++)
			System.out.println(Thread.currentThread().getName()+ "before inc Value " + ct1.getValue() + "--" + ct1.incr() + "After in" + ct1.getValue());
		}
	}

}
