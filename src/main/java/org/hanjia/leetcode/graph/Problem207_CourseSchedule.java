package org.hanjia.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * 
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * 
 * There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. 
 * So it is impossible.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem207_CourseSchedule {
	// BFS solution
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }
     
        int length = prerequisites.length;
     
        if(numCourses == 0 || length == 0){
            return true;
        }
     
        // counter for number of prerequisites
		int[] inDegrees = new int[numCourses];
		for (int i = 0; i < length; i++) {
			inDegrees[prerequisites[i][0]]++;
		}
     
        //store courses that have no prerequisites
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegrees[i] == 0) {
				queue.add(i);
			}
		}
     
        // number of courses that have no prerequisites
        int numNoPre = queue.size();     
		while (!queue.isEmpty()) {
			int top = queue.remove();
			for (int i = 0; i < length; i++) {
				// if a course's prerequisite can be satisfied by a course in queue
				if (prerequisites[i][1] == top) {
					inDegrees[prerequisites[i][0]]--;
					if (inDegrees[prerequisites[i][0]] == 0) {
						numNoPre++;
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}
     
        return (numNoPre == numCourses);
    }
    // TODO: add tests
}
