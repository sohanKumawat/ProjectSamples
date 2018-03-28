package com.demo.slk.application.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;
	private String userName;
	private String firstName;
	private String lastName;
	private int age;
}
