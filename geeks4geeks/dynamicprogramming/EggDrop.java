package com.practise.geeks4geeks.dynamicprogramming;

public class EggDrop {
	public int eggDrop(int n, int k) {
		int[][] soln = new int[n + 1][k + 1];
		int[][] floor = new int[n + 1][k + 1];
		
		for (int i = 1; i <= n; i++) {
			soln[i][1] = 1;
			soln[i][0] = 0;
		}
		
		for (int i = 1; i <=k ; i++) {
			soln[1][i] = i;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= k; j++) {
				soln[i][j] = Integer.MAX_VALUE;
				for (int x = 1; x <= j; x++) {
					int temp = 1 + Math.max(soln[i - 1][x - 1],
							soln[i][j - x]);
					if (temp < soln[i][j]) {
						floor[i][j] = x;
						soln[i][j] = temp;
					}
				}
			}
		}
		return soln[n][k];
	}
	
	public static void main(String[] args) {
		EggDrop ed = new EggDrop();
		
		System.out.println(ed.eggDrop(2, 8));
	}
}
