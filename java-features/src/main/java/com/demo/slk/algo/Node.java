package com.demo.slk.algo;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Node<T> {
	T data;
	Node<T> next;
}
