package com.demo.slk.serilizationprocess;

public class A extends B {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private C c;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public C getC() {
		return c;
	}
	public void setC(C c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "A [name=" + name + "]";
	}
	
	
}
