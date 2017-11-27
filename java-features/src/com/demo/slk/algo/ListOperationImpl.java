package com.demo.slk.algo;

public class ListOperationImpl<T> implements ListOperation<T>{
	private Node<T> head;
    private Node<T> tail;
    private int size=0;
	@Override
	public void addAtBegin(T e) {
		 Node<T> nd = new Node<T>();
	        nd.setData(e);
	        if(head == null){
	            head = nd;
	            tail = nd;
	        } else {
	        	nd.setNext(head);
	        	head = nd;
	        }
	        size++;
	}
	public void add(T e) {
		  Node<T> nd = new Node<T>();
	        nd.setData(e);
	        if(head == null){
	            head = nd;
	            tail = nd;
	        } else {
	            tail.setNext(nd);
	            tail = nd;
	        }
	        size++;
	}
	@Override
	public void addAtEnd(T node) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteNode(T node) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAtIndex(int index) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
	public void print(){
		System.out.println("List Data --> "+head.toString());
	}
	

}
