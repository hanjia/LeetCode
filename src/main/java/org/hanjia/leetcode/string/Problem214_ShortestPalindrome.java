package org.hanjia.leetcode.string;

/**
 * 
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 * 
 * 
 * @author hanjia
 *
 */
public class Problem214_ShortestPalindrome {

	public String shortestPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (end >= 0) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
			}
			end--;
		}

		if (start == s.length())
			return s;

		// recursively make the substring palindromic
		String result = shortestPalindrome(s.substring(0, start));

		String suffix = s.substring(start);
		String prefix = new StringBuilder(suffix).reverse().toString();	

		return prefix + result + suffix;
	}
	
	public static void main(String[] args){
		Problem214_ShortestPalindrome shortest = new Problem214_ShortestPalindrome();
		String s1 = "abcba";
		String s2 = "deabcba";
		String s3 = "abcbaed";
		String s4 = "abacdeaba";
		System.out.println(shortest.shortestPalindrome(s1));
		System.out.println(shortest.shortestPalindrome(s2));
		System.out.println(shortest.shortestPalindrome(s3));
		System.out.println(shortest.shortestPalindrome(s4));
	}
	
}
