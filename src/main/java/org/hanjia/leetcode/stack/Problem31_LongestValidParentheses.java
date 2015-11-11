package org.hanjia.leetcode.stack;

import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * @author hanjia
 *
 */
public class Problem31_LongestValidParentheses {

	public static int longestValidParenthesesDPSolution(String s) {
		if (s.length() == 0)
	        return 0;
		int maxLength = 0;
		int[] d = new int[s.length()]; // d[i]: indicating the max length of valid string that started at i
		d[s.length() - 1] = 0;
		
		for(int i = s.length() - 2; i >= 0; i--){ // from end to start
			if(s.charAt(i) == ')'){
				d[i] = 0;
			}else{
				int j = (i + 1) + d[i + 1]; 
				// j: the index for the end of longest valid string that started at i. 
				// no mater what (i + 1)'s longest string looks like just wrap it with '(' and ')'
				if (j < s.length() && s.charAt(j) == ')') {
					d[i] = d[i + 1] + 2; // for the case like this: ((...))
					if (j + 1 < s.length()){
						d[i] += d[j + 1]; // for the case like this: ((...))()()()
					}
				}				
			}
			
			maxLength = Math.max(maxLength, d[i]);
		}
			
		return maxLength;
	}
	
	public static int longestValidParenthesesStackSolution(String s) {
		if (s.length() == 0)
	        return 0;
		int maxLength = 0;
		Stack<Integer> stack = new Stack<Integer>(); //To store indexes
		
		for(int i = 0; i < s.length(); i++){
			if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
				stack.pop();
				if (stack.isEmpty()) {
					maxLength = i + 1;
				}else{
					maxLength = Math.max(maxLength, i - stack.peek());
				}
			} else {
				stack.push(i); // Push to the stack if it is '(' or if it is ')' but cannot match with the top element at stack
			}
		}
		
		return maxLength;
	}

}
