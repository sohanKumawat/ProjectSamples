package com.demo.slk.java8.interDemo;

public class InterfaceImpl implements Interface2{

	public static void main(String[] args) {
		new InterfaceImpl().log();

	}

	@Override
	public void log() {
		// TODO Auto-generated method stub
		//Interface2.super.log();
		Interface2.addS();
	}

}
