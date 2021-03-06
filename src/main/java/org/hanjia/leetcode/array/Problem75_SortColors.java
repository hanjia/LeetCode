package org.hanjia.leetcode.array;

/**
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem75_SortColors {

	//Counting Sort: https://www.cs.usfca.edu/~galles/visualization/CountingSort.html
	
     public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}

		int[] countArray = new int[3];
		for (int i = 0; i < nums.length; i++) {
			countArray[nums[i]]++;
		}

		for (int i = 1; i <= 2; i++) {
			countArray[i] = countArray[i - 1] + countArray[i];
		}

		int[] sorted = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int index = countArray[nums[i]] - 1;
			countArray[nums[i]] = countArray[nums[i]] - 1;
			sorted[index] = nums[i];
		}

		System.arraycopy(sorted, 0, nums, 0, nums.length);
     }
    
    public void sortColorsBetter(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}

		int[] countArray = new int[3];
		for (int i = 0; i < nums.length; i++) {
			countArray[nums[i]]++;
		}

		int j = 0;
		int k = 0;
		while (j <= 2) {
			if (countArray[j] != 0) {
				nums[k++] = j;
				countArray[j] = countArray[j] - 1;
			} else {
				j++;
			}
		}
    }
}
