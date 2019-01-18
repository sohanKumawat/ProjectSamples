package JIo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.util.concurrent.AtomicDouble;

public class TestClass{
    public static void main(String argv[]){
    	int x = 10*20-20;
    	System.out.println(x);
    	char c = 67;
		System.out.println("c = "+c);
		
		Set<String> names=new HashSet<>();
		names.add("sohan");
		names.forEach(name->{
			System.out.println(name);
		});
		
		AtomicDouble ad=new AtomicDouble();
		AtomicInteger ai=new AtomicInteger();
		AtomicBoolean ab=new AtomicBoolean();
        Test1 pm1 = new Test1("1");
        pm1.run();
        Test1 pm2 = new Test1("2");
        pm2.run();
        Test1 pm3 = new Test1("break");
        pm3.run();
    }
    public static void main(int argv[]){
    	
    }
    void testARM_Java9() throws IOException{
    	/* BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
    	 try (BufferedReader reader2 = reader1) {
    	   System.out.println(reader2.readLine());
    	 }*/
    	 try (BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"))) {
    	   System.out.println(reader1.readLine());
    	 }
    	}

    public abstract class MyHandler<T> {
    	 
    	public MyHandler(int i) {
			// TODO Auto-generated constructor stub
		}

		// constructor, getter, setter...
     
    	abstract void handle();
    }
    
    MyHandler<? extends Number> intHandler = new MyHandler<Integer>(1) {
    	 
		public void handle() {
			// handling code...
		}
	};

}
