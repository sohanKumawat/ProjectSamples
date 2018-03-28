package com.demo.slk.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class FlatMapExample1 {
	public static void main(String[] args) {

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        Map<String, Integer> tMap=new TreeMap<>();
        tMap.put("bc",12);
        tMap.put("ac",122);
        tMap.put("abc",32);
        tMap.put("adc",320);
        System.out.println(tMap.toString());
        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        //Stream<String>, GOOD!
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));

        Stream<String> stream = stringStream.filter(x -> "a".equals(x.toString()));

        stream.forEach(System.out::println);

		/*Stream<String> stream = Arrays.stream(data)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> "a".equals(x.toString()));*/

    }
}
