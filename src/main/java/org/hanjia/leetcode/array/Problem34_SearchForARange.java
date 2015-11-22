package org.hanjia.leetcode.array;

import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author hanjia
 *
 */
public class Problem34_SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return null;
        
        int[] bound = new int[2];
        int left = 0;
        int right = nums.length - 1;
        bound[0] = -1; // In case there is no match
        bound[1] = -1;
        
        if(nums[left] == nums[right] && nums[left] == target){ // Special case!!
            bound[0] = left;
            bound[1] = right;
            return bound;
        }
        
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] == target){
                bound[0] = middle;
                bound[1] = middle;
                
                while(middle > 0){
                	if(nums[middle - 1] != target){
                		bound[0] = middle;
                		break;
                	}else{
                		bound[0] = middle - 1;
                	}
                	middle--;
                }
                
                while(middle < nums.length - 1){
                	if(nums[middle + 1] != target){
                		bound[1] = middle;
                		break;
                	}else{
                		bound[1] = middle + 1;
                	}
                	middle++;
                }
                break;
            }
            
            if(nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        
        return bound;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,3,4,5,5,6,6,7};
    	int target = 1;
    	System.out.println(Arrays.toString(searchRange(nums,target)));
    }
}
