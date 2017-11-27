package com.demo.slk.algo;

public class ShortestPath {
public static final int V=9;

public int minimumDistance(int[] dist,boolean sptSet[]){
	int min_index=-1; int min=Integer.MAX_VALUE;
	
	for(int v=0;v<V;v++){
		if(!sptSet[v] && dist[v]<=min){
			 min = dist[v];
             min_index = v;	
		}
	}
	return min_index;
  }


}
