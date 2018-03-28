package com.demo.slk.serilization;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class A extends B implements Serializable{
	private static final long serialVersionUID = 7003796516463260816L;
    
	private String sal;
	private String add;
	private C c;
	List<Integer> lst=Arrays.asList(121,323,32);
	public A(){
	}
	public A(String name){
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	
	public C getC() {
		return c;
	}
	public void setC(C c) {
		this.c = c;
	}
	
	public List<Integer> getLst() {
		return lst;
	}
	public void setLst(List<Integer> lst) {
		this.lst = lst;
	}
	@Override
	public String toString() {
		return "A [sal=" + sal + ", add=" + add + ", c=" + c + ", lst=" + lst + "]";
	}
}
