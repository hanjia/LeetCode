package org.hanjia.leetcode.array;


/**
 * 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * @author hanjia
 *
 */
public class Problem35_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
            
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] == target)
                return middle;
            if(nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return left;
    }
}
