package com.demo.slk.generic;

import java.util.Set;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class BuilderExample {
	private String name;
	private int age;
	@Singular
	private Set<String> occupations;
}
