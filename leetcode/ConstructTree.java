package com.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.practise.ctci.GraphTreeUtils;
import com.practise.tree.Node;

public class ConstructTree {
	private Map<Integer, Integer> preorderMap = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
	
	public Node Construct(int[] preorder, int[] inorder) {
		Node head = null;
		for (int i = 0; i < preorder.length; i++) {
			preorderMap.put(preorder[i], i);
		}
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		head = Construct(preorder, inorder, 0, preorder.length - 1, preorder[0]);
		return head;
	}
	
	private Node Construct(int[] preOrder, int[] inOrder, int start, int end, int pivot) {
		Node pivotNode = new Node(pivot);
		if (start >= end) {
			return pivotNode;
		}
		int pivotIndex = inorderMap.get(pivot);
		int preorderPivotIndex = preorderMap.get(pivot);
		int leftPivot = pivotIndex - start > 0 ? preOrder[preorderPivotIndex + 1] : -1; // numLeft = pivotIndex - start
		int rightPivot = end - pivotIndex > 0 ? preOrder[preorderPivotIndex + (pivotIndex - start) + 1] : - 1;  // numRight = end - pivotIndex
		Node left = leftPivot != -1 ? Construct(preOrder, inOrder, start, pivotIndex - 1, leftPivot) : null;
		Node right = rightPivot != -1 ? Construct(preOrder, inOrder, pivotIndex + 1, end, rightPivot) : null;
		pivotNode.setLeft(left);
		pivotNode.setRight(right);
		return pivotNode;
	}
	
	public static void main(String[] args) {
		int[] preorder = new int[] {7, 10, 4, 3, 1, 2, 8, 11};
		int[] inorder = new int[] {4, 10, 3, 1, 7, 11, 8, 2};
		ConstructTree ct = new ConstructTree();
		Node head = ct.Construct(preorder, inorder);
		GraphTreeUtils.CreateLevelLinkedLists(head);
	}
}
