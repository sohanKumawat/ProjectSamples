package JIo;

import java.util.Arrays;
import java.util.List;

public class B extends A{
	int x=1001;
	Integer ix=new Integer(121);
  List<Integer> lst=Arrays.asList(12,21,32,32,43);
  C c=new C("sohan B");
	public void add(){
		System.out.println("add1 of B");
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
}
