package com.demo.slk.java8.functionalinterface;

@FunctionalInterface
public interface Foo {
    String method(String str);
    default void defaultMethod() {}
}

