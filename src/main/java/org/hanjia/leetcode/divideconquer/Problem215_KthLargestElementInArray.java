package org.hanjia.leetcode.divideconquer;

/**
 * 
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author hanjia
 *
 */
public class Problem215_KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {      
    	return divideAndConquer(nums, 0, nums.length - 1, k);
    }
    
    public int divideAndConquer(int[] array, int first, int last, int k) {
    	if (first < last) {
    		int pivot = partition(array, first, last);
    		int length = last - pivot + 1;
    		if (length > k) {
    			return divideAndConquer(array, pivot + 1, last, k);
    		} else if (length < k) {
    			return divideAndConquer(array, first, pivot - 1, k - length);
    		} else {
    			return array[pivot];
    		}
    	}
    	return array[first];
    }
    
    public int partition(int[] array, int first, int last) {
    	int pivotValue = array[first];
    	int low = first + 1;
    	int high = last;
    	while (low < high) {
    		while (low <= high && array[low] <= pivotValue) {
    			low++;
    		}   		
    		while (low <= high && array[high] > pivotValue) {
    			high--;
    		}
    		
    		if (low < high) {
    			int temp = array[low];
    			array[low] = array[high];
    			array[high] = temp;
    		}
    	}
    	
    	while (high > low && array[high] > pivotValue) {
    		high--;
    	}
    	
    	if (pivotValue > array[high]) {
    		array[first] = array[high];
    		array[high] = pivotValue;
    		return high;
    	}
    	return first;
    }
    
	public static void main(String[] args){
		int[] array1 = {5, 3, 4, 1, 7, 8 ,2, 9, 0, 6};
		int[] array2 = {2, 1};
		Problem215_KthLargestElementInArray findK = new Problem215_KthLargestElementInArray();
		System.out.println(findK.findKthLargest(array1, 2));
		System.out.println(findK.findKthLargest(array2, 2));

	} 
}
