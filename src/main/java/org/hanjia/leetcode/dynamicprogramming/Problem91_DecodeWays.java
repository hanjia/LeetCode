package org.hanjia.leetcode.dynamicprogramming;

/**
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author hanjia
 *
 */
public class Problem91_DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.equals("0")) {
			return 0;
		}
	 
		int[] result = new int[s.length() + 1];
	    result[0] = 1;
	 
		if (isValid(s.substring(0, 1))) {
			result[1] = 1;
		} else {
			result[1] = 0;
		}
	    
		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i - 1, i))) {
				result[i] += result[i - 1];
			}

			if (isValid(s.substring(i - 2, i))) {
				result[i] += result[i - 2];
			}
		}
	 
	    return result[s.length()];
	}
	 
	public boolean isValid(String s){
		if (s.charAt(0) == '0') {
			return false;
		}
	    int value = Integer.parseInt(s);
		return (value >= 1 && value <= 26);
	}
}
