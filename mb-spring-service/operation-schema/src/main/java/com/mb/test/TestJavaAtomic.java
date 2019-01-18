package com.mb.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class TestJavaAtomic {

	public static void main(String[] str) {
		
		String sql = "select ord.id,ord.hub_id,ord.cluster_id,ord.customer_id,ord.society_id,ord.tower_id,opm.product_id,opm.quantity,"
				+ "op.category_id,op.size,op.price,op.sheet,op.packing_type,op.scanner_code,op.image,"
				+ "op.name,op.type,op.subcategory_id,op.description from orders ord inner join order_product "
				+ "op on ord.id =op.order_id inner join order_product_mapping opm on op.order_id=opm.order_id "
				+ "and op.product_id=opm.product_id and ord.hub_id=" + 1 + " and ord.cluster_id in (" + 1
				+ ")";
		System.out.println(sql);
		System.out.println(ForkJoinPool.getCommonPoolParallelism());
		
		locking();
		
		AtomicInteger atomicInt = new AtomicInteger(0);

		ExecutorService executor = Executors.newFixedThreadPool(10);

		IntStream.range(0, 1000).forEach(i -> {
			Runnable task = () -> {
				// System.out.println(atomicInt.get());
				atomicInt.updateAndGet(n -> n + 2);
			};
			executor.submit(task);
		});
		executor.shutdown();

		System.out.println(atomicInt.get());

	}
	
	public static void locking() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();

		executor.submit(() -> {
			
			for(int i=0;i<1000;i++) {
			
		    lock.lock();
		    try {
		    	System.out.println("in run method"+Thread.currentThread().getName());
		        Thread.sleep(1);
		    } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		        lock.unlock();
		    }
			}
		});

//		executor.submit(() -> {
//		    System.out.println("Locked: " + lock.isLocked()+ " --- in run method"+Thread.currentThread().getName());
//		    System.out.println("Held by me: " + lock.isHeldByCurrentThread());
//		    boolean locked = lock.tryLock();
//		    System.out.println("Lock acquired: " + locked);
//		});

	}
	
	
}
