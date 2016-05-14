package com.practise.geeks4geeks.dynamicprogramming;

public class LongestBitonicSubsequence {
	public int longest(int[] arr) {
		int[] lis = new int[arr.length - 1];
		int[] lds = new int[arr.length - 1];
		
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
			lds[i] = 1;
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) 
					lis[i] = lis[j] + 1;
			}
		}
		
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[i] > arr[j] && lds[i] < lis[j] + 1) 
					lds[i] = lds[j] + 1;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(lis[i] + lds[i] - 1, max);
		}
		return max;
	}
}
