package org.hanjia.leetcode.array;

/**
 * 
 * @author hanjia
 *
 */
public class Problem33_SearchInRotatedSortedArray {
    
	public static int searchIterative(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left)/2;
            if(nums[middle] == target){
                return middle;
            }
            
            if(nums[middle] >= nums[left]){
                if(target > nums[middle] || target < nums[left]){
                    left = middle + 1;
                }else{
                    right = middle - 1;
                }
            } else{
                if(target < nums[middle] || target > nums[right]){
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }
        }
        return -1;
    }
	
	public static int searchRecursive(int[] nums, int target) {
		return -1;
	}

}
