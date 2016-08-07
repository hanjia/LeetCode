package org.hanjia.leetcode.dp;

/**
 * 
 * After robbing those houses on that street, 
 * the thief has found himself a new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * @author hanjia
 *
 */
public class Problem213_HouseRobber2 {
    public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int max1 = robHelper(nums, 0, nums.length - 2);
		int max2 = robHelper(nums, 1, nums.length - 1);

		return Math.max(max1, max2);
    }
    
	public int robHelper(int[] nums, int i, int j) {
		if (i == j) {
			return nums[i];
		}

		int[] amount = new int[nums.length];
		amount[i] = nums[i];
		amount[i + 1] = Math.max(nums[i + 1], amount[i]);

		for (int k = i + 2; k <= j; k++) {
			amount[k] = Math.max(amount[k - 1], amount[k - 2] + nums[k]);
		}

		return amount[j];
	}
	
	public static void main(String[] args) {
		int[] nums = {4,2,7,3,5,1,8,6,9};
		Problem213_HouseRobber2 robber = new Problem213_HouseRobber2();
		System.out.println(robber.rob(nums));
	}
}
