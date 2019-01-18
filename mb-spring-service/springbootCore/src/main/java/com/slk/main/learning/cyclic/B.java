package com.slk.main.learning.cyclic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

	A a;

	@Autowired
	public B(A a) {
		this.a = a;
	}

	@PostConstruct
	public void test() {
		System.out.println("inside B A " + a);
	}

}
