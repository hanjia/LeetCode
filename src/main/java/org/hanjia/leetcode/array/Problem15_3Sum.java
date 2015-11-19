package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * @author hanjia
 *
 */
public class Problem15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if(nums==null || nums.length<=2)  
            return res;  
        Arrays.sort(nums);  //Sort first

        for(int i = 0; i < nums.length-2; i++){
        	
            if(i == 0 || nums[i] > nums[i - 1]){ //avoid duplicate solutions   
                int start = i + 1, 
                end = nums.length - 1;
         
                while(start < end){ 
                    if(nums[start] + nums[end] == -nums[i]){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        res.add(temp);
                        end--;
                        start++;
                        while(end > start && nums[end] == nums[end+1]) {
                        	end--;//avoid duplicate solutions 
                        }

                        while(start < end && nums[start] == nums[start-1]) {
                        	start++;//avoid duplicate solutions                         
                        }

                    }else if(nums[start] + nums[end] > -nums[i]){
                    	end--;
                    }else{
                    	start++;
                    }
                }
            }
        }     
        return res;
    }
    
	public static void main(String[] args){
		int[] nums = {-3,-1,0,1,3};
		System.out.println(threeSum(nums));
	}
	
}
