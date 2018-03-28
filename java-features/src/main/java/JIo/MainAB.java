package JIo;

public class MainAB {

	private void stringTest12(String str){
		System.out.println("inside the stringTest string");
	}
	private void stringTest(Object str){
		System.out.println("inside the stringTest object");
	}
	private void stringTest(int str){
		System.out.println("inside the primitiveTest int");
	}
	private void stringTest(Integer val){
		System.out.println("inside the primitiveTest wraper");
	}
	public static void main(String[] args) {
		//B.add();
		MainAB ab=new MainAB();
		A b=new B();
		b.add();
		int a=12;
		ab.stringTest(null);
		ab.stringTest(a);
		ab.stringTest(new Integer(12));
		System.out.println(b.getX()+"  ix -- "+b.ix +" lst ** "+b.lst.size()+" C ** "+b.c.getName());
	}

}
