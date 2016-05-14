package com.practise.leetcode;

import org.junit.Test;

public class BinarySum {
	
	@Test
	public void TestBinSum() {
		String a = "11";
		String b = "1";
		System.out.println(binarySum(a, b));
	}

	public String binarySum(String a, String b) {
		StringBuilder retVal = new StringBuilder("");
		String largerStr = null;
		
		int smallerLength = a.length() < b.length() ? a.length() : b.length();
		largerStr = a.length() < b.length() ? b : a;
		int carry = 0;
		
		for (int i = 0 ; i < smallerLength; i++) {
			int val1 = Integer.parseInt(String.valueOf(a.charAt(a.length() - (i + 1))));
			int val2 = Integer.parseInt(String.valueOf(b.charAt(b.length() - (i + 1))));
			if (carry + val1 + val2 == 2) {
				carry = 1;
				retVal.append("0");
			}
			else if (carry + val1 + val2 == 3) {
				carry = 1;
				retVal.append("1");
			}
			else if (carry + val1 + val2 < 2) {
				carry = 0;
				retVal.append(val1 + val2);
			}
		}
		
		int diffLt = Math.abs(a.length() - b.length()) ;
		
		for (int i = 0 ; i < diffLt; i++) {
			int val = Integer.parseInt(String.valueOf(largerStr.charAt(largerStr.length() - (i + 1))));
			if (val + carry == 2) {
				carry = 1;
				retVal.append("0");
			}
			else if (val + carry < 2) {
				carry = 0;
				retVal.append(val + carry);
			}
		}
		if (carry > 0)
			retVal.append(carry);
		StringBuilder revStr = new StringBuilder(retVal.length());
		for (int i = 0; i < retVal.length(); i++) {
			revStr.append(retVal.charAt(retVal.length() - (i + 1)));
		}
		
		return revStr.toString();
	}
}
