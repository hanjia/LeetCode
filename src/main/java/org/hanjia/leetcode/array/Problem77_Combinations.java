package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * 
 * If n = 4 and k = 2, a solution is:
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 * 
 * @author hanjia
 *
 */
public class Problem77_Combinations {
	/**
	 * 
	 * Backtracking
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (n <= 0 || n < k){
    		return result;
    	}     
    	List<Integer> current = new ArrayList<Integer>();
    	combine(n, k, 1, current, result);
    	return result;
    }
 
    private void combine(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
    	if (current.size() == k) {
    		result.add(new ArrayList<Integer>(current));
    		return;
    	}
     
    	for (int i = start; i <= n; i++) {
    		current.add(i);
    		combine(n, k, i + 1, current, result);
    		current.remove(current.size() - 1);
    	}
    }
}
