package org.hanjia.leetcode.matrix;

/**
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
 * 
 * @author hanjia
 *
 */
public class Problem59_SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
	    int total = n*n;
	    int[][] result = new int[n][n];
	 
	    int x = 0;
	    int y = 0;
	    int step = 0;
	 
	    for(int i = 0; i < total;){
	        while(y + step < n){
	            i++;
	            result[x][y]=i; 
	            y++;	 
	        }    
	        y--;
	        x++;
	 
	        while(x + step < n){
	            i++;
	            result[x][y]=i;
	            x++;
	        }
	        x--;
	        y--;
	 
	        while(y >= 0 + step){
	            i++;
	            result[x][y]=i;
	            y--;
	        }
	        y++;
	        x--;
	        step++;
	 
	        while(x >= 0 + step){
	            i++;
	            result[x][y]=i;
	            x--;
	        }
	        x++;
	        y++;
	    }
	 
	    return result;
	}
}
