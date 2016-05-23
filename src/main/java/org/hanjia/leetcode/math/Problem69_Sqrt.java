package org.hanjia.leetcode.math;

/**
 * 
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author hanjia
 *
 */
public class Problem69_Sqrt {
	public int mySqrt(int x) {
		long left = 1;
		long right = x;
		
		while (left + 1 < right) {
			long mid = (right + left) / 2;
			if (mid * mid < x) {
				left = mid;
			} else if (mid * mid > x) {
				right = mid;
			} else {
				return (int) mid;
			}
		}
		
		if (right * right <= x) {
			return (int) right;
		}
		return (int) left;
	}
}
