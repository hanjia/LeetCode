package org.hanjia.leetcode.dpdq;

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

			for (String a : dict) {
				int length = a.length();
				int end = i + length;
				if (end > s.length())
					continue;

				if (segment[end])
					continue;

				if (s.substring(i, end).equals(a)) {
					segment[end] = true;
				}
			}
		}
 
        return segment[s.length()];
    }
	
	// Recursive
	public boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length()) 
            return true;
 
        for(String a: dict){
            int len = a.length();
            int end = start+len;
 
            //end index should be <= string length
            if(end > s.length()) 
                continue;
 
            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }
 
        return false;
    }
	
	// TODO: add tests
}
