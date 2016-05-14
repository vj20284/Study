package com.practise.geeks4geeks.misc;

import java.util.ArrayList;
import java.util.List;

public class PrintSequences {
	public void print(int k, int n) {
		List<List<Integer>> combinations = helper(k, n, 0);
		for (List<Integer> list : combinations) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> helper(int k, int n, int start) {
		if (k == 1) {
			List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
			for (int i = start + 1 ; i <= n; i++) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				listOfLists.add(list);
			}
			return listOfLists;
		}
		List<List<Integer>> myCombinations = new ArrayList<List<Integer>>();
		for (int i = start + 1; i <= n - k + 1; i++) {
			List<List<Integer>> nextSeq = helper(k - 1, n, i);
			for (List<Integer> list : nextSeq) {
				list.add(0, i);
			}
			myCombinations.addAll(nextSeq);
		}
		return myCombinations;
	}
	
	public static void main(String[] args) {
		PrintSequences ps = new PrintSequences();
		ps.print(3,  5);
	}
}
