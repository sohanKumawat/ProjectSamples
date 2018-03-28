package com.demo.slk.serilization;

import java.io.Serializable;

public class Singleton implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final Singleton INSTANCE = new Singleton("Sohan");
	private int value;
    private Singleton(String str) {
    }
    protected Object readResolve() {
        return INSTANCE;
    }
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
    
}
