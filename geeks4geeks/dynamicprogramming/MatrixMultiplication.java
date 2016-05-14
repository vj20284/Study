package com.practise.geeks4geeks.dynamicprogramming;

public class MatrixMultiplication {
	public long numOperations(int[] arr) {
		int n = arr.length - 1;
		int[][] soln = new int[n + 1][n + 1];
		int[][] path = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			soln[i][i] = 0;
		}
		
		for (int l = 2; l <= n; l++) { // length of chain
			for (int i = 1; i <= n - l + 1; i++) {
				int j = i + l - 1; // end of chain
				soln[i][j] = Integer.MAX_VALUE;
				for(int k = i; k <= j - 1; k++) { // intermediate
					int temp = soln[i][k] + soln[k + 1][j] +
							arr[i - 1] * arr[k] * arr[j];
					if (temp < soln[i][j]) {
						soln[i][j] = temp;
						path[i][j] = k;
					}
				}
			}
		}
		
		return soln[1][n - 1];
	}
	
	public static void main(String[] args) {
		MatrixMultiplication mm = new MatrixMultiplication();
		
		int[] arr = new int[] {40, 20, 30, 10, 30};
		mm.numOperations(arr);
	}
}
