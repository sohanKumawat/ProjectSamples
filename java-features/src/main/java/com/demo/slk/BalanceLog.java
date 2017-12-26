package com.demo.slk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalanceLog {
	public double balancePoint(Log log) {
		Map<Integer ,Integer> m=new HashMap<>();
		int i=0;
		m.put(i, 1);
		 return 0.0;
	}

	// DO NOT MODIFY CODE BELOW THIS LINE
	interface Log {
            double weightUpto(double x); // returns the weightUpto of the part of the log from the left end to a point at distance x from it.
            double length(); // returns the total length of the log
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");
			Log c = null;
			switch (tokens[0]) {
			case "LINE":
				c = new Line(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
						Double.parseDouble(tokens[3]));
				break;
			case "EXP":
				//c = Math.exp(Double.parseDouble(tokens[1]));
				break;
			case "POWER":
				//c = Math.pow(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
				break;
			case "SINE":
				//c = Math.sin(Double.parseDouble(tokens[1]));
				break;
			}

			if (c == null) {
				break;
			}
			BalanceLog t = new BalanceLog();
			double h = t.balancePoint(c);
			System.out.println(Math.round(h * 1000d));
		}

		scanner.close();
	}

	static class Line implements Log {
		private double m;
		private double c;
		private double l;

		public Line(double l, double m, double c) {
			this.m = m;
			this.c = c;
			this.l = l;
		}

		@Override
		public double weightUpto(double x) {
			
			return 0;
		}

		@Override
		public double length() {
			return 0;
		}
	}
}
