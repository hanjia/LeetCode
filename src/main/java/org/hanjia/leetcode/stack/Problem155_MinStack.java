package org.hanjia.leetcode.stack;

import java.util.Stack;

/**
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem155_MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Two stacks solution
    public Problem155_MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int value) {  
        // store current min value into minStack  
        if (minStack.isEmpty() || value <= minStack.peek())  
            minStack.push(value);  
        stack.push(value);  
    }  
  
    public void pop() {  
        // compare the value of two objects , if equal, pop both of them  
        if (stack.peek().equals(minStack.peek()))  
            minStack.pop();  
        stack.pop();  
    }  
  
    public int top() {  
        return stack.peek();  
    }  
  
    public int getMin() {  
        return minStack.peek();  
    } 
    
    public static void main(String[] args) {
    	Problem155_MinStack minStack = new Problem155_MinStack();
    	minStack.push(6);
    	minStack.push(5);
    	minStack.push(3);
    	minStack.push(8);
    	System.out.println(minStack.getMin());
    	minStack.pop();
    	minStack.pop();
    	System.out.println(minStack.getMin());
    }
}
