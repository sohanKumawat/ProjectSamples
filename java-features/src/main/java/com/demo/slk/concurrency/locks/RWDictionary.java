package com.demo.slk.concurrency.locks;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWDictionary {
	    private final Map<String, Integer> m = new TreeMap<String, Integer>();
	    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	    private final Lock r = rwl.readLock();
	    private final Lock w = rwl.writeLock();
	    RWDictionary(){
	    	m.put("sohan", 1235);
	    	m.put("sohan1", 1254);
	    	m.put("mohan", 1243);
	    	m.put("mohan1", 1232);
	    }
	    public Integer get(String key) {
	      r.lock();
	      System.out.println("r lock get");
	      try {
			//Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try { return m.get(key); }
	      finally { 
	    	  r.unlock();
	    	  }
	    }
	    public void allKeys() {
	      r.lock();
	      System.out.println("r lock allKeys");
	      try {
				//Thread.sleep(10000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      try { //return (String[]) m.keySet().toArray(); 
	    	  
	      }
	      finally { 
	    	  
	    	  r.unlock();
	    	  }
	    }
	    public Integer put(String key, Integer value) {
	      w.lock();
	      System.out.println("w lock put");
	      try {
				//Thread.sleep(10000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      try { return m.put(key, value); }
	      finally { 
	    	  w.unlock(); 
	    	  }
	    }
	    public void clear() {
	      w.lock();
	      System.out.println("w lock clear");
	      try {
				//Thread.sleep(10000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      try { m.clear(); }
	      finally {
	    	  w.unlock();
	    	  }
	    }
	    public static void main(String[] str){
	    	RWDictionary dictionary=new RWDictionary();
	    	dictionary.get("sohan");
	    	dictionary.get("sohan1");
	    	dictionary.allKeys();
	    	dictionary.put("sohan12",431);
	    	dictionary.clear();
	    }
}
