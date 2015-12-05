package org.hanjia.leetcode.array;

/**
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author hanjia
 *
 */
public class Problem66_PlusOne {
	public static int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        if (digits[0] == 0) {
            int[] r = new int[digits.length + 1];
            r[0] = 1;
            for (int i = 1; i < r.length; i++) {
                r[i] = 0;
            }
            return r;
        } else {
            return digits;
        }        
    }
}
