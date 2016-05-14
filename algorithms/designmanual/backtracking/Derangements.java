package com.practise.algorithms.designmanual.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Derangements {
	public List<List<Integer>> derangements(int n) {
		List<Integer> canPick = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			canPick.add(i + 1);
		}
		List<Integer> combination = new  ArrayList<Integer>();
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		helper(canPick, combinations, combination);
		return combinations;
	}
	
	public void helper(List<Integer> canPick, List<List<Integer>> combinations, List<Integer> combination) {
		if (canPick.size() == 0) {
			combinations.add(new ArrayList<Integer>(combination));
			return;
		}
		int insertIndex = combination.size() + 1;
		int poolLen = canPick.size();
		for (int i = 0; i < poolLen; i++) {
			int num = canPick.get(i);
			if (num != insertIndex) {
				canPick.remove(i);
				combination.add(num);
				helper(canPick, combinations, combination);
				combination.remove(combination.size() - 1);
				canPick.add(i, num);
			}
		}
	}
	
	public static void main(String[] args) {
		Derangements d = new Derangements();
		
		List<List<Integer>> ret = d.derangements(5);
		for (List<Integer> list : ret) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
