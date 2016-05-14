package com.practise.geeks4geeks.dynamicprogramming;

public class JumpGame {
	public int minJumps(int[] steps) {
		int[] soln = new int[steps.length];
		
		soln[0] = 0;
		
		for (int i = 1; i < steps.length; i++) {
			soln[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (steps[j] + j >= i && soln[j] + 1 < soln[i])
					soln[i] = soln[j] + 1;
			}
		}
		return soln[soln.length - 1];
	}
	
	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		
		int[] steps = new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		
		System.out.println(jg.minJumps(steps));
	}
}
