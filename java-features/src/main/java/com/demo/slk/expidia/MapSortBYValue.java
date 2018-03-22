package com.demo.slk.expidia;

import java.util.Arrays;
import java.util.Comparator;

 class test{
	
}
public class MapSortBYValue {

	public static void main(String str[]) {
		 customSort();
		// missingWords("I am using hackerrank to improve programming", "am
		// hackerrank to improve");
		//kSub();
	}

	static void customSort() {
		Integer[] arr = { 4, 4, 1, 1, 1, 5, 5, 5, 5 };
		Arrays.sort(arr, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return (o1).compareTo(o2);
			}
		});
		for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
		}
	}
//missing word problem
	static String[] missingWords(String s, String t) {
		String[] a = s.split(" ");
		String[] b = t.split(" ");
		String[] missing = new String[a.length - b.length];
		int cnt = 0;
		for (int i = 0, j = 0; i < a.length; i++) {
			String a1 = a[i];
			String b1 = b[j];
			if (!a1.equals(b1)) {
				missing[cnt] = a[i];
				cnt++;
			} else if (!(j == b.length - 1)) {
				j++;
			}
		}
		for (int i = 0; i < missing.length; i++) {
			System.out.println(missing[i]);
		}
		return missing;
	}

	static long kSub() {
		int[] nums = { 1, 2, 3, 4, 1 };
		int k = 3;
		int[] sum = new int[nums.length];
		long count = 0;
		sum[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}

		int[] kVal = new int[k];

		for (int i = 0; i < sum.length; i++) {
			int mod = sum[i] % k;

			if (mod == 0)
				count++;

			count += kVal[mod];
			kVal[mod] += 1;

		}
		return count;
	}

}