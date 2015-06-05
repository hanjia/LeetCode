package org.hanjia.leetcode.string;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author hajia
 *
 */
public class Problem13_RomanToInteger {
	
    public static int romanToInt(String s) {
    	int i, total, pre, cur;    	  
        total = charToInt(s.charAt(0));  
  
        for (i = 1; i < s.length(); i++) {  
            pre = charToInt(s.charAt(i - 1));  
            cur = charToInt(s.charAt(i));  
  
            if (cur <= pre) {  
                total += cur;  
            } else {  
                total = total - pre * 2 + cur;  
            }  
        }
        return total;
    }
    
    public static int charToInt(char c) {  
    	switch(c) {  
    		case 'I': return 1;  
    		case 'V': return 5;  
    		case 'X': return 10;  
    		case 'L': return 50;  
    		case 'C': return 100;  
    		case 'D': return 500;  
    		case 'M': return 1000;  
    		default: return 0;  
    	}  
    } 
    
    public static void main(String[] args){
    	String num = "MMCVI";
    	System.out.println(romanToInt(num));
    }
}
