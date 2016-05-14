package com.practise.geeks4geeks.dynamicprogramming;

public class SetPartitionDyn {
	public boolean partition(int[] arr) {	
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		if (total % 2 != 0)
			return false;
		
		boolean[][] soln = new boolean[total/2 + 1][arr.length + 1];
		for (int i = 0; i <= arr.length; i++)
			soln[0][i] = true;
		
		for (int i = 1; i <= total/2; i++) 
			soln[i][0] = false;
		
		/*for (int i = 1; i <= total/2; i++) {
			for (int j = 1; j <= arr.length; j++) {
				soln[i][j] = soln[i][j - 1];
				if (i > arr[j - 1])
					soln[i][j] = soln[i][j] || soln[i - arr[j - 1]][j - 1];
			}
		}*/
		
		for (int j = 1; j <= arr.length; j++) {
			for (int i = 1; i <= total/2; i++) {
				soln[i][j] = soln[i][j-1];
				if (i >= arr[j - 1])
					soln[i][j] = soln[i][j] || soln[i - arr[j - 1]][j - 1];
			}
		}
		
		return soln[total/2][arr.length];
	}
	
	public static void main(String[] args) {
		SetPartitionDyn spd = new SetPartitionDyn();
		int[] arr = new int[]{5, 2, 9, 12};
		
		System.out.println(spd.partition(arr));
	}
}
