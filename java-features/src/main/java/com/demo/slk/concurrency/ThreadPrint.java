package com.demo.slk.concurrency;

public class ThreadPrint implements Comparable<String>{

	public static void main(String[] args) {
		/*
		 * int[] a={12,3,4,20,21}; Arrays.sort(a);
		 * System.out.println("Arrays "+a); int p=Arrays.binarySearch(a, 4);
		 * System.out.println("3 key element position "+p);
		 */
		String str=null;
		if(str==null || str.isEmpty()){
			System.out.println("IsEmpty");
		}
		Counter ctr = new Counter();
		Thread t1 = new Thread(new Thread1(ctr), "1st thread");
		Thread t2 = new Thread(new Thread2(ctr), "2st thread");
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
			while (ct.getValue() < 10) {
			ct.printOdd();
			}
			if(ct.getValue()>=10){
				System.exit(0);
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
			while (ct.getValue() < 10) {
			synchronized (ct) {
					ct.incr();
					System.out.println(Thread.currentThread().getName() + "count value " + ct.getValue());
					try {
						ct.notify();
						ct.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if(ct.getValue()>=10){
				System.exit(0);
			}
		}
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
