package com.practise.leetcode;
import java.util.*;

import org.junit.Test;

public class ThreeSum {
	@Test
	public void test() {
		int[] array = new int[] {-1, 2, 1, -4, 4, -2, 6, -6, 0};
		List<List<Integer>> triplets = threeSum(array);
		for (List<Integer> curTriplet : triplets) {
			for (Integer curVal : curTriplet) {
				System.out.print(curVal + " ");
			}
			System.out.println("\n");
		}
	}

	public List<List<Integer>> threeSum (int[] array) {		
		TreeSet<Integer> numbers = new TreeSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			numbers.add(array[i]);
		}
		int[] temp = new int[numbers.size()];
		int addIndex = 0;
		for (Integer val : numbers) {
			temp[addIndex++] = val;
		}
		
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();

		List<Integer> triplet = new ArrayList<Integer>(3);

		int n = numbers.size();
		for (int i = 0;i < n; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum_two = temp[i] + temp[j];
				if (sum_two + temp[k] < 0) {
					j++;
				} else if (sum_two + temp[k] > 0) {
					k--;
				} else {
					triplet.add(temp[i]);
					triplet.add(temp[j]);
					triplet.add(temp[k]);
					triplets.add(triplet);
					triplet = new ArrayList<Integer>();
					j++;
					k--;
				}
			}
		}
		return triplets;
	}

}
