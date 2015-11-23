package org.hanjia.leetcode.string;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * @author hanjia
 *
 */
public class Problem135_ValidPalindrome {
	
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0) 
        	return true;
 
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
 
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){  //Two Pointers
				return false;
			}
		}
 
		return true;
    }
}
