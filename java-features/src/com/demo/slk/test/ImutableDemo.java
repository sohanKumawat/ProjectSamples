package com.demo.slk.test;

import java.util.Arrays;
import java.util.List;

public class ImutableDemo {

	public static void main(String[] str) {
		new ImutableDemo().test();
	}

	public void test() {
		List<Employee> elst=Arrays.asList(new Employee("sohan"), new Employee("mohan"));
		Empl emp = new Empl(21, "sohan", Arrays.asList("sohan", "mohan"),elst);
		int st=emp.getId();st=213;
		List<Employee> elast = emp.getEmployee();
		elast.get(0).setName("jhcbskvbkjdsnbdf");
		System.out.println(emp.toString());
	}

}
