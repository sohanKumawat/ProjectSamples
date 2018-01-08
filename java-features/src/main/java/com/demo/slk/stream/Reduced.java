package com.demo.slk.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reduced {

	public static void main(String[] args) {
		// Set start value. Result will be start value + sum of array.
		int[] array = { 23, 43, 56, 97, 32 };
		int startValue = 100;
		long sum = Arrays.stream(array).reduce(startValue, (x, y) -> x + y);
		System.out.println(sum);
		sum = Arrays.stream(array).reduce(startValue, Integer::sum);
		System.out.println(sum);
		sum = Arrays.stream(array).reduce(startValue, StatisticsUtility::addIntData);
		System.out.println(sum);
		int i=0;
		List<Integer> ls=new ArrayList<>();
		for(;i<2000;i++) ls.add(i);
		
		
		long sTime=System.currentTimeMillis();
		sum=ls.stream().reduce(startValue, (x, y) -> x + y);
		int diff=(int) (System.currentTimeMillis()-sTime);
		System.out.println("stream diff--"+diff+" ** Sum ** "+sum);
		ls.clear();
		i=0;
		for(;i<2000;i++) ls.add(i);
		
		
	    sTime=System.currentTimeMillis();
		sum=ls.parallelStream().reduce(startValue, (x, y) -> x + y);
		diff=(int) (System.currentTimeMillis()-sTime);
		System.out.println("parallel diff --"+diff+" ** Sum ** "+sum);
		//sum = ls.parallelStream().reduce(2, (s1, s2) -> s1 * s2, (p, q) -> p + q);

	}

	public static class StatisticsUtility {
		public static int addIntData(int num1, int num2) {
			return num1 + num2;
		}
	}
}
