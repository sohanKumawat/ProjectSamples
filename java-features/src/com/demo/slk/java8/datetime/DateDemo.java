package com.demo.slk.java8.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class DateDemo {

	public static void main(String[] args) {
		Period period = Period.ofDays(6);
		System.out.println("*** period ** "+period);
		
		period = Period.ofMonths(6);
		System.out.println("*** period ** "+period);
		period = Period.between(LocalDate.now(), LocalDate.now().plusDays(60));
		
		System.out.println("*** period ** "+period.getMonths()+"-"+period.getDays());
		
		Duration duration = Duration.ofMillis(5000);
		duration = Duration.ofSeconds(60);
		duration = Duration.ofMinutes(10);
		System.out.println("*** duration ** "+duration.toMillis());
	}

}
