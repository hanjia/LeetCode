package org.hanjia.leetcode.tree;

/**
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * @author hanjia
 *
 */
public class Problem112_PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		   return pathSum(root, 0, sum); 
		}

		private boolean pathSum(TreeNode root, int sum, int target) {
		    if (root == null) {
		        return false;
		    }
		    sum += root.val;
		    if (root.left == null && root.right == null) {
		        if (sum == target) {
		            return true;
		        } else {
		            return false;
		        }
		    }
		    return pathSum(root.left, sum, target) || pathSum(root.right, sum, target);
		}
}
