package com.slk.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static int compareInt(int i1, int i2) {
		return i1 > i2 ? 1 : i1 == i2 ? 0 : -1;
	}

	public static int compareLong(Long l1, Long l2) {
		return l1 > l2 ? 1 : l1 == l2 ? 0 : -1;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		boolean isValide = false;
		if (compareLong(100L, 100L) == 0 && compareLong(3L, 3L) == 0 && compareInt(1, 1) >= 0) {
			isValide = true;
		}
		System.out.println(isValide);
	}

}
