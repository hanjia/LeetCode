package org.hanjia.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem179_LargestNumber {
    public String largestNumber(int[] nums) {
    	// convert numbers to strings
        String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
     
		// sort arrays
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String leftRight = s1 + s2;
				String rightLeft = s2 + s1;
				return -leftRight.compareTo(rightLeft); // To sort DESC

			}
		});
     
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
     
        return sb.toString();
    }
    
    public static void main(String[] args){
    	int[] nums = {3, 4, 2, 6, 10, 23};
    	Problem179_LargestNumber largestNumber = new Problem179_LargestNumber();    	
    	System.out.println(largestNumber.largestNumber(nums));
    }
}
