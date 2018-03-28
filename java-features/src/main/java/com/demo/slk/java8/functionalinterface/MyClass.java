package com.demo.slk.java8.functionalinterface;

import java.util.ArrayList;
import java.util.List;

public class MyClass implements Interface1, Interface2 {

	
	public void TestException() throws Exception{
		throw new Exception("Throw exception");
	}
	@Override
	public void method2() {
		
	}

	@Override
	public void method1(String str) {
	}
	

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		Interface1.super.log(str);
		System.out.println("MyClass logging::"+str);
		
		Interface1.print("abc");
		String val=fooByIC.method(str);
		Interface1.print(val);
	}
	Foo fooByIC = (s)-> s + " from Foo";
	static void print(String str){
		System.out.println("Printing "+str);
	}
	public void finalVariableDeclaration() {
	   /* String localVariable = "Local";
	    Foo foo = parameter -> {
	        // localVariable = parameter;
	        return localVariable;
	    }; */
		List<String> lint=new ArrayList<>();
		 Foo foo = parameter -> {
		        // localVariable = parameter;
			 String x="hello";
			 lint.add("chkdbzkfsd");
		        return "";
		    };
		    foo.method("sohan");
		    int[] total = new int[1];
		    Runnable r = () -> System.out.println("result "+ ++total[0]);
		    r.run();
		    System.out.println("lint Size "+lint.size());
	}
	public static void main(String[] str) throws Exception{
		MyClass myClass=new MyClass();
		myClass.log("sohan");
		Interface1 i1 = (s) -> System.out.println("interface method "+s);
		i1.log("jskcdnkzfnk");
		myClass.finalVariableDeclaration();
		myClass.TestException();
	}


}
