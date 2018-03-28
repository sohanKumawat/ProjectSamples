package com.demo.slk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
	private A a;
	@Autowired  // circular dependecny arise
    public B(A a) {
        this.a = a;
    }
}
