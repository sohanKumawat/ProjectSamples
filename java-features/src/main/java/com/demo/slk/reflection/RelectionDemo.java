package com.demo.slk.reflection;

public class RelectionDemo {

	public static void main(String str[]) {
		User user = new User();
		SetterGetterUtility.invokeSetter(user, "name", "Sohan Kumawat");
		String value = SetterGetterUtility.invokeGetter(user, "name").toString();
		System.out.println("*** value ** " + value);
	}
}
