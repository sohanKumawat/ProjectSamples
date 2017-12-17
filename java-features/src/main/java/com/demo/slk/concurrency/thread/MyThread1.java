package com.demo.slk.concurrency.thread;

public class MyThread1 extends Thread{
	SharedTable t=null;
public MyThread1(SharedTable t){
	this.t=t;
}
	@Override
	public void run(){
		//SharedTable at=new SharedTable();
		try{
		this.t.wait(100);
		t.printTable4(1);
		}
				catch(Exception ex){
					ex.printStackTrace();
				}
	}
}
