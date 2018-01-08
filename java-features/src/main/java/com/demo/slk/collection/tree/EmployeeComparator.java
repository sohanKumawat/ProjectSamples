package com.demo.slk.collection.tree;

import java.util.Comparator;
import java.util.Objects;
//summan oose
public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		Objects.requireNonNull(o1);
		Objects.requireNonNull(o2);
		return o1.getId()>o2.getId()?1:o1.getId()==o2.getId()?0:-1;
	}

}
