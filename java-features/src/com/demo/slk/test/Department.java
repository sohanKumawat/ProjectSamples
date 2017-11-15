package com.demo.slk.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Department {
	private int id;
	private Employee empolye;
}
