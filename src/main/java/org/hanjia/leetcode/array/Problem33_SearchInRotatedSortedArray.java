package org.hanjia.leetcode.array;

/**
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * @author hanjia
 *
 */
public class Problem33_SearchInRotatedSortedArray {
    /**
     * 
     * Algorithm: binary search but need to check which half has the rotated part before moving left or right pointer
     * 
     * @param nums
     * @param target
     * @return
     */
	public static int searchIterative(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (nums[middle] == target) {
				return middle;
			}

			if (nums[middle] >= nums[left]) {
				if (target > nums[middle] || target < nums[left]) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			} else {
				if (target < nums[middle] || target > nums[right]) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			}
		}
		return -1;
    }
	
	public static int searchRecursive(int[] nums, int target) {
		return -1;
	}
	
    public static void main(String[] args){
    	int[] nums = {1,2,3,4,5,5,6,6,7};
    	int target = 8;
    	System.out.println(searchIterative(nums,target));
    }

}
