package JIo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class B extends A{
	int x=1001;
	Integer ix=new Integer(121);
  List<Integer> lst=Arrays.asList(12,21,32,32,43);
  C c=new C("sohan B");
	public void add(){
		try{
			System.out.println("add1 of B");
			testExceptions();
	} catch (FileNotFoundException | NullPointerException  e) {
		e.printStackTrace();
	}
	}
public static void testExceptions() throws  FileNotFoundException{
		
	}
	public int getX() {
		return x;
	}
/*	@Override
	public  void addfinal(){
		System.out.println("add of A");
	}*/
	public void setX(int x) {
		this.x = x;
	}
	
}
