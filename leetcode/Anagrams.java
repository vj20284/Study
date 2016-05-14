package com.practise.leetcode;
import java.util.*;

import org.junit.Test;

public class Anagrams {
	public static HashMap<Integer, List<String>>  anagramMap = new HashMap<Integer, List<String>>();

	public static void anagrams(List<String> strings) {
		for (String str: strings) {
			List<Character> chars = new ArrayList<Character>(str.length());
			for (int i = 0; i < str.length(); i++) {
				chars.add(str.charAt(i));
			}
			Collections.sort(chars);
			Integer hash = computeHash(chars);
			if (anagramMap.get(hash) == null) {
				List<String> words = new ArrayList<String>();
				words.add(str);
				anagramMap.put(hash, words);
			}
			else {
				anagramMap.get(hash).add(str);
			}
		}
	}
	
	public static Integer computeHash(List<Character> characters) {
		StringBuilder sb = new StringBuilder(characters.size());
		for (Character curChar : characters) {
			sb.append(curChar);
		}
		return sb.toString().hashCode();
	}
}
