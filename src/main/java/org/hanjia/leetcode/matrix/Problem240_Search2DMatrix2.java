package org.hanjia.leetcode.matrix;

/**
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * For example,
 * Consider the following matrix:
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
 * Given target = 5, return true.
 * 
 * Given target = 20, return false.
 * 
 * @author hanjia
 *
 */
public class Problem240_Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        // starting from top right corner
        int x = 0;
        int y = column - 1;
        
        // staircase walk
        while (x <= row - 1 && y >= 0) {
        	if (matrix[x][y] == target){
        		return true;
        	} else if (matrix[x][y] > target) {
        		y--;
        	} else {
        		x++;
        	}
        }     
        return false;
    }
}
