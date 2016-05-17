package org.hanjia.leetcode.string;

/**
 * Implement strStr():
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * @author hanjia
 *
 */
public class Problem28_ImplementStrStr {

	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return 0;

		int needleLength = needle.length();
		int haystackLength = haystack.length();
		if (needleLength == 0) {
			return 0;
		}

		for (int i = 0; i < haystackLength; i++) {
			if (i + needleLength > haystackLength)
				return -1;

			int m = i;
			for (int j = 0; j < needleLength; j++) {
				if (needle.charAt(j) == haystack.charAt(m)) {
					if (j == needleLength - 1) { // if the last char of needle matches
						return i;
					} else {
						m++;
					}
				} else {
					break;
				}
			}
		}
		return -1;
    }
	
	public static void main(String[] args){
		String haystack = "Please say hello java!";
		String needle = "hello";
		System.out.println(strStr(haystack,needle));
	}
}
