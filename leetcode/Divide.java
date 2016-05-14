package com.practise.leetcode;

import java.io.IOException;

import org.junit.Test;

public class Divide {
	@Test
	public void test() {		
		try {
			System.out.println(divide(25, 5));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int divide(int dividend, int divisor) throws IOException {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (divisor == 0)
			throw (new IOException());
		int quotient = 0;
		int num = dividend;
		while (num > 0) {
			num = num - divisor;
			quotient++;
		}
		return quotient;
    }
	
	//leetcode OJ --> divide 2 numbers

	//bit divide

	int BitDiv(int a, int b)
	{
		assert(b != 0);

		boolean bNeg = ((a < 0 && b > 0) || (a > 0 && b < 0));
		 int ua = a;
		long ub = b;
		if (a < 0) ua = -a;
		if (b < 0) ub = -b;

		long nRet = 0;
		while (ua >= ub)
		{
			long nRes = 1;
			long nTmp = b;
			while (ua >= nTmp)
			{
				nTmp = (nTmp << 1);
				nRes = (nRes << 1);
			}

			nTmp = (nTmp >> 1);
			nRes = (nRes >> 1);

			ua -= nTmp;
			nRet += nRes;
		}

		return (int) (bNeg ? -nRet : nRet);
	}

}
