package org.hanjia.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 * @author hanjia
 *
 */
public class Problem211_AddAndSearchWord {
	public static void main(String[] args) {
		WordDictionary2 wd2 = new WordDictionary2();
		wd2.addWord("taylorswift");
		wd2.addWord("pink");
		wd2.addWord("edsheeran");
		System.out.println(wd2.search("taylorswift"));
		System.out.println(wd2.search("p.nk"));
		System.out.println(wd2.search("edsheer."));
		System.out.println(wd2.search("edsheer.."));
		System.out.println(wd2.search("jasonmraz"));
	}
		
}

class WordDictionary {
	private TrieNode root;
	
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
	public void addWord(String word) {
		HashMap<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			TrieNode t = null;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}

			children = t.children;

			if (i == word.length() - 1) {
				t.isLeaf = true;
			}
		}
	}
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return dfsSearch(root.children, word, 0);       
    }
    
    public boolean dfsSearch(HashMap<Character, TrieNode> children, String word, int start) {
		if (start == word.length()) { // Base cases
			if (children.size() == 0) {
				return true;
			} else {
				return false;
			}
		}
 
        char c = word.charAt(start);    
 
		if (children.containsKey(c)) {
			if (start == word.length() - 1 && children.get(c).isLeaf) {
				return true;
			}
			return dfsSearch(children.get(c).children, word, start + 1);
		} else if (c == '.') {
			boolean result = false;
			for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
				if (start == word.length() - 1 && child.getValue().isLeaf) {
					return true;
				}

				// if any path is true, set result to be true;
				if (dfsSearch(child.getValue().children, word, start + 1)) {
					result = true;
				}
			}
			return result;
		} else {
			return false;
		}
    }
}

class TrieNode{
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
 
    public TrieNode() {
    	
    }
 
    public TrieNode(char c) {
        this.c = c;
    }
}

class TrieNode2{
    TrieNode2[] array;
    boolean isLeaf;
 
    public TrieNode2(){
    	array = new TrieNode2[26];
    }    
}

class WordDictionary2 {
	TrieNode2 root;

	public WordDictionary2() {
		root = new TrieNode2();
		root.isLeaf = false;
	}

	public void addWord(String word) {
		TrieNode2 current = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.array[index] == null) {
				current.array[index] = new TrieNode2();
			}
			current = current.array[index];
		}
		current.isLeaf = true;
	}

	public boolean search(String word) {
		// return dfsSearch(root, word, 0);
		return searchHelper(word, 0, root);
	}

	public boolean dfsSearch(TrieNode2 current, String word, int start) {
		if (current.isLeaf && start == word.length()) { // Base case
			return true;
		}

		if (start >= word.length()) { // Base case
			return false;
		}

		if (word.charAt(start) == '.') {
			for (int j = 0; j < 26; j++) {
				if (current.array[j] != null) {
					if (dfsSearch(current.array[j], word, start + 1)) {
						return true;
					}
				}
			}
		} else {
			int index = word.charAt(start) - 'a';
			if (current.array[index] != null) {
				return dfsSearch(current.array[index], word, start + 1);
			}
		}

		return false;
	}

	private boolean searchHelper(String artistName, int index, TrieNode2 node) {
		if (node == null) { // Base case
			return false;
		}

		if (artistName.length() == index) { // Base case
			return node.isLeaf;
		}

		if (artistName.charAt(index) == '.') {
			for (int j = 0; j < 26; j++) {
				if (searchHelper(artistName, index + 1, node.array[j])) {
					return true;
				}
			}
		} else {
			if (searchHelper(artistName, index + 1, node.array[artistName.charAt(index) - 'a'])) {
				return true;
			}
		}

		return false;

	}
}