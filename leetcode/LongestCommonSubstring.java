package com.practise.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LongestCommonSubstring {
	
	public static void lcs(String x, String y) {
		int m = x.length();
		int n = y.length();
		
		int c[][] = new int [m + 1][n + 1];
		
		int longest = 0;
		List<String> longestStrings = new ArrayList<String>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (x.charAt(i) == y.charAt(j)) {
					if (i == 0 && j == 0) {
						c[i+1][j+1] = 1;
					} else {
						c[i+1][j+1] = c[i][j] +1;
					}
					if (c[i+1][j+1] > longest) {
						longest = c[i+1][j+1];
						longestStrings = new ArrayList<String>();
						longestStrings.add(x.substring(i - longest + 1, i)); 
					} else if (c[i+1][j+1] == longest) {
						longestStrings.add(x.substring(i + 1 - longest + 1, i + 1));
					}
				}
				else {
					c[i+1][j+1] = 0;
				}
			}
		}
		printLcs(longestStrings);
	}
	
	public static void printLcs(List<String> strings) {
		for (String str : strings) {
			System.out.println(str);
		}
	}
	
	@Test
	public void test(){
		String a="vivekvivekvivek";
		String b="kvivereng";
		lcs(a,b);
	}
}
