package com.demo.slk.java8.lamda.model;

public class Developer {

	private String name;
	private static String gbname;
	private float salary;
	private int age;

	public Developer(String name, float sal, int age) {
		this.name = name;
		this.salary = sal;
		this.age = age;
		gbname=name;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

	public static String groubByName(String name) {
		return gbname;
	}

	public static Integer getValue(Integer x) {
		return x;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
