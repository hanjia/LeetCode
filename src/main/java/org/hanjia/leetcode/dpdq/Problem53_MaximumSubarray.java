package org.hanjia.leetcode.dpdq;

/**
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * @author hajia
 *
 */
public class Problem53_MaximumSubarray {
    public int maxSubArray(int[] array) {
		int[] sum = new int[array.length];
    	
		int max = array[0];
		sum[0] = array[0];
 
		for (int i = 1; i < array.length; i++) {
			/**
			 * DP condition: We should ignore the sum of the previous n-1 elements if nth element is greater than the sum.
			 */
			sum[i] = Math.max(array[i], array[i] + sum[i - 1]);
			max = Math.max(max, sum[i]);
		}
		return max;
	}
}
