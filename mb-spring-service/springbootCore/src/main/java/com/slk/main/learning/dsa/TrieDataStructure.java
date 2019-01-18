package com.slk.main.learning.dsa;

import java.util.HashMap;
import java.util.Map;

public class TrieDataStructure {

	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfword;

		TrieNode() {
			children = new HashMap<>();
			endOfword = false;
		}
	}

	private TrieNode root;

	public TrieDataStructure() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode node = current.children.get(word.charAt(i));
			if (node == null) {
				node = new TrieNode();
				current.children.put(word.charAt(i), node);
			}
			current = node;
		}
		current.endOfword = true;
	}

	public void searchPrefix(String prefix) {
		TrieNode current = root;
		boolean wordFlag = true;
		for (int i = 0; i < prefix.length(); i++) {
			Character ch = prefix.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				System.out.println("word not exist");
				wordFlag = false;
				break;
			}
			current = node;
		}
		if (wordFlag)
			System.out.println("word exist with prifix " + prefix);
		else
			System.out.println("word not exist with prifix " + prefix);
	}

	public void searchFull(String word) {
		TrieNode current = root;
		boolean wordFlag = true;
		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				// System.out.println("word not exist");
				wordFlag = false;
				break;
			}
			if (i == word.length() - 1 && !node.endOfword) {
				wordFlag = false;
			}
			current = node;
		}
		if (wordFlag)
			System.out.println("word exist " + word);
		else
			System.out.println("word not exist " + word);
	}

	public static void main(String[] str) {
		TrieDataStructure trie = new TrieDataStructure();
		trie.insert("sohan");
		trie.insert("soham");
		trie.insert("mohan");
		trie.insert("sonna");
		System.out.println(trie.root.toString());
		trie.searchFull("sohan");
		trie.searchFull("som");
		trie.searchFull("mohan");
		trie.searchPrefix("so");

	}
}
