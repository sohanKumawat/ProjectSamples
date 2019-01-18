package com.slk.main.learning.lock;

import java.util.HashMap;
import java.util.Stack;

public class ThreadOddEvenPrinter {

	class PrinterThread1 extends Thread {
		StackHolder stackHolder = null;

		PrinterThread1(StackHolder stackHolder, String name) {
			Thread.currentThread().setName(name);
			this.stackHolder = stackHolder;
		}

		@Override
		public void run() {
			stackHolder.printOdd();
		}

	}

	class PrinterThread2 extends Thread {
		StackHolder stackHolder = null;

		PrinterThread2(StackHolder stackHolder, String name) {
			Thread.currentThread().setName(name);
			this.stackHolder = stackHolder;
		}

		@Override
		public void run() {
			stackHolder.printEven();
		}

	}

	static class StackHolder {
		Stack<Integer> stack = null;
		private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"sohan");
		static HashMap<String, String> map = new HashMap<>();

		StackHolder(Stack<Integer> stack) {
			this.stack = stack;
		}

		public static String get() {
			return threadLocal.get();
		}

		public static void set(String value) {
			threadLocal.set(value);
		}

		public void printOdd() {
			set("printOdd");
			while (stack.size() > 0) {
				try {
					synchronized (stack) {
						int val = stack.pop();
						System.out.println(Thread.currentThread().getName() + " - " + val+ " ** -- ** " + get());
						set("printOdd11");
						stack.notify();
						stack.wait();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public void printEven() {
			set("printEven");
			while (stack.size() > 0) {
				try {
					synchronized (stack) {
						int val = stack.pop();
						System.out.println(Thread.currentThread().getName() + " - " + val + " ** -- ** " + get());
						stack.notify();
						stack.wait();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String st[]) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 20; i > 0; i--) {
			stack.push(i);
		}
		ThreadOddEvenPrinter tOddEven = new ThreadOddEvenPrinter();
		StackHolder stackHolder = new StackHolder(stack);
		PrinterThread1 thread1 = tOddEven.new PrinterThread1(stackHolder, "T1");
		thread1.setName("T1");
		PrinterThread2 thread2 = tOddEven.new PrinterThread2(stackHolder, "T2");
		thread2.setName("T2");
		thread1.start();
		thread2.start();
	}

}
