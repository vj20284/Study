package com.practise.geeks4geeks.dynamicprogramming;


public class LongestPalindromicSubsequence {
	public int maxLength(String s) {
		int[][] soln = new int[s.length()][s.length()];
		int[][] way = new int[s.length()][s.length()];
		
		for (int i = 0; i < s.length(); i++)
			soln[i][i] = 1;
				
		for (int i = 1; i < s.length(); i++) 
		{
			for (int j = i - 1; j >= 0; j--)
			{
				if (s.charAt(i) == s.charAt(j)) {
					soln[j][i] = 2 + soln[j + 1][i - 1];
					way[j][i] = 0;
				}
				else {
					soln[j][i] = Math.max(soln[j][i - 1], soln[j + 1][i]);
					way[j][i] = soln[j][i - 1] > soln[j + 1][i] ? 1 : 2;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int b = 0, e = s.length() - 1;
		while (b <= e) {
			if (way[b][e] == 0) {
				sb.append(s.charAt(e--));
			} 
			else if (way[b][e] == 2)
				b += 1;
			else if (way[b][e] == 1)
				e -= 1;
		}
		return soln[0][s.length() - 1];
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		
		lps.maxLength("BBABCBCAB");
	}
}
