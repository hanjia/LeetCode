package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
	   1
	 /   \
	2     3
	 \
	  5
 * All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 * 
 * 
 * @author hanjia
 *
 */
public class Problem257_BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        helper(root, String.valueOf(root.val), result);
        return result;
    }
    
	// pre-order traversal
	private void helper(TreeNode root, String path, List<String> result) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			result.add(path);
			return;
		}

		if (root.left != null) {
			helper(root.left, path + "->" + String.valueOf(root.left.val), result);
		}

		if (root.right != null) {
			helper(root.right, path + "->" + String.valueOf(root.right.val), result);
		}
	}
}
