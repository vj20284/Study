package com.practise.leetcode;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class Power {

	public double ipow(double base, int exp)
	{
		boolean negativeExponent = false;
		if ( exp < 0 ) {
			exp = Math.abs(exp);
			negativeExponent = true;
		}
		double result = 1;
		while (exp > 0)
		{
			if (exp % 2 != 0 )
				result *= base;
			exp >>= 1;
			base *= base;
		}

		return negativeExponent ? 1/result : result;
	}


	public double power(double x, int n) {
		boolean negativeExponent = false;
		if ( n < 0 ) {
			n = Math.abs(n);
			negativeExponent = true;
		}
		double retval = 1;

		for (int i = 0 ; i < n ; i++) {
			retval = retval * x;
		}

		return negativeExponent ? 1/retval : retval;
	}

	@Test
	public void testpower() {
		double base = 3;
		int exponent = 4;
		double computedval = power(base, exponent);
		double computedval2 = ipow(base, exponent); 
		System.out.println(computedval);
		System.out.println(computedval2);
		Assert.assertEquals(BigDecimal.valueOf(computedval).setScale(4, BigDecimal.ROUND_HALF_EVEN), BigDecimal.valueOf( Math.pow(base, exponent)).setScale(4, BigDecimal.ROUND_HALF_EVEN));
		Assert.assertEquals(BigDecimal.valueOf(computedval2).setScale(4, BigDecimal.ROUND_HALF_EVEN), BigDecimal.valueOf( Math.pow(base, exponent)).setScale(4, BigDecimal.ROUND_HALF_EVEN));
	}
}
