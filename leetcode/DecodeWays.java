package com.practise.leetcode;

import org.junit.Test;

public class DecodeWays {

	@Test
	public void testDecodeWays() {
		String str = "51234216";
		System.out.println("Ways : " + decodeWays(str));
	}

	public int decodeWays(String s) {
		int nLen = s.length();
		
		if (nLen <= 0) return 0;
		int a = 1;// 1 not 0
		int b = (s.charAt(0) >= '1' && s.charAt(0) <= '9') ? 1 : 0;
		
		for (int i = 1; i < nLen; i++)
		{
			int c = 0;
			String twoChars = s.substring(i - 1, i + 1);
			Integer val = Integer.parseInt(twoChars);			
			if (val >= 10 && val <= 26)
                c += a;                
			if (val % 10 != 0)
				c += b;
			a = b;
			b = c;
		}

		return b;
	}
}
