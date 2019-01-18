package com.slk.main.learning.concurrence;

public class Counter {
	private int c = 0;

	public String incr() {
		c++;
		return "";
	}

	public String dec() {
		c--;
		return "";
	}

	public int getValue() {
		return c;
	}

	public void printOdd() {
		System.out.println("inside the printOdd");
		synchronized (this) {
			this.incr();
			System.out.println(Thread.currentThread().getName() + "odd count value " + this.getValue());
			try {
				this.notify();
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void printEven() {
		System.out.println("inside the printEven");
		synchronized (this) {
			this.incr();
			System.out.println(Thread.currentThread().getName() + " even count value " + this.getValue());
			try {
				this.notify();
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
