package com.demo.slk.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
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
        while (m.find()) {
            System.err.println(m.group());
        }
    }
}