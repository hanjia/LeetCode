package org.hanjia.leetcode.array;

import java.util.Arrays;

/**
 * 
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * 
 * @author hajia
 *
 */
public class Problem280_WiggleSort {
	// One-pass swap – O(n) time
	// Intuitively, we should be able to reorder it in one-pass. 
	// As we iterate through the array, we compare the current element to its next element and if the order is incorrect, we swap them.
	public void wiggleSort(int[] nums) {
	    boolean less = true;
	    for (int i = 0; i < nums.length - 1; i++) {
	        if (less) {
	            if (nums[i] > nums[i + 1]) {
	                swap(nums, i, i + 1);
	            }
	        } else {
	            if (nums[i] < nums[i + 1]) {
	                swap(nums, i, i + 1);
	            }
	        }
	        less = !less;
	    }
	}
	
	// Sort First - O(nlogn) time
	public void wiggleSortWithSortingFirst(int[] nums) {
	    Arrays.sort(nums);
	    for (int i = 1; i < nums.length - 1; i += 2) {
	        swap(nums, i, i + 1);
	    }
	}

	
	private void swap(int[] nums, int i, int j) {
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
}
