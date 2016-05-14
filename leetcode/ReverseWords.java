package com.practise.leetcode;

import org.junit.Test;

public class ReverseWords {
	
	@Test
	public void revWords() {
		String line = "this is a test line";
		System.out.println(ReverseWords.reverse(line));
	}
	
	public static String reverse(String line) {
		StringBuilder rev = new StringBuilder();
		StringBuilder curWord = new StringBuilder();
		for (int i = 0; i < line.length(); i++) {
			Character curChar = line.charAt(i);
			if (curChar != ' ') {
				curWord.append(curChar);
				continue;
			}
			rev.insert(0, " ");
			rev.insert(0, curWord);
			curWord = new StringBuilder();
		}
		rev.insert(0, " ");
		rev.insert(0, curWord);
		
		return rev.toString();
	}
}
