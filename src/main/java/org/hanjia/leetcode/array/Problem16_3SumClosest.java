package org.hanjia.leetcode.array;

import java.util.Arrays;

public class Problem16_3SumClosest {

	public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target)
                    start++;
                else
                    end--;
            }
        }
        return closest;
    }
}
