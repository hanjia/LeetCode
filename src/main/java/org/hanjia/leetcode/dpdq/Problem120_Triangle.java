package org.hanjia.leetcode.dpdq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
	    if(triangle.size() == 0)
	        return 0;
	    
	    int numOfRows = triangle.size();
	    int[] result = new int[numOfRows];
	    
	    // Set initial values
		for (int i = 0; i < numOfRows; i++) {
			result[i] = triangle.get(numOfRows - 1).get(i);
		}		
		System.out.println(Arrays.toString(result));
		
		
		for (int i = numOfRows - 2; i >= 0; i--) { // Start from the (bottom - 1) level
			for (int j = 0; j <= i; j++) {
				result[j] = Math.min(result[j], result[j + 1]) + triangle.get(i).get(j);
				System.out.println(Arrays.toString(result));
			}
		}
		System.out.println(Arrays.toString(result));
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
