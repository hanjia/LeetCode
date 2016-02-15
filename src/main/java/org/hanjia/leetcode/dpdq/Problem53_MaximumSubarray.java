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
    public int maxSubArray(int[] A) {
		int[] sum = new int[A.length];
    	
		int max = A[0];
		sum[0] = A[0];
 
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]); // DP condition: We should ignore the sum of the previous n-1 elements if nth element is greater than the sum.
			max = Math.max(max, sum[i]);
		}
 
		return max;
	}
}
