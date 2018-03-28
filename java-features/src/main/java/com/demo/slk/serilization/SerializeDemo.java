package com.demo.slk.serilization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDemo implements Serializable {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.setValue(1);
        // Serialize
        try {
            FileOutputStream fileOut = new FileOutputStream("/home/sohan/Desktop/object.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(singleton);
            out.close();
            fileOut.flush();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // singleton.setValue(2);
        // Deserialize
        Singleton singleton2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("/home/sohan/Desktop/object.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            singleton2 = (Singleton) in.readObject();
            System.out.println(singleton2.getValue());
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("singletons.SingletonEnum class not found");
            c.printStackTrace();
        }
        singleton.setValue(2);
        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }
}
