package com.demo.slk.concurrency.thread;

public class MyThread3 extends Thread{
	SharedTable t=null;
public MyThread3(SharedTable t){
	this.t=t;
}
	@Override
	public void run(){
		//SharedTable at=new SharedTable();
		t.printTable4(100);
		
	}
}
