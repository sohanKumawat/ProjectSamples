package com.demo.slk.java8.interDemo;

public interface Interface2 extends Interface1 {
	default void log(){
		System.out.println("interfac2");
	}
	default void log2(){
		System.out.println("interfac2");
	}
	static void addS(){
		System.out.println("I2 static");
	}
}
