package com.demo.slk.concurrency;


public class MyRunnable implements Runnable{

	private Long count;
	public MyRunnable(Long count){
		this.count=count;
	}
	@Override
	public void run(){
		
		int sum=0;
		for(int i=0;i<count;i++){
			sum=sum+i;
		}
		System.out.println("sum -> "+sum);
	}
}
