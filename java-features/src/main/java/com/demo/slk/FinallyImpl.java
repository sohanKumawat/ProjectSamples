package com.demo.slk;

public class FinallyImpl {
	public static void main(String[] str) {
		System.out.println(result());
	}

	@SuppressWarnings("finally")
	public static int result() {
		try {
			throw new ArithmeticException();
		} catch (Exception ex) {
			System.out.println("hello");
			return 12;
			// throw new IndexOutOfBoundsException();
		} finally {
			// return 12;
			try {
				throw new NullPointerException("null");
			} catch (Exception ex) {
				return 123;
				// throw new NullPointerException("null");
			}
		}
	}

}
