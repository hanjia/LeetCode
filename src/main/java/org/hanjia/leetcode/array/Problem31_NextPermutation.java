package org.hanjia.leetcode.array;

/**
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * 
 * @author hanjia
 *
 */
public class Problem31_NextPermutation {
    public void nextPermutation(int[] nums) {
    	int p = 0; // Find the first element that is less than its previous one
    	for(int i = nums.length - 2 ; i >= 0; i--){
    		if(nums[i] < nums[i+1]){
    			p = i;
    			break;
    		}
    	}
    	
    	int q = 0; // Find the first element that is greater than p
    	for(int j = nums.length -1 ; j >= 0; j--){
    		if(nums[j] > nums[p]){
    			q = j;
    			break;
    		}
    	}
    	
    	if(p == 0 && q == 0){
    		reverse(nums, 0, nums.length - 1);
    		return;
    	}
    	
    	//Swap p and q
    	int temp = nums[p];
    	nums[p] = nums[q];
    	nums[q] = temp;
    	
    	// Reverse from p to the end
    	if(p < nums.length - 1){
    		reverse(nums, p + 1, nums.length - 1);
    	}
    	    	
    }
    
    public static void reverse(int[] nums, int start, int end){
    	while(end > start){
    		int temp = nums[end];
    		nums[end] = nums[start];
    		nums[start] = temp;
    		end--;
    		start++;
    	}
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,4,3};
    	Problem31_NextPermutation nextPerm = new Problem31_NextPermutation();
    	nextPerm.nextPermutation(nums);
    	for(int num : nums) {
    		System.out.println(num);
    	}
    }
}
