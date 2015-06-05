package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * @author hajia
 *
 */
public class Problem15_3Sum {
	public static void main(String[] args){
		int[] nums = {-3,-1,0,1,3};
		System.out.println(threeSum(nums));
	}
	
	
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if(nums==null || nums.length<=2)  
            return res;  
        Arrays.sort(nums);  //Sort first

        for(int i = 0; i < nums.length-2; i++){
        	
            if(i == 0 || nums[i] > nums[i - 1]){ //avoid duplicate solutions   
                int j = i + 1, 
                k = nums.length - 1;
         
                while(j < k){ 
                    if(nums[j] + nums[k] == -nums[i]){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        res.add(temp);
                        k--;
                        j++;
                        while(k > j && nums[k] == nums[k+1]) k--;//avoid duplicate solutions 

                        while(j < k && nums[j] == nums[j-1]) j++;//avoid duplicate solutions 

                    }else if(nums[j] + nums[k] > -nums[i]){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        
        return res;
    }
}
