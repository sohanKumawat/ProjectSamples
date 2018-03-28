package com.demo.slk.serilizationprocess;

import java.io.Serializable;

public class C implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "C [age=" + age + "]";
	}

}
