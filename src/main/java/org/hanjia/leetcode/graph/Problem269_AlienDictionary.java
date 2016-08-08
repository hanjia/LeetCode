package org.hanjia.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. 
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 * 
 * For example,
 * Given the following words in dictionary,
	[
	  "wrt",
	  "wrf",
	  "er",
	  "ett",
	  "rftt"
	]
 * The correct order is: "wertf".
 * 
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 * 
 * @author hanjia
 *
 */
public class Problem269_AlienDictionary {
	public String alienOrder(String[] words) {
        Vertex[] vertices = new Vertex[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < 26; i++) {
        	vertices[i] = new Vertex();
        }
        
        //Build the Graph
        for (int i = 0; i < words.length; i++) {
            int start = 0;
            int end = 0;
            for (int j = 0; j < words[i].length(); j++) {
            	visited[charToInt(words[i].charAt(j))] = true;
            }
            
            if (i != words.length - 1) {
            	int minLength = Math.min(words[i].length(), words[i + 1].length());
                for (int j = 0; j < minLength; j++) {
                    if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                        start = charToInt(words[i].charAt(j));
                        end = charToInt(words[i + 1].charAt(j));
                        break;
                    }
                }
            }
            
            if (start != end) {
            	vertices[start].neighbors.add(end);
            	vertices[end].inDegree++;
            }
        }
        
        //Topological Sort via BFS
        Queue<Integer> queue = new LinkedList<Integer>();
        String answer = "";
        
        for (int i = 0; i < 26; i++) {
            if (vertices[i].inDegree == 0 && visited[i]) { // To identify the first vertice
                queue.offer(i);
                answer = answer + intToChar(i);
            } 
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : vertices[current].neighbors) {
                if (--vertices[i].inDegree == 0) { // To make sure each node will be visited once
                    queue.offer(i);
                    answer = answer + intToChar(i);
                }
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (vertices[i].inDegree != 0) {
                return "";
            }
        }
        return answer;
    }
	
    public char intToChar(int i) {
        return (char)('a' + i);
    }
    
    public int charToInt(char ch) {
        return ch - 'a';
    }
    
    public static void main(String[] args) {
    	String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
    	String[] words2 = {"wrt", "wrf", "er", "ett", "rftt"};
    	Problem269_AlienDictionary dict = new Problem269_AlienDictionary();
    	System.out.println(dict.alienOrder(words1));
    	System.out.println(dict.alienOrder(words2));
    }
    
}

class Vertex {
    public int inDegree;
    public List<Integer> neighbors;
    
    public Vertex() {
    	inDegree = 0;
        neighbors = new ArrayList<Integer>();
    }
}
