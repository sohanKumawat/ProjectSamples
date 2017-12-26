package com.demo.slk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class A {
	private B b;
	 
    @Autowired //circular dependecy arise
    public A(@Lazy B b) {
        this.b = b;
    }
}
