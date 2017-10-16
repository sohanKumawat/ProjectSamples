package com.demo.slk.generic;

public class GenericDemo {

	public static <T> T requireNonNull(T obj) {
		if (obj == null)
			throw new NullPointerException();
		return obj;
	}

	public static <T> String getObject(T Object) {
		System.out.println("Hello Sohan");
		requireNonNull(Object);
		return "hello";
	}

	public static void main(String[] args) {
		GenericDemo.getObject(null);
	}
}
