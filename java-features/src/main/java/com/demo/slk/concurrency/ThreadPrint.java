package com.demo.slk.concurrency;

public class ThreadPrint {

	public static void main(String[] args) {
		Counter ctr = new Counter();
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
			while(true){
			synchronized(ct){
				ct.incr();
				System.out.println(Thread.currentThread().getName()+ "count value " + ct.getValue());
				try {
					ct.wait(100);
					ct.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			  }
			if(ct.getValue()>10) break;
			}
		}
	}

	private static class Thread2 implements Runnable {
		Counter ct;
		Thread2(Counter ct1) {
			this.ct = ct1;
		}
		@Override
		public void run() {
			while(true){
			synchronized(ct){
				ct.incr();
				System.out.println(Thread.currentThread().getName()+ "count value " + ct.getValue());
				try {
					ct.notify();
					ct.wait(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ct.getValue()>10)break;
		}
		}
	}

}
