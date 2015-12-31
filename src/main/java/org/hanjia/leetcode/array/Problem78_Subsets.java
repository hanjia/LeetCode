package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 * 
 * @author hanjia
 *
 */
public class Problem78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null)
        	return null;
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        helper(nums, nums.length - 1, result, item);
        return result;
    }
    
    public void helper(int[] num, int index, List<List<Integer>> result, List<Integer> item){
    	if(index == -1){
    		item = new ArrayList<Integer>();
    		result.add(item);
    		return;
    	}
    	helper(num, index - 1, result, item);
    	int size = result.size();  
        for(int i = 0;i < size; i++){
        	item = new ArrayList<Integer>(result.get(i)); 
        	item.add(num[index]);
        	result.add(item);
        }
    }
    
    public static void main(String[] args){
    	int[] nums = {1, 2, 3, 4};
    	Problem78_Subsets subsets = new Problem78_Subsets();
    	System.out.println(subsets.subsets(nums));
    }
}
