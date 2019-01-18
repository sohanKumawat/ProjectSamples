package com.slk.main.learning.cyclic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class A implements InitializingBean {
	B b;

	@Autowired
	public A(@Lazy B b) {
		this.b = b;
	}

	@PostConstruct
	public void test() {
		System.out.println("inside A B " + b);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

}
