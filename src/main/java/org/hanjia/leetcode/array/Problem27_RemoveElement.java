package org.hanjia.leetcode.array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * @author hanjia
 *
 */
public class Problem27_RemoveElement {
	public static int removeElement(int[] nums, int val) {
        int p1 = 0, p2 = 0;
        while(p2 < nums.length){
            if(nums[p2] != val) {
                nums[p1] = nums[p2];
                p1++;
                p2++;
            }else{
                p2++;
            }
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
