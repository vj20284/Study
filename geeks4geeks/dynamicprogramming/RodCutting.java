package com.practise.geeks4geeks.dynamicprogramming;

public class RodCutting {
	int cutRod(int price[]) {
		int[] soln = new int[price.length];
		soln[0] = price[0];
		
		for (int i = 1; i < price.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, price[j] + soln[i - j - 1]);
			}
			soln[i] = max;
		}
		
		return soln[price.length - 1];
	}
}
