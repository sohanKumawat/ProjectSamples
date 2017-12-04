package com.demo.slk.java8.lamda.functional;

@FunctionalInterface 
/* only method should be abstarct, but we can define object
   class public method as a abstract, default method can
   not consider as a abstract method.
   any interface without functionalInterface annotation if it fullfil all the
   requirement, It consider as a functionalInterface.
 * 
 */
public interface FunctionalInterTest {
	void display();

	boolean equals(Object obj);
}
