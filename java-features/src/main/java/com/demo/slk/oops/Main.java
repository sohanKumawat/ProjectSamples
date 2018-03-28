package com.demo.slk.oops;

public class Main {
public static void main(String[] str){
	A b=new B();
	((B) b).test();
	System.out.println(b.n+" -- "+b.add(1,3));
}
}
