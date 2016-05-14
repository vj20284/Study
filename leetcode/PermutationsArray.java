package com.practise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsArray {
	public List<String> generatePermutations(Integer[] input) {
		List<String> retList = new ArrayList<String>();
		permute(input, 0);
		return retList;
	}
	
	public void permute(Integer[] input, int i) {
		if (i == input.length) {
			printArray(input);
			return;
		}
		for (int k = i; k < input.length; k++) {
			swap(input, i, k);
			permute(input, i + 1);
			swap(input, k, i);
		}
	}
	
	public void swap(Integer[] input, int i, int j) {
		Integer temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public void printArray(Integer[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println("");
	}
}

/**
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 3 1 2
 */
