package org.hanjia.leetcode.array;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * @author hanjia
 *
 */
public class Problem55_JumpGame {
	public boolean canJump(int[] array) {
		if (array.length <= 1){
			return true;
		}
		
		int max = array[0]; // max stands for the largest index that can be reached.

		for (int i = 0; i < array.length; i++) {
			// if not enough to go to next
			if (max <= i && array[i] == 0)
				return false;

			// update max
			if (i + array[i] > max) {
				max = i + array[i];
			}

			// max is enough to reach the end
			if (max >= array.length - 1)
				return true;
		}
	 
	    return false;    
	}
}
