package org.hanjia.leetcode.dpdq;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * 
 * @author hanjia
 *
 */
public class Problem120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
	    if(triangle.size() == 0)
	        return 0;
	    
	    int numOfRows = triangle.size();
	    int[] result = new int[numOfRows];
	    
	    // Set initial values: values of the last row
		for (int i = 0; i < numOfRows; i++) {
			result[i] = triangle.get(numOfRows - 1).get(i);
		}				
		
		// Bottom-up: start from the (bottom - 1) level
		for (int i = numOfRows - 2; i >= 0; i--) { 
			for (int j = 0; j <= i; j++) {
				// DP Formula: sum(i,j) = min { sum(i+1,j), sum(i+1,j+1) } + value of (i,j)
				result[j] = Math.min(result[j], result[j + 1]) + triangle.get(i).get(j);
			}
		}		
	    return result[0];
	}

	public static void main(String[] args){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> row0 = new ArrayList<Integer>();
		row0.add(2);
		triangle.add(row0);
		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(3);
		row1.add(4);
		triangle.add(row1);
		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(6);
		row2.add(5);
		row2.add(7);
		triangle.add(row2);
		List<Integer> row3 = new ArrayList<Integer>();
		row3.add(4);
		row3.add(1);
		row3.add(8);
		row3.add(3);
		triangle.add(row3);
		Problem120_Triangle problem = new Problem120_Triangle();
		System.out.println(problem.minimumTotal(triangle));
	}
}
