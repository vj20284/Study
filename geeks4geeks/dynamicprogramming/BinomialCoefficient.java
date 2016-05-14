package com.practise.geeks4geeks.dynamicprogramming;

public class BinomialCoefficient {
	public int biCoeff(int n, int k) {
		int[] soln = new int[k + 1];
		soln[0] = 1;
		for (int i = 1; i <= n; i++) {
			// Each iteration, consider j as C(n, j) where j goes
			// from k to 1. Each iteration one row is computed
			// Next itration uses the previously computed row
			for (int j = Math.min(i, k); j > 0; j--) {
				soln[j] = soln[j] + soln[j - 1];
			}
		}
		return soln[k];
	}
	
	public static void main(String[] args) {
		BinomialCoefficient bc = new BinomialCoefficient();
		System.out.println(bc.biCoeff(7,  4));
	}
}
