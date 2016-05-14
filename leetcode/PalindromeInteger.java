package com.practise.leetcode;

public class PalindromeInteger {

	public static boolean check(int num) {
		int numDigits = numDigits(num);
		for (int i = 0; i < numDigits/2; i++) {
			int digit1 = getDigitAtPosition(num, numDigits - i);
			int digit2 = getDigitAtPosition(num, i + 1);
			if (digit1 != digit2){
				System.out.println("Mismatch : " + digit1 + " " + digit2);
				return false;
			}
			System.out.println("Match : " + digit1 + " " + digit2);
		}
		return true;
	}
	
	public static int numDigits(int num) {
		int numDigits = 0;
		
		while (num > 0) {
			num = num / 10;
			numDigits++;
		}
		
		return numDigits;
	}
	
	public static int getDigitAtPosition(int num, int position) {
		int retVal = 0;
		String sPowerOfTen = String.valueOf(Math.pow(10, position - 1));
		sPowerOfTen = sPowerOfTen.substring(0, sPowerOfTen.indexOf("."));
		int powerOfTen = Integer.parseInt(sPowerOfTen);
		retVal = (num - (num % powerOfTen)) / powerOfTen;
		if (retVal > 10) 
			retVal = retVal % 10;
		System.out.println("Digit at :" + position + " of " + num + " is " + retVal);
		return retVal;
	}
	
	public static int reverseNum(int num) {
		int retVal = 0;
		while (num > 0) {
			retVal = retVal * 10 + num % 10;
			num = num / 10;
		}
		return retVal;
	}
}
/**
134431
131

134
**/