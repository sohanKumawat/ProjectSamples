package com.demo.slk.application.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
static B b;
@SuppressWarnings("static-access")
@Autowired
public A(B b){
	this.b=b;
}
public void add(){
	b.add();
	B.staticAdd();
}

public static void sadd(){
	System.out.println("hello sAdd in A");
}

}
