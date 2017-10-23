package com.demo.slk.concurrency;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class SimpleJoin {
	
	public static void messageThread(String message){
		System.out.println("Thread info ** "+Thread.currentThread().getName()+" -- "+message);
	}

	public static void main(String str[]){
		
		Thread t=new Thread(new CustomThread());
		
		messageThread("Starting CustomThread");
		long time=System.currentTimeMillis();
			t.start();
			messageThread("Waiting");
		
			while(t.isAlive()){
				try {
					t.join(1000);
					if((System.currentTimeMillis()-time)>1000 && t.isAlive()){
						messageThread("tired to waiting");
						//t.interrupt();
						t.join();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			messageThread("finally");
	}
	public  static class CustomThread implements Runnable{
		
		@Override
		public void run(){
			List<String> messages=Arrays.asList("sohan","mohan","father","brother");
			messages.forEach(msg ->{
				try {
					//messageThread("Before sleep"+msg);
					Thread.sleep(4000);
					messageThread(msg);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					messageThread("i wasnot done");
				}
			});
			
		}
	}
}
