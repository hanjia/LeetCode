package org.hanjia.leetcode.matrix;

/**
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @author hanjia
 *
 */
public class Problem79_WordSearch {
	public boolean exist(char[][] board, String word) {
	    int rows = board.length;
	    int columns = board[0].length;
	 
	    for(int i = 0; i < rows; i++){
	        for(int j = 0; j < columns; j++){
	           if(dfs(board, word, i, j, 0)){
	               return true;
	           }
	        }
	    }	 
	    return false;
	}
	 
	public boolean dfs(char[][] board, String word, int i, int j, int wordIndex) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}

		if (board[i][j] == word.charAt(wordIndex)) {
			char temp = board[i][j];
			board[i][j] = '#'; // Override the value to avoid moving back to the same element in the future
			
			if (wordIndex == word.length() - 1) {
				return true;
			} else if (dfs(board, word, i - 1, j, wordIndex + 1)
					|| dfs(board, word, i + 1, j, wordIndex + 1)
					|| dfs(board, word, i, j - 1, wordIndex + 1)
					|| dfs(board, word, i, j + 1, wordIndex + 1)) {
				return true;
			}
			board[i][j] = temp;
		}
		return false;
	}
}
