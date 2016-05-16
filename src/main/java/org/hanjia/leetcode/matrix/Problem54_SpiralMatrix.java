package org.hanjia.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * 
 * For example,
 * Given the following matrix:
 * [
 	[ 1, 2, 3 ],
 	[ 4, 5, 6 ],
 	[ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author hanjia
 *
 */
public class Problem54_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) 
        	return result;
 
        int column = matrix.length;
        int row = matrix[0].length;
 
        int x = 0; 
        int y = 0;
 
		while (column > 0 && row > 0) {
			// if one row/column left, no circle can be formed
			if (column == 1) {
				for (int i = 0; i < row; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			} else if (row == 1) {
				for (int i = 0; i < column; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}

			// process in a circle
			for (int i = 0; i < row - 1; i++) { // top: move right 1 -> 2
				result.add(matrix[x][y++]);
			}

			for (int i = 0; i < column - 1; i++) {	// right: move down 3 -> 6
				result.add(matrix[x++][y]);
			}

			for (int i = 0; i < row - 1; i++) { // bottom: move left 9 -> 8
				result.add(matrix[x][y--]);
			}
			
			for (int i = 0; i < column - 1; i++) { // left: move up 7 -> 4
				result.add(matrix[x--][y]);
			}

			// finish one circle then move inside
			x++;
			y++;
			// important: minus by 2
			column = column - 2;
			row = row - 2;
		}
 
        return result;
    }
    
    public static void main(String[] args){
    	
    }
}
