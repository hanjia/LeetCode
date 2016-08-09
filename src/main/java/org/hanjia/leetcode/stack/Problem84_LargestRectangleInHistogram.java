package org.hanjia.leetcode.stack;

import java.util.Stack;

/**
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 * 
 * @author hanjia
 *
 */
public class Problem84_LargestRectangleInHistogram {
	
	public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int current = (i == heights.length) ? -1 : heights[i]; // 当前bar
            while (!stack.isEmpty() && current <= heights[stack.peek()]) { //如果当前bar的高度小于栈顶bar
                int height = heights[stack.pop()]; // 我们pop出栈顶的bar，同时以该bar作为计算矩形面积的高
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1; //rn是当前遍历到的bar的index，而ln则是当前的栈顶bar的index
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        
        return max;
	}
	
    public int largestRectangleAreaBruteForce(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            int j = i, k = i;
            while (j > 0 && heights[i] <= heights[j - 1]) {
                j--;
            }
            while (k < heights.length - 1 && heights[i] <= heights[k + 1]) {
                k++;
            }
            int result = (k - j + 1) * heights[i];
            max = Math.max(max, result);
        }
        return max;
    }
    
    public static void main(String[] args) {
    	Problem84_LargestRectangleInHistogram largestRectangle = new Problem84_LargestRectangleInHistogram();
    	int[] array = {2,1,5,6,2,3};
    	System.out.println(largestRectangle.largestRectangleArea(array));
    	System.out.println(largestRectangle.largestRectangleAreaBruteForce(array));

    }
}
