package com.demo.slk.algo.array;

import java.util.ArrayList;
import java.util.List;

public class LongestSubSequenceInc {
	/*Largest continuece sub sequence if i<j then a[i]<a[j]*/
	public static void longestSequence(int[] a){
		int[] dp=new int[a.length];
		dp[0]=1;
	
         List<Integer> prev=new ArrayList<>();
         
         List<Integer> current=new ArrayList<>();
         current.add(a[0]);
		for(int i=1;i<a.length;i++){
			if(a[i]>a[i-1]){
				current.add(a[i]);
			}
			else {
				if(prev.size()<current.size()) prev=current;
				current=new ArrayList<>();
				current.add(a[i]);
			}
		}
		if(prev.size()<current.size()) prev=current;
		System.out.println("prev "+prev);
		prev.forEach(val -> System.out.println(val));
	}
	public static void main(String[] args) {
		int[] arr={1,2,3,43,1,32,4,3,4,5,6,7};
		longestSequence(arr);
	}

}
