package com.practise.algorithms.designmanual.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterPermutations {
	private StringBuilder sb = new StringBuilder();
	
	public List<String> permutations(String s) {
		List<String> permutations = new ArrayList<String>();
		char[] chars = new char[s.length()];
		for (int i = 0; i < s.length(); i++)
			chars[i] = s.charAt(i);
		helper(chars, 0, permutations);
		return permutations;
	}
	
	public void helper(char[] chars, int start, List<String> permutations) {
		if (start == chars.length - 1) {
			sb.delete(0, sb.length());
			for (int i = 0; i < chars.length; i++)
				sb.append(chars[i]);
			permutations.add(sb.toString());
			return;
		}
		
		for (int i = start; i < chars.length; i++) {
			swap(chars, start, i);
			helper(chars, start + 1, permutations);
			swap(chars, i, start);
		}
	}
	
	public void swap(char[] s, int a, int b) {
		char temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}
	
	
	public static void main(String[] args) {
		LetterPermutations lp = new LetterPermutations();
		List<String> permutations = lp.permutations("vivek");
		for (String s : permutations) {
			System.out.println(s);
		}
	}
}
