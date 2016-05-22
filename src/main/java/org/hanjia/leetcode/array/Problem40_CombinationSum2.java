package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * @author hanjia
 *
 */
public class Problem40_CombinationSum2 {
	/**
	 * 
	 * Backtracking
	 * 
	 * @param num
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return result;

		Arrays.sort(num);
		List<Integer> current = new ArrayList<Integer>();
		getCombination(num, target, 0, current, result);

		// remove duplicate combinations
		Set<List<Integer>> set = new HashSet<List<Integer>>(result);
		result.clear();
		result.addAll(set);
		return result;
	}
	 
	public static void getCombination(int[] num, int target, int start, List<Integer> current, List<List<Integer>> result){
		if (target == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
	 
		for (int i = start; i < num.length; i++) {
			if (target < num[i])
				continue;
			current.add(num[i]);
			getCombination(num, target - num[i], i + 1, current, result); // Note that start is (i+1), because any element can only used for once 
			current.remove(current.size() - 1);
		}
	}
}
