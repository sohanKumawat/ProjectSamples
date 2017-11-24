package com.demo.slk.concurrency.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProducerConsumerExampleWithWaitAndNotify
{
   public static void main(String[] args)
   {
	   Map<String,String> myMap = new ConcurrentHashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");
      int MAX_CAPACITY = 5;
      Thread tProducer = new Thread(new Producer(myMap, MAX_CAPACITY), "Producer");
      Thread tConsumer = new Thread(new Consumer(myMap), "Consumer");
      tProducer.start();
      tConsumer.start();
   }
}
