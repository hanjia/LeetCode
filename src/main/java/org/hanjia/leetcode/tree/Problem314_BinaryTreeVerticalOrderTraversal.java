package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * 
 * Examples:
 * Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
 * return its vertical order traversal as:
	[
	  [9],
	  [3,15],
	  [20],
	  [7]
	]
 *  Given binary tree [3,9,20,4,5,2,7],
	    _3_
	   /   \
	  9    20
	 / \   / \
	4   5 2   7
 * return its vertical order traversal as:
	[
	  [4],
	  [9],
	  [3,5,2],
	  [20],
	  [7]
	]
 * 
 * 
 * @author hanjia
 *
 */
public class Problem314_BinaryTreeVerticalOrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		
		Queue<TreeColumnNode> queue = new LinkedList<TreeColumnNode>();
		Map<Integer, List<Integer>> map= new HashMap<Integer, List<Integer>>(); // Use a map to store column list
		queue.offer(new TreeColumnNode(root,0));
		int min = 0;
		int max = 0;
		
		while(!queue.isEmpty()) { // Level Order Traversal            
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {            	
    			TreeColumnNode current = queue.poll();
                if(map.containsKey(current.column)) {
                    map.get(current.column).add(current.node.val);
                } else {
                	List<Integer> columnList = new ArrayList<Integer>();
                	columnList.add(current.node.val);
                    map.put(current.column, columnList);
                }
                
	            if(current.node.left != null) {
	                queue.offer(new TreeColumnNode(current.node.left, current.column - 1));
	                min = Math.min(current.column - 1, min);
	            }
	            
	            if(current.node.right != null) {
	                queue.offer(new TreeColumnNode(current.node.right, current.column + 1));
	                max = Math.max(current.column + 1, max);
	            }
            }
        }
        
        for(int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
		
		return result;
	}
	
	
	class TreeColumnNode{
        public TreeNode node;
        public int column;
        public TreeColumnNode(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.left.left.left = new TreeNode(1);
		root.right.right.left = new TreeNode(7);
		Problem314_BinaryTreeVerticalOrderTraversal verticalOrder = new Problem314_BinaryTreeVerticalOrderTraversal();
		List<List<Integer>> result = verticalOrder.verticalOrder(root);
		System.out.println(result);
	}
}
