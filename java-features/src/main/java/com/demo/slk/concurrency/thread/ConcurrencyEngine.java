package com.demo.slk.concurrency.thread;

/*Static synchronized methods synchronize on the class object. 
 * If one thread is executing a static synchronized method, 
 * all other threads trying to execute any static synchronized methods will be blocked.

   Non-static synchronized methods synchronize on this ie the instance of the class.
   If one thread is executing a synchronized method, all other threads trying to execute any synchronized methods will be blocked.
 * 
 * 
 */
public class ConcurrencyEngine {
	public static void main(String str[]) {
		SharedTable st = new SharedTable();
		MyThread1 t1 = new MyThread1(st);
		MyThread2 t2 = new MyThread2(st);
		MyThread3 t3 = new MyThread3(st);
		t1.start();
		t2.start();
		t3.start();
		ConcurrencyEngine c=new ConcurrencyEngine();
		ConcurrencyEngine.ax a=c.new ax();
	}
	public  class ax{
		private String anme="";
		private  void add(){
			
		}
	}
	
}
