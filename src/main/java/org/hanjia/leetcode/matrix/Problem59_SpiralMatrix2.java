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
		int total = n * n;
		int[][] result = new int[n][n];
	 
	    int x = 0;
	    int y = 0;
	    int step = 0;
	    int number = 0;
	    
		while (number < total) {
			while (y + step < n) { // Top 1 -> 2 -> 3
				number++;
				result[x][y] = number;
				y++;
			}
			y--;
			x++;

			while (x + step < n) { // Right 4 -> 5
				number++;
				result[x][y] = number;
				System.out.println(result[x][y]);
				x++;
			}
			x--;
			y--;

			while (y - step >= 0) { // Bottom 6 -> 7
				number++;
				result[x][y] = number;
				System.out.println(result[x][y]);
				y--;
			}
			y++;
			x--;
			step++;

			while (x - step >= 0) { // Left 8
				number++;
				result[x][y] = number;
				System.out.println(result[x][y]);
				x--;
			}
			x++;
			y++;
			System.out.println("left");
		}
	 
	    return result;
	}
	
	public static void main(String[] args) {
		Problem59_SpiralMatrix2 spiralMatrix = new Problem59_SpiralMatrix2();
		int[][] matrix = spiralMatrix.generateMatrix(3);
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				System.out.println(matrix[x][y]);
			}
		}
	}
}
