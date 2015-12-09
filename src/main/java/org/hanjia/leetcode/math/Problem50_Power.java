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
	        return pow(x, n);
	    } else {
	        return 1/pow(x,-n);
	    }
	}

	public double pow(double x, int n) {
	    if (n == 0) {
	        return 1;
	    }
	    if (n == 1) {
	        return x;
	    }
	    
	    double v = pow(x, n/2);
	    
	    if (n % 2 == 0) {
	        return v*v;
	    } else {
	        return v*v*x;
	    }
	}
}
