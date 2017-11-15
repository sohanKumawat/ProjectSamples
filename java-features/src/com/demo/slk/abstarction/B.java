package com.demo.slk.abstarction;

public abstract class B {
	
	private String name;
	public B(){
		System.out.println("Inside B");
	}
	public B(String str){
		System.out.println("Inside B  arg"+str);
		this.name=str;
	}
	public void add(){
		System.out.println("inside the add method Of B "+name);
	}

}
