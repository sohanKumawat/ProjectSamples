package com.slk.main.learning;

import java.util.HashMap;

public class JavaRecursion {

	public static int recu(int n, int result) {
		System.out.println(result);
		if (n == 1)
			return n;

		System.out.println("before forloop");
		for (int i = n; i >= 0; i--) {
			result = n + recu(n - 1, result);
			System.out.println("inside the loop" + n + " count - " + i);
		}
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] str) {
		int r = JavaRecursion.recu(5, 0);
		System.out.println(r);
		HashMap map=new HashMap<>();
	}

	// 5+4+3+2+1+4+3+2+1+3+2+1+2+1

}
