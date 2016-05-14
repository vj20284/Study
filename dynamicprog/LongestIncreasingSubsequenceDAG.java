package com.practise.dynamicprog;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.practise.graph.DAGVertex;
import com.practise.graph.DirectedAcyclicGraph;
import com.practise.graph.Edge;

public class LongestIncreasingSubsequenceDAG {
	private static int[] LCS;

	public static int longestIncreasingSubsequence(int[] input, int n) {
		List<Integer> retVal = new ArrayList<Integer>();
		DirectedAcyclicGraph dag = makeGraph(input);
		return findLongestPath(dag);
	}
	
	public static DirectedAcyclicGraph makeGraph(int[] input) {
		DirectedAcyclicGraph dag = new DirectedAcyclicGraph();
		for (int i = 0; i < input.length; i++) {
			int val = input[i];
			dag.addVertex("" + i, val);
		}
		for (int i = 0; i < input.length - 1; i++) {
			int val = input[i];
			for (int j = i + 1; j < input.length; j++) {
				int val2 = input[j];
				if (val2 > val) {
					dag.addEdge("" + i, "" + j, 1);
				}
			}
		}
		return dag;
	}
	
	//For each vertex v of the DAG, in the topological ordering, compute the length 
	//of the longest path ending at v by looking at its incoming neighbors and adding 
	//one to the maximum length recorded for those neighbors. If v has no incoming neighbors, 
	//set the length of the longest path ending at v to zero. In either case, record this number 
	//so that later steps of the algorithm can access it.
	public static int findLongestPath(DirectedAcyclicGraph dag) {
		int retVal = 0;
		int[] maxLt = new int[dag.getVertices().size()];
		for (DAGVertex v : dag.getVertices()) {
			Set<Edge> incomingNeighbors = v.getInEdges();
			int maxInLength = 0;
			for (Edge e : incomingNeighbors) {
				String inKey = e.getSrc().getKey();
				int lt = maxLt[Integer.parseInt(inKey)];
				if (lt > maxInLength)
					maxInLength = lt;
			}
			maxLt[Integer.parseInt(v.getKey())] = (incomingNeighbors.size() != 0) ?  maxInLength + 1 : 0;
		}
		for (int i = 0; i < maxLt.length; i++) {
			if (maxLt[i] > retVal) {
				retVal = maxLt[i];
			}
		}
		return retVal;
	}
} 