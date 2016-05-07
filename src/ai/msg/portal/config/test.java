package ai.msg.portal.config;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		
		ArrayList<Object> list=new ArrayList<Object>();
		list.add("sohan");
		list.add("kumawat");
		Employee emp=new Employee("sohan");
		Employee emp1=new Employee("sohan");
		list.add(emp);
		
		if(emp==emp1){//either we need to implement hascode function && equals method in employe class
			System.out.println("list contain");
		}
		
		// TODO Auto-generated method stub
String finalResponse="Hi!  I'm Pierre, a stylist from Pantene";
finalResponse=finalResponse.replaceAll("'", "\\\\'");
finalResponse=finalResponse+"";
System.out.println("finalResponse"+finalResponse);

finalResponse=finalResponse.replaceAll("\\\\", "")+"";

System.out.println("finalResponse"+finalResponse);
	}

}
