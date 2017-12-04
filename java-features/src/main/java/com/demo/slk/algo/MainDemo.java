package com.demo.slk.algo;

public class MainDemo {

	public static void main(String[] str){
		ListOperationImpl<Student> lstudent=new ListOperationImpl<Student>();
		lstudent.add(new Student("sohan12"));
		lstudent.add(new Student("sohan23"));
		lstudent.add(new Student("sohan34"));
		lstudent.add(new Student("sohan54"));
		lstudent.print();
	}
	
}
