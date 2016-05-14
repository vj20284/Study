package com.practise.leetcode;

import org.junit.Test;

public class PalindromeNumber {

	@Test
	public void testNum() {
		Long num = 123456754321L;
		if(isPalindrome(num)) {
			System.out.println("Is a palindrome");
		}
		else
			System.out.println("Not a palindrome");

		int inum = -2147447412;
		if(isPalindrome(inum)) {
			System.out.println("Is a palindrome");
		}
		else
			System.out.println("Not a palindrome");

	}
	
	public void testLastDigit(Long num) {
		Long lastDigit = num % 10;
		System.out.println(lastDigit);
	}
	
	public boolean isPalindrome(Long num) {
		while (num > 10) {
			Long lastDigit = num % 10;
			Long initialDigit = getInitialDigit(num);
			System.out.println("Number " + num);
			System.out.println("Comparing " + lastDigit + " and " + initialDigit);
			if (lastDigit != initialDigit)
				return false;
			num = num / 10;
			int numDigits = numDigits(num);
			long minuend = initialDigit * (long) Math.pow(10, numDigits - 1);
			num = num - minuend;
		}
		return true;
	}
	
	public int numDigits(Long num) {
		int count = 0;
		while (num > 0) {
			count++;
			num = num/10;
		}
		return count;
	}
	
	public Long getInitialDigit(Long num) {
		while (num > 10) {
			num = num / 10;
		}
		return num;
	}
	
	public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function  
        if (x < 0)
        	return false;
        int rev = 0;
        int num = x;
		while (num > 0) {
			int remainder = num % 10;
			num = num / 10;
			rev = rev * 10 + remainder;
		}
		return(x == rev);			
	}
	
	public int revRecursive(int num, int rem) {
		if (num > 0) {
			int rem1 = rem * 10 + num % 10;
			return rev(num/10, rem1);
		}
		return rem;
	}
	
	public int rev(int num, int rem) {
		int temp = 0;
		while (num > 0) {
			int remainder = num % 10;
			num = num / 10;
			temp = temp * 10 + remainder;
		}
		return rem;
	}
}
