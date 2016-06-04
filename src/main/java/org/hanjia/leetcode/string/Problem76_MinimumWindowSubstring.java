package org.hanjia.leetcode.string;

/**
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * @author hanjia
 *
 */
public class Problem76_MinimumWindowSubstring {
	int initTargetHash(int[] targetHash, String target) {
		int targetNum = 0;
		for (char ch : target.toCharArray()) {
			targetNum++;
			targetHash[ch]++;
		}
		return targetNum;
	}

	public String minWindow(String source, String target) {
		int minLength = Integer.MAX_VALUE; // queue the position that matches the char in T
		String minString = "";

		int[] targetHash = new int[256];
		int targetNum = initTargetHash(targetHash, target);
		int sourceNum = 0;
		
		int start = 0;
		for (int end = 0; end < source.length(); end++) {
			if (targetHash[source.charAt(end)] > 0)
				sourceNum++;

			targetHash[source.charAt(end)]--;
			
			while (sourceNum >= targetNum) {
				if (minLength > end - start + 1) {
					minLength = Math.min(minLength, end - start + 1);
					minString = source.substring(start, end + 1);
				}
				
				targetHash[source.charAt(start)]++;
				if (targetHash[source.charAt(start)] > 0)
					sourceNum--;
				start++;
			}
		}
		return minString;
	}
	
	public static void main(String[] args){
		String source = "ADOBECODEBANC";
		String target = "ABC";
		Problem76_MinimumWindowSubstring window = new Problem76_MinimumWindowSubstring();
		String result = window.minWindow(source, target);
		System.out.println(result);
	}
	
}
