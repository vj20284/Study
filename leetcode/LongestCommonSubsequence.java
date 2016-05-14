package com.practise.leetcode;

import org.junit.Test;

public class LongestCommonSubsequence {
	public void lcs(String x, String y) {
		int m = x.length();
		int n = y.length();
		
		int b[][] = new int [m + 1][n + 1];
		int c[][] = new int [m + 1][n + 1];
		
		for (int i = 0; i < m; i++) {
			c[i][0] = 0;
		}
		
		for (int i = 0; i < n; i++) {
			c[0][i] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (x.charAt(i) == y.charAt(j)) {
					c[i+1][j+1] = c[i][j] + 1;
					b[i+1][j+1] = 99;
				}
				else if (c[i][j+1] >= c[i+1][j]) {
					c[i+1][j+1] = c[i][j+1];
					b[i+1][j+1] = 88;
				}
				else {
					c[i+1][j+1] = c[i][j+1];
					b[i+1][j+1] = 77;
				}
			}
		}
		printLcs(b, x, m, n);
	}
	
	public void printLcs(int[][] b, String X, int i, int j) {
		if (i == 0 || j == 0) 
			return;
		
		if (b[i][j] == 99) {
			printLcs(b, X, i - 1, j - 1);
			System.out.println(X.charAt(i));
		}
		else if (b[i][j] == 77) {
			printLcs(b, X, i - 1, j);
		}
		else {
			printLcs(b, X, i, j - 1);
		}	
	}
	
	@Test
	public void test(){

		String a="vivekvivekvivek";
		String b="kivereng";
		lcs(a,b);
	}
}
