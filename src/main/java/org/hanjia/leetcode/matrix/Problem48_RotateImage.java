package org.hanjia.leetcode.matrix;


/**
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author hanjia
 *
 */
public class Problem48_RotateImage {
    public static void rotate(int[][] matrix) {
        int length = matrix[0].length;
        
        //diagonal swap
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //upside down swap
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-1-j];
                matrix[i][length-1-j] = temp;
            }
        }
    }
}
