package com.demo.slk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.slk.spring.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes = { AppConfig.class })
	public class DependecnyTest {
	 
	    @Test
	    public void givenCircularDependency_whenConstructorInjection_thenItFails() {
	        // Empty test; we just want the context to load
	    }
}
