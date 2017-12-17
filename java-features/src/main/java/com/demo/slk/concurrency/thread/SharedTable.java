package com.demo.slk.concurrency.thread;

public class SharedTable {

	 synchronized static void printTable1(int n){  
	   for(int i=1;i<=10;i++){  
	     System.out.println("printTable1");  
	     try{  
	       Thread.sleep(400);  
	     }catch(Exception e){}  
	   }  
	 }  
	 synchronized static void printTable2(int n){  
		   for(int i=1;i<=10;i++){  
		     System.out.println("printTable2");  
		     try{  
		       Thread.sleep(400);  
		     }catch(Exception e){}  
		   }  
		 } 
	  static void printTable3(int n){  
		   for(int i=1;i<=10;i++){  
		     System.out.println("printTable3");  
		     try{  
		       Thread.sleep(400);  
		     }catch(Exception e){}  
		   }  
		 }  
	public synchronized  void printTable4(int n){  
		wait()
		   for(int i=1;i<=10;i++){  
		     System.out.println("printTable4");  
		     try{  
		       Thread.sleep(400);  
		     }catch(Exception e){}  
		   }  
		 }  
	public  synchronized  void printTable5(int n){
		
		   for(int i=1;i<=10;i++){  
		     System.out.println("printTable5");  
		     try{  
		       Thread.sleep(400);  
		     }catch(Exception e){}  
		   }  
		 }  
	public   void printTable6(int n){  
		   for(int i=1;i<=10;i++){  
		     System.out.println("printTable6");  
		     try{  
		       Thread.sleep(400);  
		     }catch(Exception e){}  
		   }  
		 } 
}
