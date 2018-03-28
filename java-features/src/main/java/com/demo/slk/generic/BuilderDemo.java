package com.demo.slk.generic;

import java.util.HashSet;
import java.util.Set;

public class BuilderDemo {

	
	@SuppressWarnings("unused")
	public static void main(String str[]){
		Set<String> s=new HashSet<>();
		s.add("sohan");
		BuilderExample bexa=	BuilderExample.builder().age(12).name("sohan").occupations(s).build();
	}
	
}
