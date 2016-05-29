package org.hanjia.leetcode.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
	"1 + 1" = 2
	" 2-1 + 2 " = 3
	"(1+(4+5+2)-3)+(6+8)" = 23
 * 
 * 
 * @author hanjia
 *
 */
public class Problem224_BasicCalculator {

	public int calculate(String s) {
		Stack<String> stack = new Stack<String>();
		s = s.replaceAll(" ", "");	 
		char[] array = s.toCharArray();
		StringBuilder sb = new StringBuilder();  // To store multi-digits numbers
		
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= '0' && array[i] <= '9') { // Numbers
				sb.append(array[i]);
	 
				if (i == array.length - 1) {
					stack.push(sb.toString());
				}
			} else { // Operators
				if (sb.length() > 0) {
					stack.push(sb.toString());
					sb = new StringBuilder();
				}
	 
				if (array[i] != ')') {
					stack.push(new String(new char[]{ array[i] }));
				} else { // when meet ')', pop and calculate
					List<String> subset = new ArrayList<String>();
					while (!stack.isEmpty()) {
						String top = stack.pop();
						if (top.equals("(")) {
							break;
						} 
						subset.add(0, top);					
					}
	 
					int result = 0;
					if (subset.size() == 1) {
						result = Integer.valueOf(subset.get(0));
					} else {
						for (int j = subset.size() - 1; j > 0; j = j - 2) {
							if (subset.get(j - 1).equals("-")) {
								result -= Integer.valueOf(subset.get(j));
							}

							if (subset.get(j - 1).equals("+")) {
								result += Integer.valueOf(subset.get(j));
							}
						}
						result += Integer.valueOf(subset.get(0));
					}
					stack.push(String.valueOf(result));
				}
			}
		}
	 
		List<String> subset = new ArrayList<String>();
		while (!stack.isEmpty()) {
			String element = stack.pop();
			subset.add(0, element);
		}

		int result = 0;
		for (int i = subset.size() - 1; i > 0; i = i - 2) {
			if (subset.get(i - 1).equals("-")) {
				result -= Integer.valueOf(subset.get(i));
			}

			if (subset.get(i - 1).equals("+")) {
				result += Integer.valueOf(subset.get(i));
			}
		}
		result += Integer.valueOf(subset.get(0));
	 
		return result;
	}
	
	public static void main(String[] args){
		Problem224_BasicCalculator calculator = new Problem224_BasicCalculator();
		String s = "((11+4)+(5+2))-(3-(6+8))";
		System.out.println(calculator.calculate(s));
	}
}
