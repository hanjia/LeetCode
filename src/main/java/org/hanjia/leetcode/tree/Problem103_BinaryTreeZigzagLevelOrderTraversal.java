package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
 * 
 * 
 * @author hanjia
 *
 */
public class Problem103_BinaryTreeZigzagLevelOrderTraversal {
	
	//BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        int level = 1;
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        currentLevel.push(root);
    	
        while (!currentLevel.isEmpty()) {
        	List<Integer> currentLevelResult = new ArrayList<Integer>();
        	
        	while (!currentLevel.isEmpty()) {
        		TreeNode node = currentLevel.pop();
        		currentLevelResult.add(node.val);
        		
        		if (level % 2 == 1) { // Normal order
        			if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
        		} else { // Reverse order
        			if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
        		}
        	}
        	
        	result.add(currentLevelResult);
        	currentLevel = nextLevel;
        	nextLevel = new Stack<TreeNode>();
        	level++;
        }
        
        return result;
    }
}
