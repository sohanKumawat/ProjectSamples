package com.demo.slk.java8.functionalinterface;
@FunctionalInterface
public interface Interface2 {

	void method(String str);
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}
	static void print(String str){
		System.out.println("Printing "+str);
	}
}
