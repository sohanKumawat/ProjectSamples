package com.demo.slk.concurrency.map;

import java.util.Iterator;
import java.util.Map;

class Consumer implements Runnable
{
   private final Map<String,String> taskQueue;
 
   public Consumer(Map<String,String> sharedQueue)
   {
      this.taskQueue = sharedQueue;
   }
 
   @Override
   public void run()
   {
      while (true)
      {
         try
         {
            consume();
         } catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
   }
 
   private void consume() throws InterruptedException
   {
	   Iterator<String> it1 = taskQueue.keySet().iterator();
		while(it1.hasNext()){
			String key = it1.next();
			taskQueue.remove(key);
		}
   }
}
