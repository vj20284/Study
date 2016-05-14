package com.practise.geeks4geeks.dynamicprogramming;

public class MaxSumRectangle {
	public int maxSumRectangle(int[][] matrix) {
		int[][] soln = new int[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) 
			soln[0][i] = matrix[0][0];
		return 0;
	}
}
