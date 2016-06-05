package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
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
	public List<List<Integer>> permuteUniqueIterativeSolution(int[] nums) {	
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < nums.length; i++) {
			Set<List<Integer>> currentSet = new HashSet<List<Integer>>();
			for (List<Integer> list : result) {
				for (int j = 0; j <= list.size(); j++) {
					list.add(j, nums[i]);
					List<Integer> temp = new ArrayList<Integer>(list);
					list.remove(j);
					currentSet.add(temp);
				}
			}
			result = new ArrayList<List<Integer>>(currentSet);
		}
	 
		return result;
	}
	
	public List<List<Integer>> permuteUniqueRecursiveSolution(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return result;
		
        List<Integer> current = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];        
        Arrays.sort(nums);

        dfs(result, current,  nums, visited);
		return result;
	}
	
	public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }    
            
            if((i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) { // For case 1,2,2,3, i reaches the second 2. To avoid generating 1,2,2 again 
            	continue;
            }
            
            visited[i] = true;
            list.add(nums[i]);           
            dfs(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }  
	
	public static void main(String[] args){
		int[] array = {1,2,2,3};
		Problem47_Permutation2 permutation = new Problem47_Permutation2();
		List<List<Integer>> result = permutation.permuteUniqueRecursiveSolution(array);
		System.out.println(result);
	    result = permutation.permuteUniqueIterativeSolution(array);
		System.out.println(result);
	}

}
