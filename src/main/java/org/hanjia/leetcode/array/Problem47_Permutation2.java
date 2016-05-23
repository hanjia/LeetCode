package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * @author hanjia
 *
 */
public class Problem47_Permutation2 {
	public static List<List<Integer>> permuteUniqueIterativeSolution(int[] nums) {	
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		returnList.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < nums.length; i++) {
			Set<List<Integer>> currentSet = new HashSet<List<Integer>>();
			for (List<Integer> list : returnList) {
				for (int j = 0; j < list.size() + 1; j++) {
					list.add(j, nums[i]);
					List<Integer> temp = new ArrayList<Integer>(list);
					list.remove(j);
					currentSet.add(temp);
				}
			}
			returnList = new ArrayList<List<Integer>>(currentSet);
		}
	 
		return returnList;
	}
	
	public static List<List<Integer>> permuteUniqueRecursiveSolution(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permuteUnique(nums, 0, result);
		return result;
	}
	
	private static void permuteUnique(int[] nums, int start, List<List<Integer>> result) {		 
		if (start >= nums.length) {
			List<Integer> item = convertArrayToList(nums);
			result.add(item);
		}
	 
		for (int j = start; j <= nums.length-1; j++) {
			if (containsDuplicate(nums, start, j)) {
				swap(nums, start, j);
				permuteUnique(nums, start + 1, result);
				swap(nums, start, j);
			}
		}
	}
	 
	private static List<Integer> convertArrayToList(int[] nums) {
		List<Integer> item = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			item.add(nums[i]);
		}
		return item;
	}
	 
	private static boolean containsDuplicate(int[] array, int start, int end) {
		for (int i = start; i <= end-1; i++) {
			if (array[i] == array[end]) {
				return false;
			}
		}
		return true;
	}
	 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
