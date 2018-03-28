package JIo;

import java.util.Arrays;
import java.util.List;

public class A {
	int x=100;
	Integer ix=new Integer(12); 
	  List<Integer> lst=Arrays.asList(12,21,32);
	  C c=new C("sohan A");
	public  void add(){
		System.out.println("add of A");
	}
	/*public final void addfinal(){
		System.out.println("add of A");
	}*/
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
}
