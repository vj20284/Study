package com.practise.geeks4geeks.dynamicprogramming;

public class MaxSubMatrix {
	public int maxSubMatrix(int[][] matrix) {
		int maxSize = 0;
		int maxr = -1;
		int maxc = -1;
		int[][] soln = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) 
			soln[0][i] = matrix[0][i];
		
		for (int i = 0; i < matrix.length; i++) 
			soln[i][0] = matrix[i][0];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					soln[i][j] = Math.min(soln[i - 1][j - 1], 
									Math.min(soln[i][j - 1], soln[i - 1][j])) + 1;
				}
				if (soln[i][j] > maxSize) {
					maxSize = soln[i][j];
					maxr = i;
					maxc = j;
				}
			}
		}
			
		return maxSize * maxSize;
	}
}
