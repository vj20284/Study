package com.practise.algorithms.designmanual.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combinations(List<Integer> elements, int k) {
		return helper(elements, 0, k);
	}
	
	public List<List<Integer>> helper(List<Integer> elements, int start, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		if (k == 1) {
			for (int i = start; i < elements.size(); i++) {
				List<Integer> newList = new ArrayList<Integer>();
				newList.add(elements.get(i));
				combinations.add(newList);
			}
			return combinations;
		}
		
		List<List<Integer>> myCombinations = new ArrayList<List<Integer>>();
		for (int i = start; i <= elements.size() - k; i++) {
			List<List<Integer>> nextCombinations = helper(elements, i + 1, k - 1);
			for (List<Integer> list : nextCombinations) {
				list.add(0, elements.get(i));
				myCombinations.add(list);
			}
		}
		return myCombinations;
	}
	
	public static void main(String[] args) {
		int k = 3;
		List<Integer> elements = new ArrayList<Integer>();
		elements.add(1);
		elements.add(2);
		elements.add(3);
		elements.add(4);
		elements.add(5);
		Combinations c = new Combinations();
		List<List<Integer>> ret = c.combinations(elements, k);
		for (List<Integer> list : ret) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
