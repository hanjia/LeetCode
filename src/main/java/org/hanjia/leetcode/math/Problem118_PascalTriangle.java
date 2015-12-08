package org.hanjia.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, 
 * Return
 * 
 * [
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
 * ]
 * @author hanjia
 *
 */
public class Problem118_PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> pre = result.get(i-1);
                int n = pre.get(j-1) + pre.get(j);
                row.add(n);
            }
            if (i != 0) {
                row.add(1);    
            }
            result.add(row);
        }
        return result;
    }
}