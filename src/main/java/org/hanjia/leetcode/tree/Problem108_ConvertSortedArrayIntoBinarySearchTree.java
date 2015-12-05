package org.hanjia.leetcode.tree;

/**
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author hanjia
 *
 */
public class Problem108_ConvertSortedArrayIntoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
	    return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int[] a, int start, int end) {
	    if (start > end) {
	        return null;
	    }
	    int mid = start + (end - start) / 2;
	    TreeNode node = new TreeNode(a[mid]);
	    node.left = build(a, start, mid - 1);
	    node.right = build(a, mid + 1, end);
	    return node;
	}
}
