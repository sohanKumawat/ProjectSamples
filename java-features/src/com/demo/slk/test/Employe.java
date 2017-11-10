package com.demo.slk.test;

public class Employe {

	private String name;

	public Employe(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employe [name=" + name + "]";
	}
	
}
