package com.practise.geeks4geeks.dynamicprogramming;

public class UglyNumber {
	public int getUgly(int index) {
		int[] uglyNums = new int[index];
		
		uglyNums[0] = 1;
		int i = 1;
		int[] multiples = new int[] {2, 3, 5};
		
		while (i < index) {
			int min = min(multiples);
			if (min == multiples[0])
				multiples[0] += 2;
			if (min == multiples[1])
				multiples[1] += 3;
			if (min == multiples[2])
				multiples[2] += 5;
			uglyNums[i++] = min;
		}
				
		return uglyNums[index - 1];
	}
	
	public int min(int[] multiples) {
		return Math.min(multiples[0], Math.min(multiples[1], multiples[2]));
	}
	
	public static void main(String[] args) {
		UglyNumber un = new UglyNumber();
		System.out.println(un.getUgly(100));
	}
}
