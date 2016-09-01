package org.hanjia.leetcode.matrix;

/**
 * 
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * You may assume the following rules:
 *  A move is guaranteed to be valid and is placed on an empty block.
 *  Once a winning condition is reached, no more moves is allowed.
 * 	A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * 
 * Example:
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 * TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | | // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | | // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | | // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| | // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| | // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| | // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| | // Player 1 makes a move at (2, 1).
|X|X|X|
 * 
 * Follow up:
 * Could you do better than O(n2) per move() operation?
 * 
 * Hint:
 * 
 * Could you trade extra space such that move() operation can be done in O(1)?
 * You need two arrays: int rows[n], int cols[n], plus two variables: diagonal, anti_diagonal.
 * 
 * @author hanjia
 *
 */
public class Problem349_DesignTicTacToe {
	int[] rows;
	int[] cols;
	int diagnol;
	int reverseDiagnol;
	int n;
	
	public Problem349_DesignTicTacToe(int n) {
		this.n = n;
		rows = new int[n];
		cols = new int[n];
	}
	
	public int move(int row, int col, int player) {
		int add = (player == 1) ? 1 : -1;
		rows[row] += add;
		cols[col] += add;
		diagnol += ((row == col) ? add : 0);
		reverseDiagnol += ((row == n - col - 1) ? add : 0);
		return (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagnol) == n || Math.abs(reverseDiagnol) == n) ? player : 0;
	}
	
	public static void main(String[] args) {
		Problem349_DesignTicTacToe ticTacToe = new Problem349_DesignTicTacToe(3);
		System.out.println(ticTacToe.move(1, 1, 1));
		System.out.println(ticTacToe.move(1, 2, 2));
		System.out.println(ticTacToe.move(2, 1, 1));
		System.out.println(ticTacToe.move(2, 2, 2));
		System.out.println(ticTacToe.move(0, 2, 2));
	}
	
}