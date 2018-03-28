package com.demo.slk.collection.tree;

public class Employee {

	private int id;
	private String name;

	@Override
	public int hashCode(){
		int prime=123;
		return prime*this.getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(obj instanceof Employee){
			Employee emp=(Employee) obj;
			return emp.getId()==this.getId() && this.hashCode()==obj.hashCode()?true:false;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
