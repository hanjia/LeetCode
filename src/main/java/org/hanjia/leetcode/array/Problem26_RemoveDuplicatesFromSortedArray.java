package org.hanjia.leetcode.array;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example, given input array nums = [1,1,2], 
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
 * It doesn't matter what you leave beyond the new length.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem26_RemoveDuplicatesFromSortedArray {
	/**
	 * 
	 * Algorithm: Use two points: One is to store the end of the result and starts from the first element; The other is to simply traverse the array and starts from the second element.
	 * If two values are different, move the first pointer one step forward and change its value to the value of the second pointer.
	 * 
	 * @param nums
	 * @return
	 */
    public static int removeDuplicates(int[] nums) {
    	if(nums.length < 2) 
    		return nums.length;
    	
        int p1 = 0; // To store the end of the result array
        int p2 = 1; // To traverse the array
        while (p1 < nums.length && p2 < nums.length){
	        if(nums[p1] != nums[p2]){
		        p1++;
		        nums[p1] = nums[p2];
	        }
	        p2++;
        }
        
    	return p1 + 1;
    }

    
	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 2, 3 };
		int[] b = { 1, 1 };
		System.out.println(removeDuplicates(a) + ":" + Arrays.toString(a));
		System.out.println(removeDuplicates(b) + ":" + Arrays.toString(b));
	}
}
