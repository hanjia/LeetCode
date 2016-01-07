package org.hanjia.leetcode.array;

/**
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author hanjia
 *
 */
public class Problem81_SearchInRotateSortedArray2 {
	/**
	 * 
	 * Algorithm: binary search but need to check which half has the rotated part before moving left or right pointer. The only special case is when left and middle pointer have the same value (duplicates)
	 *
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return true;

			if (nums[left] < nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] > nums[mid]) {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else { // if the element at the left most equals the one at middle, then we can simple ignore it
				left++;
			}
		}
        return false;
    }
}
