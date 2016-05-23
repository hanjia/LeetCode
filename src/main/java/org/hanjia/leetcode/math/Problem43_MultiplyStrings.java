package org.hanjia.leetcode.math;

/**
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @author hanjia
 *
 */
public class Problem43_MultiplyStrings {
	public static String multiply(String num1, String num2) {
		String s1 = new StringBuilder(num1).reverse().toString();
		String s2 = new StringBuilder(num2).reverse().toString();
		
		int[] digits = new int[num1.length() + num2.length()];
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				digits[i + j] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < digits.length; k++) {
			int modular = digits[k] % 10;
			int carry = digits[k] / 10;
			if (k < digits.length - 1) {
				digits[k + 1] += carry;
			}
			sb.insert(0, modular);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		
		return sb.toString();
	}
}
