package com.practise.geeks4geeks.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
	public boolean isSum(List<Integer> set, int sum) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		return helper(set, 0, sum, subsets);
	}
	
	public boolean helper(List<Integer> elements, int start, int sum, List<List<Integer>> subsets) {
		if (start == elements.size()) {
			subsets.add(new ArrayList<Integer>());
			return false;
		}
		
		if (helper(elements, start + 1, sum, subsets) == true)
			return true;
		List<List<Integer>> newsubsets = new ArrayList<List<Integer>>(subsets);
		for (List<Integer> list : subsets) {
			int total = 0;
			List<Integer> newList = new ArrayList<Integer>(list);
			newList.add(elements.get(start));
			for (int i : newList) {
				total += i;
			}
			if (total == sum)
				return true;
			newsubsets.add(newList);
		}
		subsets.addAll(newsubsets);
		return false;
	}
	
	public static void main(String[] args) {
		SubsetSum ss = new SubsetSum();
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(9);
		list.add(1);
		
		System.out.println(ss.isSum(list, 4));
	}
}
