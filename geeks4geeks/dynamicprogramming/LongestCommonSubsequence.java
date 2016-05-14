package com.practise.geeks4geeks.dynamicprogramming;

public class LongestCommonSubsequence {
	public int longestCommon(String a, String b) {
		int[][] soln = new int[a.length() + 1][b.length() + 1];
		int len = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 || j == 0)
					soln[i][j] = 0;
				else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					soln[i][j] = soln[i - 1][j - 1] + 1;
				}
				else
					soln[i][j] = Math.max(soln[i - 1][j], soln[i][j - 1]);
			}
		}
		
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (soln[i][j] == len + 1) {
					sb.append(a.charAt(i - 1));
					len = len + 1;
				}
			}
		}
		
		System.out.println("Longest common subsequence : " + sb.toString());
		return soln[a.length()][b.length()];
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		
		System.out.println(lcs.longestCommon("ABCDGH", "AEDFHR"));

		System.out.println(lcs.longestCommon("VIVEKJEYAKUMAR", "PEIHONGHUANG"));

		System.out.println(lcs.longestCommon("SEXYASS", "BUNSAWFACE"));

	}
}
