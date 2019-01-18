package com.demo.slk.design.builder;

public class SampleDemo {

	public static void main(String[] str) {

		Sample sample=Sample.builder().name("sohan").build();
		System.out.println(sample.toString());
	
		
	}	
}
