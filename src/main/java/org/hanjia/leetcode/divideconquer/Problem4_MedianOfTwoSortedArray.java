package org.hanjia.leetcode.divideconquer;

/**
 * 
 * Problem 4:
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Algorithm:
 * 
 * @author hanjia
 *
 */
public class Problem4_MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int[] A, int[] B) {
		int lengthA = A.length;
		int lengthB = B.length;
		int total = A.length + B.length;

		if (total % 2 != 0)
			return (double) findKth(A, 0, lengthA - 1, B, 0, lengthB - 1, total / 2 + 1);
		else {
			return (double) (findKth(A, 0, lengthA - 1, B, 0, lengthB - 1, total / 2) + findKth(A, 0, lengthA - 1, B, 0, lengthB - 1, total / 2 + 1)) / 2;
		}
	}
	
	/**
	 * Divide and Conquer
	 * 假设两个数组中位数为合并后第k小的元素，比较A[k/2 - 1] 与 B[k/2 - 1]
	 * 如果A[k/2 - 1] < B[k/2 - 1]则意味着A[0]到A[k/2 - 1]全部小于中位数，所以可以忽略A此部分, 而查找A的剩余部分与B[0]到B[k/2 - 1]
	 * 如果A[k/2 - 1] > B[k/2 - 1]则意味着B[0]到B[k/2 - 1]全部小于中位数，所以可以忽略B此部分, 而查找B的剩余部分与A[0]到A[k/2 - 1]
	 * 如果A[k/2 - 1] = B[k/2 - 1]则意味着已经找到中位数
	 * 
	 */
	
	public int findKth(int[] a, int startA, int endA, int[] b, int startB, int endB, int k)  {  
		int lengthA = endA - startA + 1;
		int lengthB = endB - startB + 1;

		if (lengthA == 0)
			return b[k - 1];
		if (k == 1)
			return Math.min(a[startA], b[startB]);

		if (lengthA > lengthB)
			return findKth(b, startB, endB, a, startA, endA, k);

		int partA = Math.min(k / 2, lengthB);
		int partB = k - partA;

		if (a[startA + partA - 1] < b[startB + partB - 1]) {
			return findKth(a, startA + partA, endA, b, startB, endB, k - partA);
		} else if (a[startA + partA - 1] > b[startB + partB - 1]) {
			return findKth(a, startA, endA, b, startB + partB, endB, k - partB);
		} else {
			return a[startA + partA - 1];
		}
	}	
	
	public static void main(String[] args) {
		int[] A = {1,3,5,7};
		int[] B = {2,4,6};
		Problem4_MedianOfTwoSortedArray sort = new Problem4_MedianOfTwoSortedArray();
		System.out.println(sort.findMedianSortedArrays(A, B));
	}
	
}
