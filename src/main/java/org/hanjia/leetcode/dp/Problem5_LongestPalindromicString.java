package org.hanjia.leetcode.dp;

/**
 * 
 Problem 5: Given a string S, find the longest palindromic substring in S. 
 You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * Algorithm: Dynamic Programming
 * 
 * @author hanjia
 *
 */
public class Problem5_LongestPalindromicString {
	public String longestPalindromeDPSolution (String str) {
	    boolean[][] table = new boolean[str.length()][str.length()];
	    int max = 0;
	    String longest = "";
	    
//	    for (int i = str.length() - 1; i >= 0; i--) {
//	        for (int j = i; j < str.length(); j++) {
//	        	/**
//	        	 * P[i, j] = true if P[i+1][j-1] is true and character i and j are the same
//	        	 * Special case is the distance of i and j is smaller than 2
//	        	 */
//				if (str.charAt(i) == str.charAt(j) && ((j - i <= 2) || table[i + 1][j - 1])) {
//					table[i][j] = true;
//					
//					if (max < j - i + 1) { // Update result
//						max = j - i + 1;
//						longest = str.substring(i, j + 1);
//					}
//				}
//	        }
//	    }
	    
	    for (int i = 0; i < str.length(); i++) {
	    	for (int j = i - 1; j > 0; j--) {
				if (str.charAt(i) == str.charAt(j) && ((i - j <= 2) || table[i - 1][j + 1])) {
					table[i][j] = true;				
					if (max < i - j + 1) { // Update result
						max = i - j + 1;
						longest = str.substring(j, i + 1);
					}
				}
	    	}
	    }
	    return longest;
	}
	
	public String longestPalindromeThroughBruteForce(String str) { // Possibly get TLE
	    int max = 0;
	    String longest = null;
	    for (int i = 0; i < str.length(); i++) {
	        for (int j = i + 1; j < str.length(); j++) {
	            String subString = str.substring(i, j + 1);
	            if (isPalindormic(subString)) {
	                if (subString.length() > max) {
	                    max = subString.length();
	                    longest = subString;
	                }
	            }
	        }
	    }
	    return longest;
	}

	private boolean isPalindormic(String s) {
	    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
	        if (s.charAt(i) != s.charAt(j)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args){
		String str = "dawabcbawefrwp";
		Problem5_LongestPalindromicString longestPalindromicString = new Problem5_LongestPalindromicString();
		System.out.println(longestPalindromicString.longestPalindromeThroughBruteForce(str));
		System.out.println(longestPalindromicString.longestPalindromeDPSolution(str));
	}
}
