package com.practise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsIterative {
	public List<String> generatePermutations(String input) {
		List<String> retList = new ArrayList<String>();
		permute(input, retList);
		return retList;
	}
	
	public void permute(String input, List<String> retList) {
		if (input == null)
			return;
		for (int i = 0; i < input.length(); i++) {
			String tmp = input.substring(0, i) + input.substring(i + 1, input.length());
			for (int j = 0; j < input.length() - 1; j++) {
				tmp = rotate(tmp);
				retList.add(tmp);
				System.out.println(input.charAt(i) + tmp);
			}
		}
	}
	
	public String rotate(String input) {
		StringBuilder retVal = new StringBuilder("");
		retVal.append(input.substring(1));
		retVal.append(input.charAt(0));
		return retVal.toString();
	}
}
