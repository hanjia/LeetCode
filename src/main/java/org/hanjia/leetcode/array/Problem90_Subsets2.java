package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,2], a solution is:
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 * 
 * 
 * @author hanjia
 *
 */
public class Problem90_Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        List<Integer> list = new ArrayList<Integer>();
        helper(num, 0, result, list);
        return result;
    }

    private void helper(int[] num, int start, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<Integer>(list));
        
		for (int i = start; i < num.length; i++) {
			if (i != start && num[i] == num[i - 1]) {
				continue;
			}
			list.add(num[i]);
			helper(num, i + 1, result, list);
			list.remove(list.size() - 1);
		}
    }
}
