package com.practise.leetcode;

import java.lang.reflect.Field;

import org.junit.Test;

public class MaximumSubsequence {
	@Test
	public void testMaxSubSum() {
		int array[] = new int[] {1, 0, -5, -1, 2, 4, 3, -1, -2, 5, -1};
		maxSubSum(array);	
	}
	
	public int maxSubSum(int[] a)
	{		
		int maxSum = 0;
		int thisSum = 0;
		int seqStart = 0;
		int seqEnd = 0;

		for( int i = 0, j = 0; j < a.length; j++ )
		{
			thisSum += a[j];

			if( thisSum > maxSum )
			{
				maxSum = thisSum;
				seqStart = i;
				seqEnd   = j;
			}
			else if( thisSum < 0 )
			{
				i = j + 1;
				thisSum = 0;
			}
		}
		System.out.println("Max Sum : " + maxSum + " " + seqStart + " " + seqEnd);
		return maxSum;
	}
}