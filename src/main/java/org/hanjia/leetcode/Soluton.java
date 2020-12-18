package org.hanjia.leetcode;

import java.util.*;

/*
 * Given a list of matching/equivalent song pairs and a list of unique songs, create disjoint sets of equivalent songs.
 * 
 * For example,
 * Input: 
 * (1) matching pairs: [[1, 2], [2, 3], [5, 6], [4, 6], [2, 7], [3, 8], [9, 10]]
 * (2) unique songs: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * 
 * Output: [[1, 2, 3, 7, 8], [4, 5, 6], [9, 10]]
 * 
 * Note: 
 * (1) transitivity should be considered;
 * (2) matching pairs are only a partial adjacency list
 * 
 */

class Solution {
	
//  public List<Set<Integer>> generateSongSets(List<Pair> matchingPairs, List<Integer> songs) {
//	  boolean[] visited = new boolean[songs.size()];
//	  
//	  Map<Integer, Set<Integer>> grouped = new HashMap<Integer, Set<Integer>>();
//	  for (Pair pair: matchingPairs) {
//		  if (grouped.containsKey(pair.u)) {
//			  Set<Integer> current = grouped.get(pair.u);
//			  current.add(pair.v);
//			  grouped.put(pair.u, current);
//		  } else {
//			  Set<Integer> current = new HashSet<Integer>();
//			  current.add(pair.v);
//			  grouped.put(pair.u, current);
//		  }
//		  
//		  if (grouped.containsKey(pair.v)) {
//			  Set<Integer> current = grouped.get(pair.v);
//			  current.add(pair.u);
//			  grouped.put(pair.v, current);
//		  } else {
//			  Set<Integer> current = new HashSet<Integer>();
//			  current.add(pair.u);
//			  grouped.put(pair.v, current);
//		  }
//	  }
//
//	  List<Set<Integer>> results = new ArrayList<Set<Integer>>();
//	  
//	  for (int i = 0; i < songs.size(); i++) {
//		  if (!visited[i]) {
//			  System.out.println("Traversing from " + i);
//			  Set<Integer> resultSet = new HashSet<Integer>();
//			  dfs(i, visited, songs, grouped, resultSet);
//			  results.add(resultSet);
//		  }
//	  }
//	  
//	  return results;
//  }
//
//  public void dfs(int index, boolean[] visited, List<Integer> vertexes, Map<Integer, Set<Integer>> groupedEdges, Set<Integer> resultSet) {
//	  visited[index] = true;
//
//	  int currentNode = vertexes.get(index);
//	  resultSet.add(currentNode);
//	  //updateResults(currentNode, results);
//	  Set<Integer> childNodes = groupedEdges.get(currentNode);
//
//	  if (childNodes == null) {
//		  return;
//	  }
//
//		for (int node : childNodes) {
//			System.out.println("Checking aginst " + node);
//			int childIndex = vertexes.indexOf(node);
//			if (!visited[childIndex]) {
//				dfs(childIndex, visited, vertexes, groupedEdges, resultSet);
//			}
//		}
//
//  }
  
  public static void main(String[] args) {
	  List<Pair> matchingPairs = new ArrayList<>();
	  matchingPairs.add(new Pair(1, 2));
	  matchingPairs.add(new Pair(2, 3));
	  matchingPairs.add(new Pair(5, 6));
	  matchingPairs.add(new Pair(4, 6));
	  matchingPairs.add(new Pair(2, 7));
	  matchingPairs.add(new Pair(3, 8));
	  matchingPairs.add(new Pair(9, 10));
	  
	  List<Integer> songs = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

	  Solution s = new Solution();
	  List<Set<Integer>> results = s.generateSongSets(matchingPairs, songs);
	  System.out.println(results);
  }
  
  
  boolean[] visited = new boolean[10];
  Stack<Integer> stack = new Stack<Integer>();
  
  public List<Set<Integer>> generateSongSets(List<Pair> matchingPairs, List<Integer> songs) {
    List<Set<Integer>> out = new LinkedList<Set<Integer>>();
    for(Integer i: songs) {
      System.out.println("Traversing from " + i);
      if(!visited[i-1]) {
        Set<Integer> currentSet = new HashSet<Integer>();
        stack.push(i);
        visit(i, currentSet,matchingPairs);
        out.add(currentSet);
        
      }
    }
    return out;
  }
  
  
  public void visit(Integer v, Set<Integer> currentSet, List<Pair> matchingPairs) {
    while(!stack.isEmpty()) {
      Integer vertex = stack.pop();
      System.out.println("Visited " + vertex);
      visited[vertex-1] = true;
      currentSet.add(vertex);
      
      for(Pair p: matchingPairs) {
        if(p.u == vertex && !visited[p.v-1]) {
          stack.push(p.v);
        }
        if(p.v == vertex && !visited[p.u-1]) {
          stack.push(p.u);
        }
      }
    }      
  }
}



class Pair {
	int u;
	int v;
	
	Pair(int u, int v) {
		this.u = u;
		this.v = v;
	}
}
