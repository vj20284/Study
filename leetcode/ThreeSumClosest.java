package com.practise.leetcode;
import java.util.*;

import org.junit.Test;

public class ThreeSumClosest {
	@Test
	public void test() {
		int[] array = new int[] {-1, 2, 1, -4};
		List<Integer> triplet = threeSum(array, 1);
		for (Integer curVal : triplet) {
			System.out.print(curVal + " ");
		}
	}

	public List<Integer> threeSum (int[] array, int target) {		
		TreeSet<Integer> numbers = new TreeSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			numbers.add(array[i]);
		}
		int[] temp = new int[numbers.size()];
		int addIndex = 0;
		for (Integer val : numbers) {
			temp[addIndex++] = val;
		}

		List<Integer> triplet = new ArrayList<Integer>(3);

		int n = numbers.size();
		int diff = 9999;

		for (int i = 0;i < n; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum_two = temp[i] + temp[j];
				int curDiff = Math.abs(target - (sum_two + temp[k]));
				if (curDiff > diff) {
					k--;
				}
				if (curDiff <= diff) {
					diff = curDiff;
					triplet = new ArrayList<Integer>();					
					triplet.add(temp[i]);
					triplet.add(temp[j]);
					triplet.add(temp[k]);
					j++;
					k--;
				}								
			}
		}
		return triplet;
	}

}
