package com.demo.slk.java8.interDemo;

public interface Interface1 {

	default void log(){
		System.out.println("interfac1");
	}
	static void addS(){
		System.out.println("I1 static");
	}
}
