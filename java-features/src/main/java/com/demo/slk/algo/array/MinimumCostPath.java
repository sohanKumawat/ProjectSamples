package com.demo.slk.algo.array;

public class MinimumCostPath {

	public static void pathAndCost(int[][] a, int m, int n) {
		int[][] cost = new int[m][n];
		cost[0][0]=a[0][0];
		for (int i = 1; i < cost.length; i++) {
			cost[i][0] = cost[i - 1][0] + a[i][0];
		}
		for (int i = 1; i < cost[0].length; i++) {
			cost[0][i] = cost[0][i - 1] + a[0][i];
		}
		// a,b,c =>a<b?(a<c?a:c):b<c?b:c
		for (int i = 1; i < cost.length; i++) {
			for (int j = 1; j < cost[i].length; j++) {
				int v1=a[i][j]+cost[i-1][j];
				int v2=a[i][j]+cost[i][j-1];
				int v3=a[i][j]+cost[i-1][j-1];
				int v=v1<v2?(v1<v3?v1:v3):v2<v3?v2:v3;
				System.out.println("value __ "+v);
				cost[i][j]=v;
			}
		}
		for (int i = 0; i < cost.length; i++) {
			String val="";
			for (int j = 0; j < cost[i].length; j++) {
				val=val+cost[i][j]+" ";
			}
			System.out.println(val);
		}
	}

	public static void main(String[] args) {
		int[][] path = { { 1, 2, 3 }, 
				         { 4, 8, 2 }, 
				         { 1, 5, 3 } };
		/*int a=0,b=2,c=1;
		int val=a<b?(a<c?a:c):b<c?b:c;
		System.out.println("val ** "+val);*/
		MinimumCostPath.pathAndCost(path, path.length, path[0].length);
	}

}
