package com.practise.leetcode;

import org.junit.Test;

public class CombinationSum {
	//Given a set of candidate numbers (C) and a target number (T), 
	//find all unique combinations in C where the candidate numbers sums to T.
	//The same repeated number may be chosen from C unlimited number of times.

	void printSum(int candidates[], int index[], int n) {
		for (int i = 1; i <= n; i++) {
			String str = (i==n)? "" : "+";
			System.out.print(candidates[index[i]] + " " + str);
		}
		System.out.println("\n");
	}

	void solve(int target, int sum, int candidates[], int sz, int index[], int n) {
		if (sum > target)
			return;
		if (sum == target)
			printSum(candidates, index, n);

		for (int i = index[n]; i < sz; i++) {
			index[n+1] = i;
			solve(target, sum + candidates[i], candidates, sz, index, n+1);
		}
	}

	void solve(int target, int candidates[], int sz) {
		int index[] = new int[10000];
		index[0] = 0;
		solve(target, 0, candidates, sz, index, 0);
	}

	@Test
	public void testCombination() {
		int array[] = new int[] {2,3,6, 7};
		int target = 7;
		
		solve(target, array, array.length);
	}
}
