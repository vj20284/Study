package com.practise.geeks4geeks.dynamicprogramming;

public class LongestIncreasingSubsequence {
	public int longestSubsequence(int[] arr) {
		int[] soln = new int[arr.length];
		soln[0] = 1;
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && soln[i] < soln[j] + 1) {
					soln[i] = soln[j] + 1; 
					max = soln[i] > max ? soln[i] : max;
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		
		int[] arr = new int[] {10, 22, 9, 33, 21, 50, 41, 60, 42};
		System.out.println(lis.longestSubsequence(arr));
	}
}
