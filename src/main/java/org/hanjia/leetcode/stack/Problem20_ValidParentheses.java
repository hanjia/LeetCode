package org.hanjia.leetcode.stack;

import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author hanjia
 *
 */
public class Problem20_ValidParentheses {

    public static boolean isValid(String s) {
        char[] arrays = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c: arrays){
        	if(c == '}'){
        		if(stack.isEmpty() || stack.pop() != '{'){
        			return false;
        		}
        	}else if(c == ']'){
        		if(stack.isEmpty() || stack.pop() != '['){
        			return false;
        		}
        	}else if(c == ')'){
        		if(stack.isEmpty() || stack.pop() != '('){
        			return false;
        		}
        	}else{
            	if(c == '{' || c == '[' || c == '('){
            		stack.push(c);
            	}
        	}
        }
        
        if(!stack.isEmpty()) 
        	return false;
        
        return true;
    }
   
}
