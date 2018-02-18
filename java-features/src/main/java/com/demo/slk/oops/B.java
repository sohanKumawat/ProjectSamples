package com.demo.slk.oops;

public class B extends A {
	public int n = 122;

	@Override
	public Number add(int a, int b) {
		return a + b + 34;
	}

	@Override
	public Integer addNumber(int a, int b) {
		return a + b;
	}
	public void test() {
		System.out.println("hello");
	}
}
