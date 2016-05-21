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
        boolean valid = true;
        for(char c: arrays){
        	if(c == '}'){
        		if(stack.isEmpty() || stack.pop() != '{'){
        			valid = false;
        			break;
        		}
        	}else if(c == ']'){
        		if(stack.isEmpty() || stack.pop() != '['){
        			valid = false;
        			break;
        		}
        	}else if(c == ')'){
        		if(stack.isEmpty() || stack.pop() != '('){
        			valid = false;
        			break;
        		}
        	}else{
            	if(c == '{' || c == '[' || c == '('){
            		stack.push(c);
            	}
        	}
        }
        
        if(!stack.isEmpty()) valid = false;
        return valid;
    }
   
}
