package com.demo.slk.serilizationprocess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SerilizationImpl {

	public static void serilizationProcess() {
		List<Integer> ls=Arrays.asList(12,12,32);
		try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("/Users/msg/Desktop/objser.txt"))) {
			A a=new A();
			a.setName("sohan");
			a.setSal("123");
			C c=new C();
			c.setAge(123);
			a.setC(c);
			oos.writeObject(a);
			oos.writeObject(ls);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void derilizationProcess() {
		try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("/Users/msg/Desktop/objser.txt"))) {
			A a=(A)ois.readObject();
			@SuppressWarnings("unchecked")
			List<Integer> ls=(List<Integer>)ois.readObject();
			System.out.println(a.getName()+" -- sal "+a.getSal()+" c "+a.getC().getAge()+"--"+ls.size());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	public static void main(String[] str) {
		serilizationProcess();
		derilizationProcess();
		ConcurrentLinkedQueue<Integer> clq=new ConcurrentLinkedQueue<>();
		//ConcurrentLinkedDeque<E>
		
	}
}
