package com.practise.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	
	private static Map<Node, Node> nodeMap = new HashMap<Node, Node>();
	
	public Node clone(Node root) {
		if (root == null)
			return null;
		nodeMap.put(root, new Node(root.data));
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			Node node = nodes.remove();
			for (Node curNbr : node.neighbors) {
				if (nodeMap.get(curNbr) == null) { // current neighbor doesn't exist in map
					Node newNode = new Node(curNbr.data);
					nodeMap.get(node).neighbors.add(newNode);
					nodeMap.put(curNbr, newNode);
					nodes.add(curNbr);
				}
				else {  // current nbr exists in map
					nodeMap.get(node).neighbors.add(nodeMap.get(curNbr));
				}
			}
		}
		return nodeMap.get(root);
	}
	
	class Node {
		int data;
		ArrayList<Node> neighbors;
		
		public Node(int i) {
			this.data = i;
		}
	}
}
