package com.slk.main.learning;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PassByValRef {

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
		a=123;
		b=324;
	}

	public static void swap(List<Integer> ls) {
		ls.set(0, 123);
		ls.set(1, 323);
	}

	public static void swap(A a, A b) {
		
		System.out.println(a.hashCode() + "==== -- " + b.hashCode());
		b = a;
		System.out.println(a.hashCode() + " sadcsfvd-- " + b.hashCode());
		a=new A("kumawatasdc");
		System.out.println(a.hashCode() + "fdf -- " + b.hashCode());
		System.out.println(a.toString() + " -- " + b.toString());
		a=null;
		
		// a.setName("kumar");
	}

	public static void main(String[] str) {
		
		LocalDate today = LocalDate.now();
		 today=today.minusDays(1);
		
		System.out.println(today.toString());
		int a = 10, b = 100;
		List<Integer> ls = Arrays.asList(12, 23);
		swap(a, b);
		System.out.println("a =="+a+" ==b=="+b);

		A a1 = new A("Sohan");
		A a2 = new A("kumawat");
		swap(ls);
		System.out.println(a1.toString() + " -- " + a2.toString());
		swap(a1, a2);

		System.out.println(ls.toString());
		System.out.println(a1.hashCode() + " -- " + a2.hashCode());
		System.out.println(a1.toString() + " -- " + a2.toString());

	}
}

class A {

	private String name;

	public A(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "A [name=" + name + "]";
	}
}
