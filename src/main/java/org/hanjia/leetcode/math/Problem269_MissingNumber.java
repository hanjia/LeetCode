package org.hanjia.leetcode.math;

/**
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * @author hanjia
 *
 */
public class Problem269_MissingNumber {
	public int missingNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; ++i) {
			res ^= (i + 1) ^ nums[i];
		}
		return res;
	}
	// TODO: add tests
}
