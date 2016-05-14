package com.practise.dynamicprog;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class LongestIncreasingSubsequenceRec {
	private int[] LCS;
	
	public int longestIncreasingSubsequence(int[] input, int n) {
		LCS = new int[n];
		Stack<Integer> retList = new Stack<Integer>();
		int max = 0;
		int val = lcs (n - 1, input);
		System.out.println(val);
		return val;
	}
	
	public int lcs(int i, int[] input) {
		if (i == 0)
			return 1;
		return Math.max(lcs(i-1, input), 1 + lcs(i-1, input));
	}
}

// 5 2 8 6 3 6 9 7
// 2 3 6 9
// LCS
// LCS(0) 1
// prev 
// LCS(1) = LCS(0) = 1 
// LCS(2) = 
