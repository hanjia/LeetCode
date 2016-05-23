package org.hanjia.leetcode.math;

/**
 * 
 * Implement pow(x, n).
 * 
 * @author hanjia
 *
 */
public class Problem50_Power {
	
	public double myPow(double x, int n) {
		if (n > 0) {
			return power(x, n);
		} else {
			return 1 / power(x, -n);
		}
	}

	public double power(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}

		double half = power(x, n / 2); // Divide
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}
}
