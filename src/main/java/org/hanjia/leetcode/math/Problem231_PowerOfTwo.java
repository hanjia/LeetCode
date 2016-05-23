package org.hanjia.leetcode.math;


/**
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author hanjia
 *
 */
public class Problem231_PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
	    if (n < 0) {
	        return false;
	    }
	    while (n > 0) {
	        if ((n & 1) == 1) {
	        	return false;
	        }
	        n = n >> 1;
	    }
	    return true;
	}
	
	public static void main(String[] args){
		Problem231_PowerOfTwo power = new Problem231_PowerOfTwo();
		System.out.println(power.isPowerOfTwo(1025));
	}
}
