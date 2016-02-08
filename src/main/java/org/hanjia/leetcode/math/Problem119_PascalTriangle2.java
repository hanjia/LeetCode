package org.hanjia.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author hanjia
 *
 */
public class Problem119_PascalTriangle2 {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		if(rowIndex < 0)
			return null;
		result.add(1);	
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = result.size() - 2; j >= 0; j--) {
				result.set(j + 1, result.get(j) + result.get(j + 1)); // Pascal Triangle's characteristic
				System.out.println(result);
			}
			result.add(1);
			System.out.println("Done with row " + i + "with result: " + result);
		}       
        return result;
	}
	
	public static void main(String[] args){
		Problem119_PascalTriangle2 problem119 = new Problem119_PascalTriangle2();
		System.out.println(problem119.getRow(5));
	}
	
	/**
	 * 
	 * System Output: 
	 * 
	 * Done with row 1with result: [1, 1]
	 * [1, 2]
	 * Done with row 2with result: [1, 2, 1]
	 * [1, 2, 3]
	 * [1, 3, 3]
	 * Done with row 3with result: [1, 3, 3, 1]
	 * [1, 3, 3, 4]
	 * [1, 3, 6, 4]
	 * [1, 4, 6, 4]
	 * Done with row 4with result: [1, 4, 6, 4, 1]
	 * [1, 4, 6, 4, 5]
	 * [1, 4, 6, 10, 5]
	 * [1, 4, 10, 10, 5]
	 * [1, 5, 10, 10, 5]
	 * Done with row 5with result: [1, 5, 10, 10, 5, 1]
	 * [1, 5, 10, 10, 5, 1]
	 * 
	 */
		
}
