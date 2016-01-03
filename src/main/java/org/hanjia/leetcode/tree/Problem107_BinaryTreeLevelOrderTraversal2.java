package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its bottom-up level order traversal as:
	[
	  [15,7],
	  [9,20],
	  [3]
	]
 * 
 * 
 * @author hajia
 *
 */
public class Problem107_BinaryTreeLevelOrderTraversal2 {
    //BFS Solution
	public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int currentLevelNodeNum = 1;
        int nextLevelNodeNum = 0;
        
        while (currentLevelNodeNum != 0) {
            List<Integer> levelResult = new ArrayList<Integer>();
            nextLevelNodeNum = 0;
            
            while (currentLevelNodeNum != 0) { // To make sure all the nodes at the same level are processed
                TreeNode node = queue.poll();
                currentLevelNodeNum--;
                levelResult.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelNodeNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelNodeNum++;
                }
            }
            result.add(0, levelResult);
            currentLevelNodeNum = nextLevelNodeNum;
        }
        return result;
    }
}
