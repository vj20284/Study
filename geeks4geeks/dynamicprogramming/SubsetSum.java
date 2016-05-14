package com.practise.geeks4geeks.dynamicprogramming;

/**
 * Similar to set partition
 * @author vivek
 *
 */
public class SubsetSum {
	public boolean subsetSum(int[] arr, int sum) {
		boolean[][] soln = new boolean[sum + 1][arr.length + 1];
		for (int i = 0; i <= arr.length; i++)
			soln[0][i] = true;
		
		for (int i = 1; i <= sum; i++) 
			soln[i][0] = false;
				
		for (int j = 1; j <= arr.length; j++) {
			for (int i = 1; i <= sum; i++) {
				soln[i][j] = soln[i][j-1];
				if (i >= arr[j - 1])
					soln[i][j] = soln[i][j] || soln[i - arr[j - 1]][j - 1];
			}
		}
		
		return soln[sum][arr.length];
	}
	
	public static void main(String[] args) {
		SubsetSum spd = new SubsetSum();
		int[] arr = new int[]{3, 34, 3, 12, 5};
		
		System.out.println(spd.subsetSum(arr, 41));
	}
}
