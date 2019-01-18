package com.mb.test.a;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.LineNumberInputStream;

public class JavaDecoratorExample {

	public static void main(String[] args) {

		try {
			FileInputStream fi = new FileInputStream("sohan.txt");

			BufferedInputStream bf = new BufferedInputStream(fi);
			LineNumberInputStream li = new LineNumberInputStream(bf);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
