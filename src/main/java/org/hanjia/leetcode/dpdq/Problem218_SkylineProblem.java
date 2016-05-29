package org.hanjia.leetcode.dpdq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. 
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), 
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 * 
 * 
 * Buildings  Skyline Contour
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, 
 * respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. 
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * The output is a list of "key points" (red dots in Figure B) in the format of 
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. 
 * A key point is the left endpoint of a horizontal line segment. Note that the last key point, 
 * where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. 
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * 
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * 
 * Notes:
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 * 
 * 
 * @author hanjia
 *
 */
public class Problem218_SkylineProblem {
	// Priority Queue Solution
	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }
        
        List<Height> heights = new ArrayList<Height>();
        for (int[] building : buildings) {
            heights.add(new Height(building[0], -building[2]));
            heights.add(new Height(building[1], building[2]));
        }
        
        Collections.sort(heights, new Comparator<Height>() {
            public int compare(Height h1, Height h2) {
                return h1.index != h2.index ? (h1.index - h2.index) : (h1.height - h2.height);
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
        pq.offer(0);
        int prev = 0;
        for (Height h : heights) {
            if (h.height < 0) {
                pq.offer(-h.height);
            } else {
                pq.remove(h.height);
            }
            int cur = pq.peek();
            if (cur != prev) {
                result.add(new int[]{h.index, cur});
                prev = cur;
            }
        }
        
        return result;
    }
	
	// Divide And Queuer
	public List<int[]> getSkylineDQ(int[][] buildings) {
		return drawSkylinesHelper(buildings, 0, buildings.length - 1);
	}
	
	public List<int[]> drawSkylinesHelper(int[][] buildings, int start, int end) {
		if (end - start >= 1) {
			int mid = (start + end) / 2;
			List<int[]> leftSkyline = drawSkylinesHelper(buildings, start, mid); // Half of the buildings
			List<int[]> rightSkyline = drawSkylinesHelper(buildings, mid + 1, end);
	        return mergeSkyline(leftSkyline, rightSkyline);
		} else { // Only one building left
            List<int[]> result = new ArrayList<int[]>();
			result.add(new int[] { buildings[start][0], buildings[start][2] });
			result.add(new int[] { buildings[start][1], 0 });
            return result;
        }
	}
	
	public List<int[]> mergeSkyline(List<int[]> left, List<int[]> right) {
		List<int[]> mergedList = new ArrayList<int[]>();
        int h1 = 0, h2 = 0;

        while (left.size() > 0 && right.size() > 0) {
            int x = 0, y = 0; // Coordinates for a meaningful point
            if (left.get(0)[0] < right.get(0)[0]) {
                x = left.get(0)[0];
                h1 = left.get(0)[1];
                y = Math.max(h1, h2);
                left.remove(0);
            } else if (left.get(0)[0] > right.get(0)[0]) {
                x = right.get(0)[0];
                h2 = right.get(0)[1];
                y = Math.max(h1, h2);
                right.remove(0);
            } else {
                x = left.get(0)[0];
                h1 =left.get(0)[1];
                h2 = right.get(0)[1];
                y = Math.max(h1, h2);
                left.remove(0);
                right.remove(0);
            }
            if (mergedList.size() == 0 || y != mergedList.get(mergedList.size() - 1)[1]) {
            	mergedList.add(new int[] { x, y });
            }
        }
        mergedList.addAll(left);
        mergedList.addAll(right);
        return mergedList;
	}
	
	public static void main(String[] args){
		int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
		Problem218_SkylineProblem skyline = new Problem218_SkylineProblem();
		List<int[]> results = skyline.getSkylineDQ(buildings);
		for (int[] result: results) {
			System.out.println(result[0] + "," + result[1]);
		}
	}
}

class Height {
    int index;
    int height;
    Height(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

class Building {
	int left, right, height;
}
