package com.practise.leetcode.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	static Map<Character, Character> charMap = new HashMap<Character, Character>();
	static {
		charMap.put('}', '{');
		charMap.put(']', '[');
		charMap.put(')', '(');
	}
	public static boolean Validate(String str) {
		if (str == null || str.length() == 0 || str.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (Character ch : str.toCharArray()) {
			if (!stack.isEmpty() && charMap.get(ch) != null) {
				Character curTop = stack.peek();
				if (charMap.get(ch) == curTop) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			} else {
				stack.push(ch);
			}
		}
		return stack.empty() ? true : false;
	}
	
	public static void main(String[] args) {
		String str = "{[]}()({[{}]})[]";
		if (Validate(str)) {
			System.out.println("Valid " + str);
		} else {
			System.out.println("InValid " + str);			
		}
		str = "{[]}([]{}[{}()]";
		if (Validate(str)) {
			System.out.println("Valid " + str);
		} else {
			System.out.println("InValid " + str);			
		}
		str = "{[}]([]{}[{}()]";
		if (Validate(str)) {
			System.out.println("Valid " + str);
		} else {
			System.out.println("InValid " + str);			
		}
	}
}
