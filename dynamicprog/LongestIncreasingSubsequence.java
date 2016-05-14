package com.practise.dynamicprog;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class LongestIncreasingSubsequence {
	private static int[] LCS;
	
	public static List<Integer> longestIncreasingSubsequence(int[] input, int n) {
		LCS = new int[n];
		Stack<Integer> retList = new Stack<Integer>();
		int max = 0;
		for (int k = 0; k < n; k++) {
			max = 0;
			for (int j = 0; j < k; j++) {
				if (input[k] > input[j]) {
					if (LCS[j] > max) {
						max = LCS[j];
					}
				}
			}
			LCS[k] = max + 1;
		}
		max = 0;
		for (int i = 0; i < n; i++) {
			if (LCS[i] > max) 
				max = LCS[i];
		}
		for (int i = n - 1; i >= 0; i--) {
			if (LCS[i] == max) {
				retList.push(input[i]);
				max = max - 1;
			}
		}
		List<Integer> ret = new ArrayList<Integer>();
		while(!retList.empty()) {
			ret.add(retList.pop());
		}
		return ret;
	}
}

// 5 2 8 6 3 6 9 7
// 2 3 6 9
// LCS
// LCS(0) 1
// prev 
// LCS(1) = LCS(0) = 1 
// LCS(2) = 
