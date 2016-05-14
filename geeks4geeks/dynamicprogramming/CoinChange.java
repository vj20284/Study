package com.practise.geeks4geeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CoinChange {
	public List<List<Integer>> ways(int target, List<Integer> candidates) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		Collections.sort(candidates);
		
		int i = candidates.size() - 1, curSum = 0;
		List<Integer> curList = new ArrayList<Integer>();
		Stack<Integer> indices = new Stack<Integer>();
		
		while (i >= 0) {
			curList.add(0, candidates.get(i));
			indices.push(i);
			curSum += candidates.get(i);
			if (curSum >= target) {
				if (curSum == target) {
					results.add(new ArrayList<Integer>(curList));
				}
				i = indices.pop() - 1;
				curSum -= curList.remove(0);
			}
			while (i == -1 && !indices.isEmpty()) {
				curSum -= curList.remove(0);
				i = indices.pop() - 1;
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		List<Integer> candidates = new ArrayList<Integer>();
		candidates.add(5);
		candidates.add(10);
		candidates.add(25);
		
		List<List<Integer>> res = cc.ways(100, candidates);
		for (List<Integer> list : res) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
