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
	int initTargetHash(int[] targetHash, String Target) {
		int targetNum = 0;
		for (char ch : Target.toCharArray()) {
			targetNum++;
			targetHash[ch]++;
		}
		return targetNum;
	}

	public String minWindow(String source, String target) {
		int result = Integer.MAX_VALUE; // queue the position that matches the char in T
		String minStr = "";

		int[] targetHash = new int[256];
		int targetNum = initTargetHash(targetHash, target);
		int sourceNum = 0;
		
		int j = 0;
		for (int i = 0; i < source.length(); i++) {
			if (targetHash[source.charAt(i)] > 0)
				sourceNum++;

			targetHash[source.charAt(i)]--;
			
			while (sourceNum >= targetNum) {
				if (result > i - j + 1) {
					result = Math.min(result, i - j + 1);
					minStr = source.substring(j, i + 1);
				}
				
				targetHash[source.charAt(j)]++;
				if (targetHash[source.charAt(j)] > 0)
					sourceNum--;
				j++;
			}
		}
		return minStr;
	}
	
}
