package com.practise.geeks4geeks.dynamicprogramming;

public class MaxSumIncreasingSubsequence {
	public int maxSum(int[] arr) {
		int ret = Integer.MIN_VALUE;
		int[] soln = new int[arr.length];
		for(int i = arr.length - 1; i >= 0; i--) {
			int max = arr[i];
			for (int j = i; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					max = Math.max(max, arr[i] + soln[j]);
				}
				soln[i] = max;
				ret = soln[i] > ret ? soln[i] : ret;
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		MaxSumIncreasingSubsequence msis = new MaxSumIncreasingSubsequence();
		int[] arr = new int[]{101, 99, 2, 3, 100, 4 ,101 };
		
		System.out.println(msis.maxSum(arr));
		
	}
}
