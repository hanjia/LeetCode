package org.hanjia.leetcode.dp;

/**
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem303_RangeSumQueryImmutable {

}

//Brute force – O(n) time per query
/**
class NumArray{
	private int[] data;

	public NumArray(int[] nums) {
	    data = nums;
	}

	public int sumRange(int i, int j) {
	    int sum = 0;
	    for (int k = i; k <= j; k++) {
	        sum += data[k];
	    }
	    return sum;
	}
}
**/

// Caching – O(1) time per query, O(n) space
// DP formula: sumRange(i, j) = sum[j + 1] - sum[i]
class NumArray {
	private int[] sums;

	public NumArray(int[] nums) {
		sums = new int[nums.length + 1];
	    for (int i = 0; i < nums.length; i++) {
	    	sums[i + 1] = sums[i] + nums[i];
	    }
	}

	public int sumRange(int i, int j) {
	    return sums[j + 1] - sums[i];
	}
}
