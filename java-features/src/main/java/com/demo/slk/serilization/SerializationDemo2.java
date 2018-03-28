package com.demo.slk.serilization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerializationDemo2 implements Serializable {
	private static final long serialVersionUID = 11L;

	public static void main(String[] args) {
        A a =new A("vnc");
        a.setAdd("ghata");
        a.setId("21");
        a.setName("sohan");
        a.setSal("32341");
        a.setC(new C());
        a.getC().setValue("Hello c");;
        // Serialize
        /*try {
            FileOutputStream fileOut = new FileOutputStream("/home/sohan/Desktop/object.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(a);
            out.close();
            fileOut.flush();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        A a1 = null;
        try {
            FileInputStream fileIn = new FileInputStream("/home/sohan/Desktop/object.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            a1 = (A) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("As.AEnum class not found");
            c.printStackTrace();
        }
        if (a == a1) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }
        System.out.println(a.toString() +" -- "+a1.toString() +" -- anme "+a1.getName() +" c "+a1.getC().toString());
    }
}
