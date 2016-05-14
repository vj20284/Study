package com.practise.leetcode;

import org.junit.Test;

public class CountSay {
	@Test
	public void testGenSeq() {
		int limit = 10;
		for (int i = 1; i < limit; i++) {
			String retVal = generateSequence(i);
			System.out.println(retVal);
		}

	}

	public String generateSequence(int n) {
		StringBuilder retVal = new StringBuilder("1");
		if (n >= 2){
			retVal.append("1");
		}
		for (int i = 2; i < n; i++) {
			retVal = new StringBuilder(generate(retVal.toString()));
		}
		return retVal.toString();
	}

	public String generate(String str) {
		StringBuilder retVal = new StringBuilder("");
		Character prevChar = str.charAt(0);
		int sameCount = 0;
		for (int i = 0; i < str.length(); i++) {
			Character curChar = str.charAt(i);
			if (curChar == prevChar)
				++sameCount;
			else {
				retVal.append(sameCount);
				retVal.append(prevChar);
				sameCount = 1;
				prevChar = curChar;
			}
		}
		if (sameCount > 0) {
			retVal.append(sameCount);
			retVal.append(prevChar);
		}

		return retVal.toString();
	}
}
