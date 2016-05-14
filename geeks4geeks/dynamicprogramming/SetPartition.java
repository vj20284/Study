package com.practise.geeks4geeks.dynamicprogramming;

public class SetPartition {
	public boolean partition(int[] arr) {	
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		if (total % 2 != 0)
			return false;
		
		return helper(arr, arr.length, total / 2);
	}
	
	public boolean helper(int[] arr, int end, int sum) {
		if (sum == 0)
			return true;
		
		if (end == 0 && sum != 0)
			return false;
		
		if (arr[end - 1] > sum) 
			return helper(arr, end - 1, sum);
		
		return helper(arr, end - 1, sum) || helper(arr, end, sum - arr[end - 1]);
	}
}
