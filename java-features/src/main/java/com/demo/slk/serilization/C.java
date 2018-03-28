package com.demo.slk.serilization;

import java.io.Serializable;

public class C implements Serializable{
	private static final long serialVersionUID = 2144395560121466508L;
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "C [value=" + value + "]";
	}
	
}
