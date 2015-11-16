package org.hanjia.leetcode.string;


/**
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author hanjia
 *
 */
public class Problem38_CountAndSay {
	public static String countAndSay(int n) {
        if(n <= 0) 
            return null;

        int i = 1;
        String result = "1";
        while(i < n){
        	
        	int count = 1;
    		StringBuilder sb = new StringBuilder();
    		
    		for(int j = 1; j < result.length(); j++){ // To get the count and start from 1 instead of 0
    			if (result.charAt(j) == result.charAt(j - 1)) {
    				count++;
    			} else {
    				sb.append(count);
    				sb.append(result.charAt(j - 1));
    				count = 1;
    			}
    		}
    		sb.append(count);
    		sb.append(result.charAt(result.length() - 1));
    		result = sb.toString(); //Update the result string
        	i++;
        }
        return result;
    }
	
	public static void main(String[] args){
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));

	}
}
