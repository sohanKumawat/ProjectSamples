package com.demo.slk.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringDemo {

	public static void test() {
		List<Integer> ids = Arrays.asList(1, 2, 3, 4, 10, 28, 34, 35, 36, 38, 39, 57, 62, 63, 67, 68, 69, 70, 72, 73,
				74, 75, 76, 78, 79, 82, 83, 84, 85, 89, 90, 91, 92, 93, 95, 96, 97, 98, 103, 105, 106, 107, 108, 110,
				112, 113, 114, 115, 117, 118, 120, 122, 125, 128, 129, 130, 131, 133, 135, 136, 137, 138, 139);
		String kpiIds = "";
		for (int i = 0; i < ids.size(); i++) {
			kpiIds = ids.size() - 1 == i ? kpiIds + ids.get(i) : kpiIds + ids.get(i) + ",";
		}
		List<String> cities = Arrays.asList("Milan", "London", "New York", "San Francisco");
		String citiesCommaSeparated = String.join(",", cities);
		System.out.println("** kpiIds * " + kpiIds + " *** *** " + citiesCommaSeparated);
	}
	public static void main(String str[]) {
		String s1 = new String("sohan");
		String s2 = new String("sohan");
		String s3 = "sohan";
		String s4 = "sohan";
		System.out.println(s1.equals(s2) + " s1==s2" + (s1 == s2) + "s1.e(s3)" + s3.equals(s1) + "s3==s4" + (s3 == s4)
				+ "s1==s3" + (s1 == s3));
		StringDemo.test();
		new StringDemo().m1().m2();
	}
	public StringDemo m1() {
		return this;
	}
	public StringDemo m2() {
		List<String> ls =new ArrayList<String>();
		return this;
	}
}
