package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 * 
 * 
 * @author hanjia
 *
 */
public class Problem95_UniqueBinarySearchTrees2 {
	public List<TreeNode> generateTrees(int n) {
	    if(n < 1){
	        return new ArrayList<TreeNode>();
	    }else{
	    	return generateTrees(1, n);
	    }
	}
	
	public List<TreeNode> generateTrees(int start, int end) {
	    List<TreeNode> list = new ArrayList<TreeNode>();
	    if (start > end) {
	        list.add(null);
	        return list;
	    }
	 
	    for (int i = start; i <= end; i++) {
	        List<TreeNode> lefts = generateTrees(start, i - 1);
	        List<TreeNode> rights = generateTrees(i + 1, end);
	        for (TreeNode left : lefts) {
	            for (TreeNode right : rights) {
	                TreeNode node = new TreeNode(i);
	                node.left = left;
	                node.right = right;
	                list.add(node);
	            }
	        }
	    }	 
	    return list;
	}
}
