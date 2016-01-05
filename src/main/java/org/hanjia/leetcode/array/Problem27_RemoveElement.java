package org.hanjia.leetcode.array;

/**
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem27_RemoveElement {
	/**
	 * 
	 * Algorithm: Use two points: One is to store the end of the result and starts from the first element; The other is to simply traverse the array and starts from the first element.
	 * If specified value and the value of the second pointer are different, change the value of the first pointer to the second pointer and move the first pointer one step forward.
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		int p1 = 0; // To store the end of the result array
        int p2 = 0; // To traverse the array
		while (p2 < nums.length) {
			if (nums[p2] != val) {
				nums[p1] = nums[p2];
				p1++;
			}
			p2++;
		}
		return p1;
    }
	
	public static void main(String[] args){
		int[] a = {1,2,3,3,4,5};
		int[] b = {1};
		System.out.println(removeElement(a, 3));
		System.out.println(removeElement(b, 1));
		System.out.println(removeElement(b, 3));

	}
}
