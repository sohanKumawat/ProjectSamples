package com.demo.slk;

public class propTiger {

	public static void main(String[] str) {
		for (int i = 1;; i++) {
			int a = i / 10000;
			int b = (i / 1000) % 10;
			int c = (i / 100) % 10;
			int d = (i / 10) % 10;
			int e = (i / 1) % 10;

			int right = e * 10000 + d * 1000 + c * 100 + b * 10 + a;
			if (i * 4 == right) {
				System.out.println(i + "   right -"+right);
				break;
			}

		}

	}
}
