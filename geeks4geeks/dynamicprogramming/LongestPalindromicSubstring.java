package com.practise.geeks4geeks.dynamicprogramming;


public class LongestPalindromicSubstring {
	public String maxLength(String s) {
		int[][] soln = new int[s.length()][s.length()];
		int max = 0;
		int start = -1;
		
		for (int i = 0; i < s.length(); i++)
			soln[i][i] = 1;
		
		for (int i = 0; i < s.length() - 1; i++)
			soln[i][i + 1] = s.charAt(i) == s.charAt( i + 1) ? 2 : 0;
		
		for (int i = 1; i < s.length(); i++) 
		{
			for (int j = 0; j < i - 1; j++)
			{
				if (s.charAt(j) == s.charAt(i) && soln[j + 1][i - 1] != 0) {
					soln[j][i] = 2 + soln[j + 1][i - 1];
				}
				if (soln[j][i] > max) {
					max = soln[j][i];
					start = j;
				}
			}
		}
		
		return s.substring(start, start + max);
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		
		System.out.println(lps.maxLength("BBABCBCBDB"));
	}
}
