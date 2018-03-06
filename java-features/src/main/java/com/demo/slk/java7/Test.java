package com.demo.slk.java7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	@SuppressWarnings("unused")
	public static void add() throws RuntimeException{
		try{
			int a=5/8;
		}catch(ArithmeticException | NullPointerException ex){
			throw new RuntimeException();
		}
	}
	@SuppressWarnings("unused")
	private static void printFileJava7() throws IOException {
	    try(FileInputStream input = new FileInputStream("file.txt")) {
	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    }
	}
	@SuppressWarnings("unused")
	private static void secondPrintFileJava7() throws IOException {

	    try(  FileInputStream     input         = new FileInputStream("file.txt");
	          BufferedInputStream bufferedInput = new BufferedInputStream(input)
	    ) {
	        int data = bufferedInput.read();
	        while(data != -1){
	            System.out.print((char) data);
	    data = bufferedInput.read();
	        }
	    }
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] str){
		String sql = "SELECT `date`,`isExpired`"
				+" FROM msgai_analytics.reportCache"
				+" WHERE tenantId = "+26
				+" AND childTenantId = "+(-1)
				+" AND kpiId = "+12+";";
		System.out.println("***sql *** "+sql);
		Test.add();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String endDate = format1.format(new Date("2017-11-08"));
		String startDate = format1.format(new Date("2017-11-11"));
		System.out.println(endDate+" -- "+startDate);
	}

}
