package org.hanjia.leetcode.dpdq;

/**
 * 
Problem 4: 
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Algorithm:
 * 
 * @author hanjia
 *
 */
public class Problem4_MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int A[], int B[]) {
	        int m = A.length;
	        int n = B.length;
	        int total = A.length + B.length;  
	        if (total%2 != 0)
	            return (double)findKth(A, 0, m-1, B, 0, n-1, total/2 + 1);
	        else {
	            return (double)(findKth(A, 0, m-1, B, 0, n-1, total/2) + findKth(A, 0, m-1, B, 0, n-1, total/2 + 1))/2;
	        }
	}
	
	public int findKth(int a[], int astart, int aend, int b[], int bstart, int bend, int k)  {  
			int m = aend - astart + 1;
			int n = bend - bstart + 1;
		    
			if(m>n)
				return findKth(b,bstart,bend,a,astart,aend,k);
			if(m==0)
				return b[k-1];
			if(k==1)
				return Math.min(a[astart],b[bstart]);
	   
			int partA = Math.min(k/2,m);
			int partB = k - partA;
			
			if(a[astart+partA-1] < b[bstart+partB-1])
				return findKth(a,astart+partA,aend,b,bstart,bend,k-partA);
			else if(a[astart+partA-1] > b[bstart+partB-1])
				return findKth(a,astart,aend,b,bstart+partB,bend,k-partB);
			else
				return a[astart+partA-1];
	}	
	
}