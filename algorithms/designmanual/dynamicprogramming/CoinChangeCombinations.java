package com.practise.algorithms.designmanual.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
public class CoinChangeCombinations {
	public int combinations(int target, List<Integer> candidates) {
		int[][] soln = new int[target + 1][candidates.size()];
		Collections.sort(candidates);
		
		for (int i = 0; i < candidates.size(); i++) { 
			soln[0][i] = 1;
		}
		
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < candidates.size(); j++) {
				// Including current
				int x = i - candidates.get(j) >= 0 ? 
						soln[i - candidates.get(j)][j] : 0;
				// Excluding current		
				int y = j >= 1? soln[i][j - 1] : 0;
				
				soln[i][j] = x + y;
			}
		}
		return soln[target][candidates.size() - 1];
	}
	
	public static void main(String[] args) {
		CoinChangeCombinations cc = new CoinChangeCombinations();
		List<Integer> candidates = new ArrayList<Integer>();
		candidates.add(1);
		candidates.add(2);
		candidates.add(5);
		candidates.add(10);
		
		int res = cc.combinations(10, candidates);
		System.out.println(res);
	}
}
