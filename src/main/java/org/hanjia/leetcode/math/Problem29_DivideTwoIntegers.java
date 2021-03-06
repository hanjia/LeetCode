package org.hanjia.leetcode.math;

/**
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * number = a0 * 2^0 + a1 * (2^1) + a2 * (2^2) + ... + an * (2^n)
 * 
 * @author hanjia
 *
 */
public class Problem29_DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
		if (divisor == 0 || (divisor == -1 && dividend == Integer.MIN_VALUE))
			return Integer.MAX_VALUE;

		long remain = Math.abs((long) dividend);
		long div = Math.abs((long) divisor);
		int result = 0;

		while (remain >= div) {
			int numShift = 0;
			while (remain >= (div << numShift)) {
				numShift++;
			}
			
			result += (1 << (numShift - 1)); // The idea is to find a number which is 2's power to be multiplied with divisor so that the result is closet to divisor
			remain -= (div << (numShift - 1)); 	// dividend minus the largest shifted divisor
		}
		
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			return -result;
		} 
		
		return result;
    }
    
    public static void main(String[] args){
    	System.out.println(divide(2147483647, 1));
    	System.out.println(divide(2147483647, -1));
    	System.out.println(divide(1, -1));
    	System.out.println(divide(1, 0));
    	System.out.println(divide(0, 1));
    	System.out.println(1 << 3);
    }
}
