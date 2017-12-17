package com.demo.slk.test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex {
	public void test(String name){
		name="sohan";
	}
    public static void main(String[] args) {
        String s = "aaabbcccbb";
      //  find(s);
        String s1 = "RonRonRonJoeJoe .... ,,,,";
      //  find(s1);
        System.err.println("---");
        String s2 = "RonRonBobBob";
        find(s2);
    }

    private static void find(String s) {
        Matcher m = Pattern.compile("(.+)\\1+").matcher(s);
        Regex r=new Regex();
       String na="hello";
       Set<String> set=new HashSet<>();
       Map<String ,Integer> tmap=new TreeMap<>();
       r.test(na);
        final AtomicInteger threadNumber = new AtomicInteger(1);
       System.out.println(na+threadNumber.getAndIncrement()+" "+threadNumber.get());
        while (m.find()) {
            System.err.println(m.group());
        }
    }
}