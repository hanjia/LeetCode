package org.hanjia.leetcode.tree;

public class Problem111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) { // If one subtree is null, we cannot return 0 but the depth of the other subtree
            return left > right ? left + 1: right + 1;
        }
        return 1 + Math.min(left, right);
    }
}
