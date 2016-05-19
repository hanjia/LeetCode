package org.hanjia.leetcode.string;

import java.util.Arrays;

/**
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem3_LongestSubstring {	
	
	public int lengthOfLongestSubstring(String s) {
        int length = s.length();  
        if (length == 0) {  
            return 0;  
        }  
        
        int [] countTable = new int[256];  
        Arrays.fill(countTable, -1);  
        int max = 1;  
        int start = 0;  
        int end = 1;  
          
        countTable[s.charAt(0)] = 0;  
        while (end < length) {  
            if (countTable[s.charAt(end)] >= start) { // reached a duplicate char so reset start pointer
                start = countTable[s.charAt(end)] + 1;                
            }  
            max = Math.max(max, end - start + 1);  
            countTable[s.charAt(end)] = end;  
            end++;  
        }  
        return max;  
    }
}
