package com.demo.slk.reflection;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class SetterGetterUtility {

	public static void invokeSetter(Object obj, String variableName, Object variableValue) {
		try {
			PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(variableName, obj.getClass());
			objPropertyDescriptor.getWriteMethod().invoke(obj, variableValue);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IntrospectionException e) {
			e.printStackTrace();
		}
	}

	public static Object invokeGetter(Object obj, String variableName) {
		try {
			PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(variableName, obj.getClass());
			Object variableValue = objPropertyDescriptor.getReadMethod().invoke(obj);
			return variableValue;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IntrospectionException e) {
			e.printStackTrace();
			return null;
		}
	}
}
