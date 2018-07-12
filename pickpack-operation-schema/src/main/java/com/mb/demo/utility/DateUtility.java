package com.mb.demo.utility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtility {

	public static String getCurrentLocalDate(String pattern) {
		return dateFormat(pattern).format(LocalDate.now());
	}

	public static LocalDate getCurrentLocalDate() {
		return LocalDate.now();
	}

	public static String getCurrentLocalDate(String pattern, String zoneId) {
		return dateFormat(pattern).format(LocalDate.now(ZoneId.of(zoneId)));
	}

	public static DateTimeFormatter dateFormat(String pattern) {
		if (null == pattern)
			return DateTimeFormatter.ISO_LOCAL_DATE;
		return DateTimeFormatter.ofPattern(pattern);
	}

	public static void main(String srt[]) {
		String date = getCurrentLocalDate(null);
		System.out.println("*** date ** "+date);
	}
}
