package com.demo.slk.java8.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class AwesomeClass {
	@SuppressWarnings("unused")
	private static String  getDept(String name){
		return "sohan";
	}
	private String name;
    private static Integer invert(Integer value) {
    	System.out.println("hekllo");
        return -value;
    }
    
    public static int maxNumber(){
    	List<Integer> numbers=Arrays.asList(12,21,32,43,54);
    	return numbers.stream()
		.filter(val->val%2!=0) 		
		.filter(val->val>3)	
		.filter(val->val<11)	
		.max(Comparator.naturalOrder())
		.map(i -> i * i)
		.get();
    	
    }
    
    @SuppressWarnings("unused")
	public static Integer invertTheNumber(){
        Integer toInvert = 5;
        Function<String, String> dept = (s) -> s+"sohan";
        Function<Integer, Integer> invertFunction = AwesomeClass::invert;
        return compute(invertFunction, toInvert);
    }
    public static Integer compute(Function<Integer, Integer> function, Integer value) {
        return function.apply(value);
    }
    public static void main(String str[]){
    	System.out.println(AwesomeClass.invertTheNumber());
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
