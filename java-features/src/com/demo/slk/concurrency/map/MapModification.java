package com.demo.slk.concurrency.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapModification {

	public void mapModification() {

		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("test", "test1");
		myMap.put("test2", "test2");
		Iterator<Entry<String, String>> it = myMap.entrySet().iterator();
		while (it.hasNext()) {
			if ("test".equals(it.next().getKey())) {
				it.remove();
				myMap.put("sohan","sohan");
				myMap.put("test2","sohan");
				System.out.println("removed element from map ");
			}
		}
		System.out.println("myMap size after modification "+myMap.size());
		
		
		Map<String,String> myMap1 = new HashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap1.keySet().iterator();
		while(it1.hasNext()){
			String key = it1.next();
			System.out.println("Map Value:"+myMap1.get(key));
			if(key.equals("2")){
				myMap1.put("1","4");
				//myMap.put("4", "4");
			}
		}
		
	}
	public static void main(String[] str){
		new MapModification().mapModification();
	}
}
