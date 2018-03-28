package com.demo.slk.design;
import static com.demo.slk.controller.StaticTest.test;
public class MainDemo {

	public void add() throws Throwable{
		System.out.println("ad method");
	}
	
	public static void main(String str[]){
		test();
		try {
			new MainDemo().add();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
