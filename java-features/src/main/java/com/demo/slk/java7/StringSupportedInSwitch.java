package com.demo.slk.java7;

import java.util.HashMap;
import java.util.Map;
//https://howtodoinjava.com/java-7/auto-reload-of-configuration-when-any-change-happen/ 
public class StringSupportedInSwitch {
	 
    public static void main(String[] args)
    {
        System.out.println(getExpendedMessage("one"));
        System.out.println(getExpendedMessage("three"));
        System.out.println(getExpendedMessage("five"));
        Map<String,String> testMap=new HashMap<>();
        System.out.println(testMap.put("sohan", "SOhan"));
        System.out.println(testMap.put("sohan", "SOhawersn"));
        
    }
 
    static String getExpendedMessage( String token)//before 7 it support only int and enum
    {
        switch (token)
        {
            case "one":
                return "Token one identified";
 
            case ("two"):
                return "Token one identified";
 
            case ("three"):
                return "Token one identified";
 
            case ("four"):
                return "Token one identified";
 
            default:
                return "No token was identified";
        }
    }
}
