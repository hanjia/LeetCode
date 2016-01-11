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
        if (root == null) {
        	return result;
        }
        List<Integer> items = new ArrayList<Integer>();
        items.add(root.val);
        pathSum(root, sum - root.val, items, result);
        return result;
    }
    
	public void pathSum(TreeNode root, int target, List<Integer> items, List<List<Integer>> result) {
		if (root.left == null && root.right == null && target == 0) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(items);
			result.add(temp);
		}

		if (root.left != null) { // search path of left node
			int leftValue = root.left.val;
			items.add(leftValue);
			pathSum(root.left, target - leftValue, items, result);
			items.remove(items.size() - 1);
		}

		if (root.right != null) { // search path of right node
			int rightValue = root.right.val;
			items.add(rightValue);
			pathSum(root.right, target - rightValue, items, result);
			items.remove(items.size() - 1);
		}
	}
}
