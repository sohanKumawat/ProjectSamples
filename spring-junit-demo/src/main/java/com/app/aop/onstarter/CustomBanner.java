package com.app.aop.onstarter;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

public class CustomBanner implements Banner  {
	@Override
	public void printBanner(Environment arg0, Class<?> arg1, PrintStream arg2) {
		arg2.println("================================");
		arg2.println("----------Welcome to spring boot!----------");
		arg2.println("================================");
	}

}
