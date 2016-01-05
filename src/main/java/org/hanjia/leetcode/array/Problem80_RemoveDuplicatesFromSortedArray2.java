package org.hanjia.leetcode.array;

import java.util.Arrays;


/**
 * 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
 * It doesn't matter what you leave beyond the new length.
 * 
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-remove-duplicates-from-sorted.html
 * 
 * 
 * @author hanjia
 *
 */
public class Problem80_RemoveDuplicatesFromSortedArray2 {
	/**
	 * 
	 * Algorithm: Use two points: One is to store the end of the result and starts from the second element ; The other is to simply traverse the array and starts from the third element. 
	 * If the value of the element prior to the first pointer and of the second pointer are different, move the first pointer one step forward and change its value to the value of the second pointer.
	 * 
	 * @param nums
	 * @return
	 */
    public static int removeDuplicates(int[] nums) {
    	if(nums.length < 3) 
    		return nums.length;
    	
        int p1 = 1; // To store the end of the result array
        int p2 = 2; // To traverse the array
        while (p1 < nums.length && p2 < nums.length){
            if(nums[p1 - 1] != nums[p2]){
            	p1++;
            	nums[p1] = nums[p2];
            }
            p2++;
        }
        
    	return p1 + 1;
    }
    
	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 2, 3 };
		int[] b = { 1, 1, 1 };
		System.out.println(removeDuplicates(a) + ":" + Arrays.toString(a));
		System.out.println(removeDuplicates(b) + ":" + Arrays.toString(b));
	}
}
