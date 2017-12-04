package com.demo.slk.algo;

public interface ListOperation<T> {

	  void addAtBegin(T node);
	  void addAtEnd(T node);
	  void deleteNode(T node);
	  void deleteAtIndex(int index);
	  void sort();
}
