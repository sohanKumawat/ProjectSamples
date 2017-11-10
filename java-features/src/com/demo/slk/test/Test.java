package com.demo.slk.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public void add(){
		String str="Ok, let''s get started on some gift ideas.";
		
		str=str.replaceAll("''", "'");
		System.out.println("str"+str);
	}
	public static void main(String[] args) {
		
		LocalDateTime currentTimeInLosAngeles = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		// current time in UTC time zone
		LocalDateTime nowInUtc = LocalDateTime.now();
		System.out.println(currentTimeInLosAngeles.toString()+"  "+nowInUtc.toString());
		
List<Employe> emLst=new ArrayList();
emLst.add(new Employe("sohan"));
emLst.add(new Employe("sohan1"));
emLst.add(new Employe("sohan2"));
emLst.add(new Employe("sohan3"));
Employe em=emLst.get(0);
em.setName("mohan");
emLst.get(1).setName("sdfcsfgx");
		System.out.println(emLst);

		new Test().add();
	}
	
	
	

}
