package org.hanjia.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * @author hanjia
 *
 */
public class Problem149_MaxPointsOnALine {
	public  int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }  

        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int max = 1;

        for(int i = 0 ; i < points.length; i++) {
            map.clear();

            /**
             * maybe all points contained in the list are same points, 
             * and same points' k is represented by Integer.MIN_VALUE
             *  
             */
            map.put((double)Integer.MIN_VALUE, 1);

            int duplicate = 0;
			for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                	duplicate++;
                    continue;
                }
                
                /**
                 * 
                 * Look at 0.0 + (double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                 * because (double) (0/-1) is -0.0, so we should use (0.0 + -0.0 = 0.0) to solve (0.0 != -0.0) problem
                 * 
                 * if the line through two points are parallel to y coordinator, 
                 * then K(slop) is Integer.MAX_VALUE
                 * 
                 */
                double key = (points[j].x - points[i].x == 0) ? 
                    Integer.MAX_VALUE :
                    0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }

            for (int temp: map.values()) {
                if (temp + duplicate > max) {   // duplicate may exist
                    max = temp + duplicate;
                }
            }

        }
        return max;
    }
	
	// TODO: add tests
}

class Point {
	int x;
	int y;
	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}