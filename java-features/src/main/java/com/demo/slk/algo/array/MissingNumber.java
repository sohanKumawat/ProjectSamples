package com.demo.slk.algo.array;

public class MissingNumber {

	public static String findMissingNumber(int[] a) {
		String r = "";
		int[] count=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		for (int i = 0; i < count.length; i++) {
			if(count[i]>0) System.out.println("Element is "+i);
		}
		
		for (int i = 0; i < a.length; i++) {
			int v = Math.abs(a[i]);
			if (a[v - 1] > 0) {
				a[v - 1] = -a[v - 1];
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0)
				r =r+ (i+1) + ",";
		}
		return r=r.substring(0, r.length() - 1);
	}

	public static void main(String[] str) {
		int[] a = { 1, 2, 4, 2, 3, 1 };
		String rs = MissingNumber.findMissingNumber(a);
		System.out.println("Result --- " + rs);
	}
}
