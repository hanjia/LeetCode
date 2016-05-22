package org.hanjia.leetcode.dpdq;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *  
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem198_HouseRobber {
	
	// Dynamic programming – O(n) time
	// f(k) = Largest amount that you can rob from the first k houses. 
	// Ai = Amount of money at the ith house.
	// Let us look at the case n = 1, clearly f(1) = A1.
	// Now, let us look at n = 2, which f(2) = max(A1, A2).
	// For n = 3, you have basically the following two options:
	// 1) Rob the third house, and add its amount to the first house's amount.
	// 2) Do not rob the third house, and stick with the maximum amount of the first two houses.
	
 	// Therefore, we could summarize the formula as following:
	// f(k) = max(f(k – 2) + Ak, f(k – 1))
	// We choose the base case as f(–1) = f(0) = 0, which will greatly simplify our code as you can see.
	// The answer will be calculated as f(n). 
	// We could use an array to store and calculate the result, 
	// but since at each step you only need the previous two maximum values, two variables are suffice.

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		int[] amount = new int[nums.length];
		amount[0] = nums[0];
		amount[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			/**
			 * dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i])
			 */
			amount[i] = Math.max(amount[i - 2] + nums[i], amount[i - 1]);
		}

		return amount[nums.length - 1];
	}
}
