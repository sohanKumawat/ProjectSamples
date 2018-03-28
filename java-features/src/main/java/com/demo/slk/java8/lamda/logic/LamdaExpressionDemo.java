package com.demo.slk.java8.lamda.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.demo.slk.java8.lamda.model.Developer;

public class LamdaExpressionDemo {

	
	@SuppressWarnings({ "serial", "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		List<Developer> result = new ArrayList<Developer>();
		List<HashMap<String,String>> mLst=new ArrayList<>();
        mLst.add(new HashMap<String,String>(){{
            put("id","1");
            put("name","sohan");
        }});
        mLst.add(new HashMap<String,String>(){{
            put("id","2");
            put("name","sohan1");
        }});
        mLst.add(new HashMap<String,String>(){{
            put("id","1");
            put("name","sohan2");
        }});
        List<HashMap> rmap= (List<HashMap>) mLst.stream().collect(Collectors.groupingBy(Function.identity()));
		result.add(new Developer("mkyong", 70000.0f, 33));
		result.add(new Developer("alvin", 80000.0f, 20));
		result.add(new Developer("jason", 100000.0f, 10));
		result.add(new Developer("alvin", 170000.0f, 55));
		Map<String, List<Developer>> counting=	result.stream().collect(Collectors.groupingBy(Developer::getName));
		System.out.println("before sort "+counting);
		Function<Integer, Integer> al=Developer::getValue;
		Comparator<Developer> salaryComparator = (o1, o2)->o1.getName().compareTo(o2.getName());
		result.sort(salaryComparator.reversed().thenComparing((d1,d2)->d1.getAge()-d2.getAge()));
       // System.out.println("after sort "+result.stream().collect(Collectors.groupingBy(Developer::groubByName)));
	//	result.forEach((developer)->System.out.println);
	   /*
		System::getProperty;
		System.out::println;
		"abc"::length;
		ArrayList::new;
		int[]::newl;
	*/

	}

}
