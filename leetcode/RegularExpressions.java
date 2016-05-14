package com.practise.leetcode;

public class RegularExpressions {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.charAt(1) == '*') {
			if (p.charAt(0) != '.') {
				int i = 0;
				while (i < s.length() && s.charAt(i) == p.charAt(0)) {
					i++;
				}
				return isMatch(s.substring(i), p.substring(2));
			} else {
				int i = 1;
				while (i + 1 < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
					i++;
				}
				return isMatch(s.substring(i + 1), p.substring(2));
			}
		}

		return false; // dummy
	}

	public static void main(String[] args){
		RegularExpressions re = new RegularExpressions();
		System.out.println(re.isMatch("aaaaaaaaaabb", "aa*b*"));
		System.out.println(re.isMatch("aaaaaaaaaabbb", "aa*b*a"));
		System.out.println(re.isMatch("aaaaaaaaaabb", "aa*bb"));
		System.out.println(re.isMatch("aaaaaaaaaabbccc", "aa*b*c*"));
		System.out.println(re.isMatch("aaaaaaaaaabbc", "aa*b*c"));
		System.out.println(re.isMatch("aaaaaaaaaabbc", ".*b*c"));
		System.out.println(re.isMatch("aaaaaaaaaac", ".*.*"));
	}
}
