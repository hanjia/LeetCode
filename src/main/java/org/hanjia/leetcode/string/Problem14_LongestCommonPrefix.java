package org.hanjia.leetcode.string;

/**
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author hanjia
 *
 */
public class Problem14_LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length < 1) 
        	return "";
        
        // To find the minimum length
        int minLength = Integer.MAX_VALUE;
        for(String str: strs){
        	if(str.length() < minLength) 
        		minLength = str.length();
        }
        
        // Check each character in sequence
        int index = 0;
		while (index < minLength) { 
			boolean common = true;
			char c = strs[0].charAt(index);
			for (String str : strs) {
				if (str.charAt(index) != c) {
					common = false;
					break;
				}
			}
			if (!common) {
				break;
			}
			index++;
		}
		
        return strs[0].substring(0, index);
    }
	
	public static void main(String[] args){
		String[] strs = {"ab","abwfwef","abc"};
		System.out.println(longestCommonPrefix(strs));
	}
}
