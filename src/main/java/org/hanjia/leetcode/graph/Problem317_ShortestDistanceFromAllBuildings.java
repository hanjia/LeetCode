package org.hanjia.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. 
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * 
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * 
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 * 
 * @author hajia
 *
 */
public class Problem317_ShortestDistanceFromAllBuildings {
	
	private final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	// BFS solution
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int rows = grid.length;
        int columns = grid[0].length;        
        int[][] reach = new int[rows][columns];
        int[][] distance = new int[rows][columns];
        int numBuildings = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
         
        // Find the minimum distance from all buildings
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[rows][columns];
                    shortestDistanceHelper(i, j, 0, grid, reach, distance, visited, queue);
                    numBuildings++;
                }
            }
        }
         
        // Check the min distance reachable by all buildings
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0 && reach[i][j] == numBuildings && distance[i][j] < minDistance) {
                    minDistance = distance[i][j];
                }
            }
        }
         
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }       
        return minDistance;
    }
    
	private void shortestDistanceHelper(int row, int col, int dist, int[][] grid, int[][] reach, int[][] minDistance, boolean[][] visited, Queue<Integer> queue) {
		fill(row, col, dist, grid, reach, minDistance, visited, queue);

		int columns = grid[0].length;
		while (!queue.isEmpty()) {
			dist++;
			int sz = queue.size();
			for (int j = 0; j < sz; j++) {
				int cord = queue.poll();
				int x = cord / columns;
				int y = cord % columns;
				for (int i = 0; i < 4; i++) {
					fill(dir[i][0] + x, dir[i][1] + y, dist, grid, reach, minDistance, visited, queue);
				}
			}
		}
	}

	private void fill(int row, int col, int dist, int[][] grid, int[][] reach, int[][] minDistance, boolean[][] visited, Queue<Integer> queue) {
		int rows = grid.length;
		int columns = grid[0].length;

		if (row < 0 || row >= rows || col < 0 || col >= columns || visited[row][col] || grid[row][col] == 2) {
			return;
		}

		// We need to handle the starting building separately
		if (dist != 0 && grid[row][col] == 1) {
			return;
		}

		visited[row][col] = true;
		minDistance[row][col] += dist;
		reach[row][col] += 1;
		queue.offer(row * columns + col);
	}
	
	// TODO: add tests
}
