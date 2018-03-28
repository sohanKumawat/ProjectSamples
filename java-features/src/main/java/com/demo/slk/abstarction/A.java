package com.demo.slk.abstarction;

import java.util.HashMap;
import java.util.Map;

class A {
	public static void main(String[] str) {
		/*int a[] = { 7,2,3,10,2,4,8,1 };
		List<Integer> dif = new ArrayList<>();
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < a[i + 1]) {
				dif.add(a[i + 1] - a[i]);
			}
		}
		Collections.sort(dif);
		System.out.println(dif.get(dif.size() - 1));*/
		new A();
		testSweet();

	}
	public static void testSweet(){
		float t=12/5;
		float t1=12%5;
		System.out.println("Val --"+12/5+" t1 --"+12%5);
		String[] str={"ab","b","c","ab","ac","bd","ac","ab"};
		Map<String, Integer> sCount=new HashMap<>();
		for(int i=0;i<str.length;i++){
			if(sCount.containsKey(str[i])){sCount.put(str[i],sCount.get(str[i])+1);
			}
			else sCount.put(str[i],1);
		}
		int val=0;
		String result="";
		String current=null;
		for(Map.Entry<String,Integer> entry:sCount.entrySet()){
			if(current==null){
				current=entry.getKey().toLowerCase();
				val=entry.getValue();
				result=current;
			}
			else{
				if(val<=entry.getValue()){
						current=entry.getKey().toLowerCase();
						int le=current.length()<result.length()?current.length():result.length();
						for(int i=0;i<le;i++){
							int c1=(int) current.charAt(i);
							int c2=(int) result.toLowerCase().charAt(i);
							if(c1>c2) {
								result=current;
								val=entry.getValue();
							}
						}
				}
				
				
			}
		}
		System.out.println(result);
		//List<Integer> clist=(List<Integer>) sCount.values();
		//System.out.println(clist.get(clist.size()-1));
	}
}
