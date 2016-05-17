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
	public String countAndSay(int n) {
		if (n < 1)
			return null;

        String result = "1";
		for (int i = 1; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 1;			
			for (int j = 1; j < result.length(); j++) { // To get the count and start from 1 instead of 0
				if (result.charAt(j) == result.charAt(j - 1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(result.charAt(j - 1));
					count = 1;
				}
			}
			sb.append(count); // Count
			sb.append(result.charAt(result.length() - 1)); // Say
			result = sb.toString(); 
		}
        return result;
    }
	
	public static void main(String[] args){
		Problem38_CountAndSay countAndSay = new Problem38_CountAndSay();
		System.out.println(countAndSay.countAndSay(1));
		System.out.println(countAndSay.countAndSay(2));
		System.out.println(countAndSay.countAndSay(3));
		System.out.println(countAndSay.countAndSay(4));
		System.out.println(countAndSay.countAndSay(5));
		System.out.println(countAndSay.countAndSay(6));

	}
}
