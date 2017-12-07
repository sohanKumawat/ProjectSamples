package com.demo.slk.enumtest;

public class MainDemo {

	 public static void main(String[] str){
			System.out.println("name "+Modes.MODE1.name().toString());
			System.out.println("getValue "+Modes.MODE1.getValue().toString());
			System.out.println("ordinal "+Modes.MODE1.ordinal());
			System.out.println("getModeType "+Modes.getModeType("Mode1"));
			System.out.println("Values **  "+Modes.MODE1.m());
			
	 }
}
