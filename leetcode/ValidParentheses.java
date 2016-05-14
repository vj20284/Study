package com.practise.leetcode;

import java.util.Stack;

import junit.framework.Assert;

import org.junit.Test;

public class ValidParentheses {
	// ([]){()}()  ---- valid
	// ({]}] --- invalid
	
	Stack<Character> openBrackets = new Stack<Character>();
	
	public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
         Stack<Character> openBrackets = new Stack<Character>();
   
        boolean retVal = true;
    	
		if (s == null)
			return true;
		
		int inputLength = s.length();
		
		if (inputLength % 2 != 0)
			return false;
		
		for (int i = 0; i < inputLength; i++) {
			Character curChar = s.charAt(i);
			if (curChar == '{' || curChar == '(' || curChar == '[')
				openBrackets.push(curChar);
			if (curChar == '}' || curChar == ')' || curChar == ']') {
				if (openBrackets.empty())
					return false;
				Character lastBracket = openBrackets.pop();
				if (curChar == '}' && lastBracket != '{')
					return false;
				if (curChar == ')' && lastBracket != '(')
					return false;
				if (curChar == ']' && lastBracket != '[')
					return false;				
			}			
		}
		
		if (!openBrackets.empty())
			return false;
		return retVal;
    }
	
	@Test
	public void testValidParentheses() {
		String ip1 = "()[]{}";
		String ip2 = "((((";
		String ip3 = "([)]";
		boolean retVal = isValid(ip1);
		System.out.println(retVal);
		Assert.assertEquals(true, retVal);
		retVal = isValid(ip2);
		System.out.println(retVal);
		Assert.assertEquals(false, retVal);
		retVal = isValid(ip3);
		System.out.println(retVal);
		Assert.assertEquals(false, retVal);
	}
}
