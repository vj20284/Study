package com.practise.geeks4geeks.misc;

public class IsSubsequence {
	// ret true if b is a subsequence of a
	public boolean isSubsequence(String a, String b) {
		int j = 0;
		
		for (int i = 0; i < b.length() && j < a.length(); i++) {
			if (a.charAt(j) == b.charAt(i)) {
				j++;
			}
		}
		return j == a.length();
	}
	
	public static void main(String[] args) {
		IsSubsequence is = new IsSubsequence();
		System.out.println(is.isSubsequence("abc", "ahdkdbdkdcdkd"));
		
		System.out.println(is.isSubsequence("abc", "ahdkdbdkddkd"));

		System.out.println(is.isSubsequence("gksrek", "geeksforgeeks"));

	}
}	
