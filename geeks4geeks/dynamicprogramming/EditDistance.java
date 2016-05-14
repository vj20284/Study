package com.practise.geeks4geeks.dynamicprogramming;

public class EditDistance {
	public int editDistance(String a, String b) {
		int[][] soln = new int[a.length() + 1][b.length() + 1]; 
		
		for (int i = 0; i <= a.length(); i++)
			soln[i][0] = i;
		
		for (int j = 0; j <= b.length(); j++)
			soln[0][j] = j;
		
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				soln[i][j] = Math.min(Math.min(soln[i - 1][j] + 1, soln[i][j - 1] + 1), 
								soln[i - 1][j - 1] + a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1);
			}
		}
		
		return soln[a.length()][b.length()];
	}
}
