package com.demo.slk.algo.array;

public class RoadCutting {
	public static void cuttingPrice(int[] r) {
		int[] cPrice = new int[r.length];
		String[] cut = new String[r.length];

		for (int i = 1; i <= r.length; i++) {
			if (r.length % i == 0) {
				cPrice[i - 1] = (r.length / i) * r[i - 1];
				cut[i - 1] = i + "";
			} else {
				int pVal = ((r.length / i) * r[i - 1]) + (r[(r.length % i)-1]);
				System.out.println(((r.length / i) * r[i - 1])+"--"+r[(r.length % i)-1]+" ii --"+i);
				cPrice[i - 1] = pVal;
				cut[i - 1] = i + ","+r.length % i;
			}
		}
		int max = 0;
		int p = 0;
		for (int i = 0; i < cPrice.length; i++) {
			if (max < cPrice[i]) {
				max = cPrice[i];
				p = i;
			}
		}
		System.out.println("Max price is " + max + " and cutting is "+cut[p]);
	}

	public static void main(String[] str) {
		int[] pr = { 3, 5, 8, 9, 10, 17, 17, 20 };
		RoadCutting.cuttingPrice(pr);
	}

}
