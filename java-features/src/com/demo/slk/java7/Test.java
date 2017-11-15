package com.demo.slk.java7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test {
	
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
	public static void main(String[] str){
		String sql = "SELECT `date`,`isExpired`"
				+" FROM msgai_analytics.reportCache"
				+" WHERE tenantId = "+26
				+" AND childTenantId = "+(-1)
				+" AND kpiId = "+12+";";
		System.out.println("***sql *** "+sql);
		//Test.add();
	}

}
