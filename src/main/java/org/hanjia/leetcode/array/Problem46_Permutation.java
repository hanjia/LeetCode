package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author hanjia
 *
 */
public class Problem46_Permutation {
    public static List<List<Integer>> permuteIterativeSolution(int[] nums) {
        if(nums.length == 0)
        	return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
    	result.add(new ArrayList<Integer>());
    	
    	for(int i = 0; i < nums.length; i++){
    		List<List<Integer>> current = new ArrayList<List<Integer>>(); 
    		for(List<Integer> list : result){
    			for (int j = 0; j < list.size() + 1; j++) { // # of locations to insert is largest index + 1
    				list.add(j, nums[i]);
    				List<Integer> temp = new ArrayList<Integer>(list);
    				current.add(temp);
    				list.remove(j);
    			}
    		}
    		result = new ArrayList<List<Integer>>(current);
    	}
    	return result;
    }
    
    public static List<List<Integer>> permuteRecursiveSolution(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	permute(nums, 0, result);
    	return result;
    }
    
    public static void permute(int[] nums, int start, List<List<Integer>> result) {    	 
    	if (start >= nums.length) {
    		List<Integer> item = convertArrayToList(nums);
    		result.add(item);
    	}
     
    	for (int j = start; j <= nums.length - 1; j++) {
    		swap(nums, start, j);
    		permute(nums, start + 1, result);
    		swap(nums, start, j);
    	}
    }
    
    private static List<Integer> convertArrayToList(int[] nums) {
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		item.add(nums[i]);
    	}
    	return item;
    }
     
    private static void swap(int[] a, int i, int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,3};
    	System.out.println(permuteIterativeSolution(nums));
    	System.out.println(permuteRecursiveSolution(nums));
    }
}
