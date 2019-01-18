package com.slk.main.learning;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<Long> re = Arrays.asList(new Long(1), new Long(1));
		Optional<String> val = Optional.empty();
		if (!val.isPresent())
			System.out.println("is present");
	}

}
