package com.demo.slk.java8;

public class TestingLambda {
	public static void main(String[] args) {
        int value1 = method(TestingLambda::customMethod1);
        int value2 = method(TestingLambda::customMethod2);

        System.out.println("Value from customMethod1: " + value1);
        System.out.println("Value from customMethod2: " + value2);
    } 

    public static int customMethod1(int arg){
        return arg + 1;
    }

    public static int customMethod2(int arg){
        return arg + 2;
    }

    public static int method(MyCustomInterface ob){
        return ob.apply(1);
    }

    @FunctionalInterface
    interface MyCustomInterface{
        int apply(int arg);
    }
}
