package com.demo.slk.concurrency;

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

}
