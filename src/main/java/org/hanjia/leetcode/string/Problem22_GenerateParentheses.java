package org.hanjia.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author hajia
 *
 */
public class Problem22_GenerateParentheses {
	
	public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        backtrack(result, "", n, n); //Using Depth-first Search
        return result;
    }
    
    public static void backtrack(ArrayList<String> result, String s, int left, int right){
        if(left > right) return; //if there are more "(" than ")" remaining, we will not be able to build a valid one so stop
     
        if(left == 0 && right == 0){
            result.add(s);
            return;
        }
     
        if(left>0){
        	backtrack(result, s + "(", left-1, right);
        }
     
        if(right>0){
        	backtrack(result, s + ")", left, right-1);
        }
    }
    
    public static void main(String[] args){
    	List<String> results = generateParenthesis(3);
    	System.out.println(results);
    }
}
