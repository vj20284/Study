package com.practise.geeks4geeks.dynamicprogramming;

import com.practise.tree.TreeNode;
/**
 * Let LISS(X) indicates size of largest independent set of a tree with root X.

     LISS(X) = MAX { (1 + sum of LISS for all grandchildren of X),
                     (sum of LISS for all children of X) }
 * @author vivek
 *
 */
public class LargestIndependentSet {
	public int largestIndependentSet(TreeNode root) {
		return helper(root);
	}
	
	public int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int lisExcl = helper(node.left) + helper(node.right);
		int lisIncl = 1;
		if (node.left != null) 
			lisIncl += helper(node.left.left) + helper(node.left.right);
		if (node.right != null) 
			lisIncl += helper(node.right.left) + helper(node.right.right);
		
		return Math.max(lisExcl, lisIncl);
	}
}
