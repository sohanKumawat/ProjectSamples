package com.slk.main.learning;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LocalDateDemo {

	public static void main(String str[]) {
		Long val1 = 1223432244L;
		System.out.println(lCom(val1));
	}

	public static boolean lCom(Long val1) {
		return val1 == 1223432244L;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public void dateTest() {
		List<String> lstr = Arrays.asList("qw", "wq", "eqw");
		Iterator iter = lstr.iterator();
		while (iter.hasNext()) {
			iter.remove();
			@SuppressWarnings("unused")
			String str1 = (String) iter.next();

		}
		long time = 1500894379;
		LocalDate date = Instant.ofEpochMilli(time * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println(date);

		Date dt = new Date(time * 1000);
		System.out.println(dt);
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
		String strDate = formatter.format(dt);
		System.out.println("Date Format with MMMM dd, yyyy hh:mm:ss : " + strDate);

		Date cDate = new Date();
		long tm = cDate.getTime();
		System.out.println(tm);

		System.out.println(new Date(tm));

		Date date1 = new Date();
		Timestamp ts = new Timestamp(new Date().getTime());
		long t = (new Timestamp(new Date().getTime())).getTime() / 1000;
		System.out.println(ts.getTime());

	}
}
