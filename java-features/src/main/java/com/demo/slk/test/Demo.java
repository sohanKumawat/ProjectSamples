package com.demo.slk.test;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] str) {

		List<Integer> ls = new ArrayList<>();
		ls.add(21);
		ls.add(3232);
		ls.add(1, 2132);
		System.out.println(ls.size() + "--" + ls);
		int[] r = new int[2];
		r[0] = 21;
		r[1] = 32;
	}
}
