package org.hanjia.leetcode.tree;

/**
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author hanjia
 *
 */
public class Problem208_ImplementTrie {

    private TrieNode root = new TrieNode();

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return (node != null && node.hasWord);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return (node != null);
    }
    
    public static void main(String[] args) {
    	Problem208_ImplementTrie trie = new Problem208_ImplementTrie();
    	trie.insert("hello");
    	trie.insert("hazel");
    	trie.insert("hub");
    	trie.insert("hostile");
    	trie.insert("high");
    	System.out.println(trie.search("hub"));
    	System.out.println(trie.search("hot"));
    	System.out.println(trie.startsWith("ho"));
    	System.out.println(trie.startsWith("wo"));
    }
    
    /**
     * 
     * @author hajia
     *
     */
    class TrieNode {
        private TrieNode[] children;
        public boolean hasWord;
        
        public TrieNode() {
            children = new TrieNode[26]; // Each node has 26 children
            hasWord = false;
        }
        
        public void insert(String word, int index) {
            if (index == word.length()) {
                this.hasWord = true;
                return;
            }
            
            int position = word.charAt(index) - 'a';
            if (children[position] == null) {
                children[position] = new TrieNode();
            }
            children[position].insert(word, index + 1); // Recursion
        }
        
        public TrieNode find(String word, int index) {
            if (index == word.length()) {
                return this;
            }
            
            int position = word.charAt(index) - 'a';
            if (children[position] == null) {
                return null;
            }
            return children[position].find(word, index + 1); // Recursion
        }
    }
}

