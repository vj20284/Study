package com.practise.leetcode;

public class PalindromicSubstring {
	public static String preProcess(String s) {
		int n = s.length();
		if (n == 0) return "^$";
		String ret = "^";
		for (int i = 0; i < n; i++)
			ret += "#" + s.substring(i, i + 1);

		ret += "#$";
		return ret;
	}

	public static String longestPalindrome(String s) {
		String T = preProcess(s);
		int n = T.length();
		int[] P = new int[n];
		int C = 0, R = 0;
		for (int i = 1; i < n-1; i++) {
			int i_mirror = 2*C-i; // equals to i' = C - (i-C)

			P[i] = (R > i) ? Math.min(R-i, P[i_mirror]) : 0;

			// Attempt to expand palindrome centered at i
			while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
				P[i]++;

			// If palindrome centered at i expand past R,
			// adjust center based on expanded palindrome.
			if (i + P[i] > R) {
				C = i;
				R = i + P[i];
			}
		}

		// Find the maximum element in P.
		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < n-1; i++) {
			if (P[i] > maxLen) {
				maxLen = P[i];
				centerIndex = i;
			}
		}

		return s.substring((centerIndex - 1 - maxLen)/2, maxLen);
	}
}


/**
 * 
 * abbbcddcbadd
 * 
 */
