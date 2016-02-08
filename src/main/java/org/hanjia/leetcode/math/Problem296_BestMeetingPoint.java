package org.hanjia.leetcode.math;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * A group of two or more people wants to meet and minimize the total travel distance. 
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * For example, given three people living at (0,0), (0,4), and (2,2):
	1 - 0 - 0 - 0 - 1
	|   |   |   |   |
	0 - 0 - 0 - 0 - 0
	|   |   |   |   |
	0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem296_BestMeetingPoint {
	
	// Manhattan distance formula – O(m2n2) time
	// distance(p1,p2) = ∣p2.x − p1.x∣+∣p2.y − p1.y∣
	public int minTotalDistanceBruteForce(int[][] grid) {
	    List<Point> points = getAllPoints(grid);
	    int minDistance = Integer.MAX_VALUE;
	    for (int row = 0; row < grid.length; row++) {
	        for (int col = 0; col < grid[0].length; col++) {
	            int distance = calculateDistance(points, row, col);
	            minDistance = Math.min(distance, minDistance);
	        }
	    }
	    return minDistance;
	}

	private int calculateDistance(List<Point> points, int row, int col) {
	    int distance = 0;
	    for (Point point : points) {
	        distance += Math.abs(point.row - row) + Math.abs(point.col - col);
	    }
	    return distance;
	}

	private List<Point> getAllPoints(int[][] grid) {
	    List<Point> points = new ArrayList<Point>();
	    for (int row = 0; row < grid.length; row++) {
	        for (int col = 0; col < grid[0].length; col++) {
	            if (grid[row][col] == 1) {
	                points.add(new Point(row, col));
	            }
	        }
	    }
	    return points;
	}
	
	
	
	// Collect coordinates in sorted order – O(mn) time
    // We could use the Selection algorithm to select the median in O(mn)O(mn) time, but there is an easier way. 
	// Notice that we can collect both the row and column coordinates in sorted order.
	public int minTotalDistanceMedian(int[][] grid) {
	    List<Integer> rows = collectRows(grid);
	    List<Integer> cols = collectCols(grid);
	    int row = rows.get(rows.size() / 2);
	    int col = cols.get(cols.size() / 2);
	    return minDistance1D(rows, row) + minDistance1D(cols, col);
	}

	private int minDistance1D(List<Integer> points, int origin) {
	    int distance = 0;
	    for (int point : points) {
	        distance += Math.abs(point - origin);
	    }
	    return distance;
	}

	private List<Integer> collectRows(int[][] grid) {
	    List<Integer> rows = new ArrayList<Integer>();
	    for (int row = 0; row < grid.length; row++) {
	        for (int col = 0; col < grid[0].length; col++) {
	            if (grid[row][col] == 1) {
	                rows.add(row);
	            }
	        }
	    }
	    return rows;
	}

	private List<Integer> collectCols(int[][] grid) {
	    List<Integer> cols = new ArrayList<Integer>();
	    for (int col = 0; col < grid[0].length; col++) {
	        for (int row = 0; row < grid.length; row++) {
	            if (grid[row][col] == 1) {
	                cols.add(col);
	            }
	        }
	    }
	    return cols;
	}
	
	
	
	public class Point {
	    int row;
	    int col;
	    public Point(int row, int col) {
	        this.row = row;
	        this.col = col;
	    }
	}
}
