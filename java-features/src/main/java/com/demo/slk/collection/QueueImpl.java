package com.demo.slk.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueImpl {
	 static PriorityQueue<Integer> pq=new PriorityQueue<>(5);
	 PriorityBlockingQueue<Integer> pbq=new PriorityBlockingQueue<>(100);
	 Queue<Integer> q=new LinkedList<>();

	 public static void pQueue(){
	 pq.add(1);
	 pq.add(30);
	 System.out.println(pq.poll());
	 Iterator it=pq.iterator();
	 pq.add(121);
	 while(it.hasNext()){
		 int val=(int) it.next();
		// System.out.println(val);
		 
	 }
 }
	public static void main(String[] str){
		pq.add(12);
		pq.add(10);
		pq.add(15);
		pq.add(5);
		pq.add(2);
		pQueue();
	}
}
