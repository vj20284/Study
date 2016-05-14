package com.practise.algorithms;

public class ClosestPower {
	public static int closestPower(int base, int value) {
		if (base == 2) 
			return closestPowerTwo(value);
		int tmp = 1;
		int lastDiff = value - tmp;
		int count = 0;
		while (true) {
			tmp = tmp * base;
			int diff = value - tmp;
			if (diff <= 0) {
				diff = tmp - value;
				if (diff < lastDiff) {
					return count + 1;
				}
				else
					return count;
			}
			lastDiff = diff;
			count++;
		}
	}
	
	public static int closestPowerTwo(int value) {
		int count = 0;
		while (value > 0) {
			value = value >> 1;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int base = 2;
		int value = 64;
		int rv = ClosestPower.closestPower(base, value);
		System.out.println("Closest power : " + rv);
	}
}

/*
 * 2 ---- 9
 * 2  --- 7
 * 4  --- 5
 * 8  --- 1
 * 16 --- -7
 * 32
 * 64
 * 
 * 65
 * 32
 * 16
 * 8
 * 4
 * 2
 * 1
 * 
 */
