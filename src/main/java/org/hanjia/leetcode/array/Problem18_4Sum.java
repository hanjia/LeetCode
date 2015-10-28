package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 *   (-1,  0, 0, 1)
 *   (-2, -1, 1, 2)
 *   (-2,  0, 0, 2)
 * @author hajia
 *
 */

public class Problem18_4Sum {
	
	public static void main(String[] args){
		int[] num = {1,2,3,4,5,6,7};
		int target = 18;
		System.out.println(fourSum(num,target));
	}
	
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	        //Create the dictionary.
	        HashMap<Integer, List<List<Integer>>> dict = new HashMap<Integer, List<List<Integer>>>();
	        for (int i = 0; i < nums.length - 1; i++) {
	            for (int j = i + 1; j < nums.length; j++) {
	                int sum = nums[i] + nums[j];
	                List<Integer> pair = new ArrayList<Integer>(2);
	                pair.add(i);
	                pair.add(j);
	                if (!dict.containsKey(sum)) {
	                    List<List<Integer>> value = new ArrayList<List<Integer>>();
	                    value.add(pair);
	                    dict.put(sum, value);
	                } else {
	                    List<List<Integer>> value = dict.get(sum);
	                    value.add(pair);
	                }
	            }
	        }
	        //Use HashSet to prevent duplicate result.
	        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
	        for (Integer sum : dict.keySet()) {
	            List<List<Integer>> sumPair = dict.get(sum);
	            if (dict.containsKey(target - sum)) {
	                if (target - sum == sum && sumPair.size() == 1)
	                    continue;
	                List<List<Integer>> pairs = dict.get(target - sum);
	                for (List<Integer> pair1 : sumPair) {
	                    for (List<Integer> pair2 : pairs) {
	                        //Make sure it is not the same pair.
	                        if (pair1 == pair2)
	                            continue;
	                        //Make sure there is no same element in two pairs.
	                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1)))
	                            continue;
	                        ArrayList<Integer> tmpResult = new ArrayList<Integer>(4);
	                        tmpResult.add(nums[pair1.get(0)]);
	                        tmpResult.add(nums[pair1.get(1)]);
	                        tmpResult.add(nums[pair2.get(0)]);
	                        tmpResult.add(nums[pair2.get(1)]);
	                        //Sort the list and add it into the set.
	                        Collections.sort(tmpResult);
	                        set.add(tmpResult);
	                    }
	                }
	            }
	        }
	        List<List<Integer>> ret = new LinkedList<List<Integer>>();
	        ret.addAll(set);
	        return ret;
	    }
}
