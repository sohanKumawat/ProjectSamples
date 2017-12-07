package com.demo.slk.algo;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {
	private int v;
	private boolean [] visited;
	@SuppressWarnings("rawtypes")
	private LinkedList [] adg;
	
	BFSGraph(int v){
		this.v=v;
		visited=new boolean[this.v];
		adg=new LinkedList[v];
		for(int i=0;i<v;i++){
			adg[i]=new LinkedList<Integer>();
		}
	}
	@SuppressWarnings("unchecked")
	public void addEdge(int v,int w){
		adg[v].add(w);
	}
	@SuppressWarnings("unchecked")
	public void BFSTraverse(int s){
		visited[s]=true;
		 LinkedList<Integer> queue = new LinkedList<Integer>();
	     queue.add(s);
		
	     while(!queue.isEmpty()){
	    	  s=queue.poll();
	    	  System.out.print(s+" > ");
	    	  Iterator<Integer> it=adg[s].listIterator();
	    	  while(it.hasNext()){
	    		  int n=it.next();
	    		  if(!visited[n]){
	    			  visited[n]=true;
	    			  queue.add(n);
	    		  }
	    	  }
	    	 
	     }
		
	}
	
	public static void main(String str[]){
		
		BFSGraph g = new BFSGraph(5);

	     g.addEdge(0, 1);
	     g.addEdge(0, 2);
	     g.addEdge(1, 2);
	     g.addEdge(2, 4);
	     g.addEdge(2, 3);
	     g.addEdge(3, 3);
	     g.addEdge(3, 4);

	     System.out.println("Following is Breadth First Traversal "+
	                        "(starting from vertex 0)");

	     g.BFSTraverse(0);
		
	}
	
}
