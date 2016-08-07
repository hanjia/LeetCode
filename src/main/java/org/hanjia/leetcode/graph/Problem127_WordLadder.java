package org.hanjia.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *  - Only one letter can be changed at a time
 *  - Each intermediate word must exist in the word list
 * 
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * @author hanjia
 *
 */
public class Problem127_WordLadder {
	
	// Breadth First Search in a graph
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	if (wordList == null || wordList.size() < 1)
    		return 0;
    	if (beginWord.equals(endWord))
    		return 1;
    	
    	wordList.add(beginWord);
    	wordList.add(endWord);
    	
    	Queue<String> queue = new LinkedList<String>();
    	Set<String> visited = new HashSet<String>();
    	queue.offer(beginWord);
    	visited.add(beginWord);
    	
    	int length = 1;
        while(!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> nextWords = getNextWords(word, wordList);

                for (String nextWord: nextWords) {
                    if (visited.contains(nextWord)) { // Visited so skip
                        continue;
                    }
                    if (endWord.equals(nextWord)) {
                        return length;
                    }                    
                    queue.offer(nextWord);                   
                    visited.add(nextWord);
                }
            }
        }
        return 0;
    }
    
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    public static void main(String[] args) {
    	Problem127_WordLadder wordLadder = new Problem127_WordLadder();
    	Set<String> wordList = new HashSet<String>();
    	wordList.add("hot");
    	wordList.add("dot");
    	wordList.add("dog");
    	wordList.add("lot");
    	wordList.add("log");
    	String beginWord = "hit";
    	String endWord = "cog";
    	int length = wordLadder.ladderLength(beginWord, endWord, wordList);
    	System.out.println(length);
    }
}
