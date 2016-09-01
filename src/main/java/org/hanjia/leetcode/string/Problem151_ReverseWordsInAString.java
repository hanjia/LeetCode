package org.hanjia.leetcode.string;

public class Problem151_ReverseWordsInAString {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
	
    // public String reverseWords(String s) {
    //     char[] array = s.toCharArray();
    //     reverseString(array, 0, array.length - 1);
    //     int left = 0;
    //     int right = 0;
    //     for (int i = 0; i < array.length; i++) {
    //         if (array[i] == ' ') {
    //             reverseString(array, left, right - 1);
    //             left = i + 1;
    //             right = left;
    //         } else {
    //             right++;
    //         }
    //     }
    //     reverseString(array, left, right - 1);
    //     return new String(array);
    // }
    
    // public static char[] reverseString(char[] a, int left, int right) {
    //     while (left < right) {
    //         char temp = a[left];
    //         a[left++] = a[right];
    //         a[right--] = temp;
    //     }
    //     return a;
    // }
	
	// TODO: add tests
}
