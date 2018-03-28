package com.demo.slk.application.cache;

import org.springframework.stereotype.Component;

@Component
public class B {

	public void add(){
		System.out.println("hello add");
	}
	public static void staticAdd(){
		System.out.println("hello static add");
	}
	
}
