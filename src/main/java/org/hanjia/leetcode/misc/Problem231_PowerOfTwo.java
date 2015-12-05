package org.hanjia.leetcode.misc;


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
	    boolean once = false;
	    while (n > 0) {
	        if ((n & 1) == 1) {
	            if (once) {
	                return false;
	            } else {
	                once = true;
	            }
	        }
	        n = n >> 1;
	    }
	    return once;
	}
}
