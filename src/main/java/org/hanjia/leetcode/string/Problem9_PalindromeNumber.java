package org.hanjia.leetcode.string;

/**
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author hanjia
 *
 */
public class Problem9_PalindromeNumber {

	 public static boolean isPalindrome(int x) {
	        if(x < 0){
	        	return false;
	        }
	        String sofx = String.valueOf(x);
	        String result = new StringBuffer(sofx).reverse().toString();
	        return sofx.equalsIgnoreCase(result);
	}
	
	
	public static void main(String[] args){
		int input = -122;
		System.out.println("Is "+input+" a palindrom number?" + isPalindrome(input));
	}
}
