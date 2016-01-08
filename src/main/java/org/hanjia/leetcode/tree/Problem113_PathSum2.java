package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
 * return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 * 
 * 
 * @author hanjia
 *
 */
public class Problem113_PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        List<Integer> items = new ArrayList<Integer>();
        pathSum(root, sum, items, result);
        return result;
    }
    
    private void pathSum(TreeNode root, int target, List<Integer> items, List<List<Integer>> result) {
//	    if (root == null) {
//	        return false;
//	    }
//	    sum += root.val;
//	    if (root.left == null && root.right == null) {
//	        if (sum == target) {
//	            return true;
//	        } else {
//	            return false;
//	        }
//	    }
    }
}
