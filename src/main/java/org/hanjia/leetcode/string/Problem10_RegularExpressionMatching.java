package org.hanjia.leetcode.string;


/**
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * boolean isMatch(const char *s, const char *p)
 * 
 * Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 *
 * @author hajia
 *
 */
public class Problem10_RegularExpressionMatching {
	
	public static void main(String[] args){
		String string = "asd";
		String pattern = "asd*";
		System.out.println(isMatch(string,pattern));
	}

    public static boolean isMatch(String s, String p) {
    	//base case
        if(p.length() == 0){
            return s.length() == 0;
        }
         
        //special case
		if (p.length() == 1) {
            if (s.length() == 0){
                return false;
            } 
            
            if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) { 
            	// if the first char of s and the first char of p is not the same, 
                //and the char of p is not '.', return false
                return false;
            }
            
            //otherwise, compare the rest of the string of s and p.
            return isMatch(s.substring(1), p.substring(1));
        }
         
        
		if (p.charAt(1) != '*') { // case 1: when the second char of p is not '*'.
			if (s.length() == 0) {
				return false;
			}
			
			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			} 
				
			return isMatch(s.substring(1), p.substring(1));
			
		} else{ // case 2: when the second char of p is '*'.
            if (isMatch(s, p.substring(2))) {  //when the '*' stands for 0 preceding element
                return true;
            }
             
            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                //when the '*' stands for 1 or more preceding element, try every possible number
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
                i++;
            }
            return false;
        }
    }
}
