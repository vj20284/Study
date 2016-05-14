package com.practise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<String> generatePermutations(String input) {
		List<String> retList = new ArrayList<String>();
		permute("", input);
		return retList;
	}
	
	public void permute(String prefix, String suffix) {
		if (suffix.length() == 1) {
			System.out.println(prefix + suffix);
			return;
		}
		for (int i = 0; i < suffix.length(); i++) {
			permute(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1));
		}
	}
}

/**
 * abcd
 * acbd 
 * abcd
 * abdc
 * adbc
 * abcd
 * abdc
 */
