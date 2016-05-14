package org.hanjia.leetcode.tree;

/**
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

	        _______3______
	       /              \
	    ___5__          ___1__
	   /      \        /      \
	   6      _2       0       8
	         /  \
	         7   4
 * 
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * 
 * @author hanjia
 *
 */
public class Problem236_LowestCommonAncestorOfABinaryTree {
	//Pre-order traversal	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == null)
	    	return null;
	    
	    // If any of the given nodes matches with root, then root is LCA (assuming that both keys are present). 
	    if (root == p || root == q)
	        return root;
	    
		// If root doesn’t match with any of the target nodes, we recur for left and right subtree. 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

    	// The node is the LCA which has one target present in its left subtree and the other target present in right subtree. 
	    if (left != null && right != null) {
	        return root;
	    }
		// If both targets lie in left subtree, then left subtree has LCA, otherwise LCA lies in right subtree.
	    if (left == null) {
	        return right;
	    }
	    if (right == null) {
	        return left;
	    }
	    
	    return null;
	}
}
