package org.hanjia.leetcode.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author hajia
 *
 */
public class Problem14_LongestCommonPrefix {

	public static void main(String[] args){
		String[] strs = {"a","ab","abc"};
		System.out.println(longestCommonPrefix(strs));
	}
	public static String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";        
        if(strs.length < 1) 
        	return commonPrefix;
        
        int minLength = Integer.MAX_VALUE;
        for(String str: strs){
        	if(str.length() < minLength) minLength = str.length();
        }
        
        int index = 0;
        while(index < minLength){
            boolean common = true;
            char c = strs[0].charAt(index);
            for(String str: strs){
                if(str.charAt(index) != c){
                    common = false;
                    break;
                }
            }
            if(!common){
            	break;
            }
            index++;
        }
        commonPrefix = strs[0].substring(0, index);
        return commonPrefix;
    }
}
