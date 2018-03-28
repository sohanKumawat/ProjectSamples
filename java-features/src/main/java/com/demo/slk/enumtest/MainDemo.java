package com.demo.slk.enumtest;

import java.util.HashMap;
import java.util.Map;

public class MainDemo {

	 public static void main(String[] str){
			System.out.println("name "+Modes.MODE1.name().toString());
			System.out.println("getValue "+Modes.MODE1.getValue().toString());
			System.out.println("ordinal "+Modes.MODE1.ordinal());
			System.out.println("getModeType "+Modes.getModeType("Mode1"));
			System.out.println("Values **  "+Modes.MODE1.m());
			Map<Modes ,Integer> enumMap=new HashMap<>();
			enumMap.put(Modes.MODE1, 1);
			enumMap.put(Modes.MODE1, 2);
			enumMap.put(Modes.MODE1, enumMap.get(Modes.MODE1)+32);
			System.out.println(enumMap.size() +"--" +enumMap.get(Modes.MODE1));
			
	 }
}
