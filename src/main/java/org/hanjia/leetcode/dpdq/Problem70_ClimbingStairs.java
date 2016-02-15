package org.hanjia.leetcode.dpdq;


/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * @author hanjia
 *
 */
public class Problem70_ClimbingStairs {
	public int climbStairs(int n) {
        if (n == 1) return 1;  
        if (n == 2) return 2;
        
        int[] result = new int[n]; 
        result[0] = 1;  
        result[1] = 2;  
        for (int i = 2; i < n; i++) {  
            result[i] = result[i-1] + result[i-2];  
            //Since we can only take 1 or 2 steps a time, 
            //we either climb from stair (i-1) or (i-2) when we were at stair i
        }  
        return result[n - 1];  
    }
}
