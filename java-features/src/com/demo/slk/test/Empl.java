package com.demo.slk.test;

import java.util.List;

public class Empl {
	
private final int id;
private final String name;
private final List<String> address;
private final List<Employee> employee;

public Empl(int id,String name,List<String> address,List<Employee> employee){
	this.id=id;
	this.name=name;
	this.address=address;
	this.employee=employee;
}

public int getId() {
	return id;
}

public String getName() {
	return name;
}

public List<String> getAddress() {
	return address;
}


public List<Employee> getEmployee() {
	return this.employee;
}

@Override
public String toString() {
	return "Empl [id=" + id + ", name=" + name + ", address=" + address + ", employee=" + employee + "]";
}

}
