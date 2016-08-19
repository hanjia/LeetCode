package org.hanjia.leetcode.array;

/**
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author hanjia
 *
 */
public class Problem153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			if (nums[start] <= nums[end]) { 
				// we have the correct order now so the start should point to the smallest element
				return nums[start];
			}
			
			int mid = (start + end) / 2;
			if (nums[mid] >= nums[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
		int[] nums2 = {6, 7, 0, 1, 2, 4, 5};
		int[] nums3 = {0, 1, 2};
		int[] nums4 = {2};
		Problem153_FindMinimumInRotatedSortedArray min = new Problem153_FindMinimumInRotatedSortedArray();
		System.out.println(min.findMin(nums1));
		System.out.println(min.findMin(nums2));
		System.out.println(min.findMin(nums3));
		System.out.println(min.findMin(nums4));
	}
}
