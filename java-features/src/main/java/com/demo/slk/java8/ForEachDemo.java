package com.demo.slk.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://howtodoinjava.com/java-8-tutorial/
public class ForEachDemo extends ChildClass {
	static Map<String, Integer> map = new HashMap<String, Integer>();

	public static <T> String getObject(T Object) {
		System.out.println("Hello Sohan");
		return "hello";
	}

	public static void test(String key) {

		System.out.println("static");
	}

	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(12, 3, 435, 546, 6);
		map.merge("sohan", 1, (oldValue, value) -> oldValue + value);
		if (Objects.nonNull(lst))
			Objects.requireNonNull(lst);
		map.merge("mohan", 1, (oldValue, value) -> oldValue + value);
		lst.forEach(a -> System.out.println(a));
		map.merge("sohan", 1, (oldValue, value) -> oldValue + value);
		// lst.forEach(new Consumer<Integer>(){
		//
		// @Override
		// public void accept(Integer t) {
		// System.out.println(t);
		//
		// }
		//
		// });
		lst.stream().filter(a -> a > 12).collect(Collectors.toList());
		System.out.println("Map to String " + map.toString());
		ForEachDemo.getObject("");
		ForEachDemo.test();

		Function<Integer, Integer> add1 = x -> x + 1;
		Function<String, String> concat = x -> x + 1;
		
		Integer two = add1.apply(1); //yields 2
		String answer = concat.apply("0 + 1 = "); //yields "0 + 1 = 1"

		System.out.println("Map to String " +two+" - > "+answer);

Function<Integer, Function<Integer,Integer>> makeAdder = x -> y -> x + y;
System.out.println("Map to String " +makeAdder.apply(1).apply(2));

BinaryOperator<Function<Integer,Integer>> compose = (f,g) -> x -> g.apply(f.apply(x));
 int a=compose.apply((x->x+1),(y->y*5)).apply(2);
 System.out.println("**** A= "+a);
	}

}
