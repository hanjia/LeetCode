package org.hanjia.leetcode.misc;

public class Problem29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (divisor == -1 && dividend == Integer.MIN_VALUE))
            return Integer.MAX_VALUE;
    
        long remain = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);
        int count = 0;
        
        while(remain >= div){
        	 int numShift = 0;    
             while(remain>=(div<<numShift)){
                 numShift++;
             }
      
             //dividend minus the largest shifted divisor
             count += 1<< (numShift-1);
             remain -= (div << (numShift-1));
        }
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            return -count;
        }else{
            return count;
        }
    }
}
