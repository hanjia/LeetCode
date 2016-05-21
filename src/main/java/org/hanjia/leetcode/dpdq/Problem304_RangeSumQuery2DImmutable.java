package org.hanjia.leetcode.dpdq;

/**
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) 
 * and lower right corner (row2, col2).
 * 
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * 
 * Example:
 * Given matrix = [
	  [3, 0, 1, 4, 2],
	  [5, 6, 3, 2, 1],
	  [1, 2, 0, 1, 5],
	  [4, 1, 0, 1, 7],
	  [1, 0, 3, 0, 5]
	]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * 
 * 
 * @author hajia
 *
 */
public class Problem304_RangeSumQuery2DImmutable {
	public static void main(String[] args){
		int[][] matrix = {{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4},{5,5,5,5,5}};
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(0, 0, 0, 1));
	}
}

// Brute force – O(mn) time per query, O(1) space
/**
class NumMatrix {
	private int[][] data;

	public NumMatrix(int[][] matrix) {
	    data = matrix;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
	    int sum = 0;
	    for (int r = row1; r <= row2; r++) {
	        for (int c = col1; c <= col2; c++) {
	            sum += data[r][c];
	        }
	    }
	    return sum;
	}
}
**/

// Caching smarter – O(1) time per query, O(mn) space
// sums(ABCD) = sums(OD) - sums(OB) - sums(OC) + sums(OA)
class NumMatrix {
	private int[][] sums;

	public NumMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
            return;
        }
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		sums = new int[rows + 1][columns + 1];

	    for (int i = 1; i <= rows; i++) {
	    	for (int j = 1; j <= columns; j++) {
	    		sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + matrix[i-1][j-1];
	    	}
	    }
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
	}
}
