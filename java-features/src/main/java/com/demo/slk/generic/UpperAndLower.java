package com.demo.slk.generic;

import java.util.ArrayList;
import java.util.List;

public class UpperAndLower {
public static void listIterator(List<?> ls){
	ls.forEach(value->System.out.println(value));
}

	public static void main(String str[]){
		List<Integer> ils=new ArrayList<>();
		ils.add(12);
		ils.add(32);
		ils.add(222);
		listIterator(ils);
		List<Double> dLs=new ArrayList<>();
		dLs.add(12.9);
		dLs.add(32.1);
		dLs.add(222.2);
		listIterator(dLs);
	}
	
}
