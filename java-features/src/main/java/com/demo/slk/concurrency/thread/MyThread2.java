package com.demo.slk.concurrency.thread;

public class MyThread2 extends Thread{
	SharedTable t=null;
public MyThread2(SharedTable t){
	this.t=t;
}
		@Override
		public void run(){
			//SharedTable at=new SharedTable();
			SharedTable.printTable2(10);
			
		}
}
