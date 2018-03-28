package com.demo.slk.serilizationprocess;

import java.io.Serializable;

public class B implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 11L;
private String sal;

public String getSal() {
	return sal;
}

public void setSal(String sal) {
	this.sal = sal;
}

@Override
public String toString() {
	return "B [sal=" + sal + "]";
}

}
