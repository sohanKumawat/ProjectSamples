package com.demo.slk.serilizationprocess;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserilizationImpl {

	public static void derilizationProcess() {
		try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("/Users/msg/Desktop/objser.txt"))) {
			A a=(A)ois.readObject();
			System.out.println(a);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void main(String[] str) {
		derilizationProcess();
	}
}
