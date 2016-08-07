package org.hanjia.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * @author hanjia
 *
 */
public class Problem139_WordBreak {
	// DP Solution
	public boolean wordBreak(String s, Set<String> dict) {
        boolean[] segment = new boolean[s.length() + 1];
        segment[0] = true; 
 
		for (int i = 0; i < s.length(); i++) {
			if (!segment[i])
				continue;

			for (String word : dict) {
				int length = word.length();
				int end = i + length;
				if (end > s.length())
					continue;

				if (segment[end])
					continue;

				if (s.substring(i, end).equals(word)) {
					segment[end] = true;
				}
			}
		}
 
        return segment[s.length()];
    }
	
	// Recursive
	public boolean wordBreakRecursive(String s, Set<String> dict) {
		return wordBreakHelper(s, dict, 0);
	}
	
	private boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length()) 
            return true;
 
		for (String word : dict) {
			int length = word.length();
			int end = start + length;

			// end index should be <= string length
			if (end > s.length())
				continue;

			if (s.substring(start, start + length).equals(word) && wordBreakHelper(s, dict, start + length))
				return true;
		}
 
        return false;
    }
	
	public static void main(String[] args) {
		String s = "leetcodelintcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("lint");
		
		Problem139_WordBreak wordBreak = new Problem139_WordBreak();
		System.out.println(wordBreak.wordBreakRecursive(s, dict));
		System.out.println(wordBreak.wordBreak(s, dict));

	}
}
