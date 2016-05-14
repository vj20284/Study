package com.practise.geeks4geeks.misc;

import java.util.HashSet;
import java.util.Set;

public class LongestContinuousSubarray {
	public int longestContinuousSequence(int[] arr) {
		int retVal = 1;
		int[][] maxmin = new int[arr.length][arr.length];
		
		for (int i = 0; i < arr.length; i++) 
			maxmin[i][i] = arr[i];
		
		for (int i = 0; i < arr.length; i++) {
			Set<Integer> set = new HashSet<Integer>();
			set.add(arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				if (set.contains(arr[j]))
					break;
				maxmin[i][j] = arr[j] > maxmin[i][j - 1] ? arr[j] : maxmin[i][j - 1];
				maxmin[j][i] = arr[j] < maxmin[j - 1][i] ? arr[j] : maxmin[j - 1][i];
				set.add(arr[j]);
				if (Math.abs(maxmin[i][j] - maxmin[j][i]) == Math.abs(i - j)) {
					retVal = Math.abs(i - j) + 1 > retVal ? Math.abs(i - j) + 1 : retVal;
				}
			}
		}
		
		return retVal;
	}
	
	public static void main(String[] args) {
		LongestContinuousSubarray lcs = new LongestContinuousSubarray();
		int[] arr = new int[] {1, 1, 2, 4, 5, 7, 3, 56, 58, 57, 90, 92, 92, 94, 93, 91, 95, 45};
		System.out.println(lcs.longestContinuousSequence(arr));
		
		arr = new int[] {10, 12, 12, 10, 10, 11, 10};
		System.out.println(lcs.longestContinuousSequence(arr));
	}
}
