package com.practise.dynamicprog;

import java.util.HashMap;
import java.util.Map;

public class MinStepsToOne {
	static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
	static Map<Integer, Integer> nextMap = new HashMap<Integer, Integer>();
	static {
		memo.put(1, 1);
		nextMap.put(1, null);
		memo.put(2, 1);
		nextMap.put(2, 1);
		memo.put(3, 1);
		nextMap.put(3, 1);
	}
	
	public static int MinSteps(int num) {
		return min(num);
	}
	
	private static int min(int num) {
		if (memo.get(num) != null) {
			return memo.get(num);
		}
		
		int n1 = min(num - 1);
		int n2 = (num % 2 == 0 ? min(num/2) : 999);
		int n3 = (num % 3 == 0 ? min(num/3) : 999);
		int min = n1 > n2 ? ((n3 > n1) ? n2 : (n3 > n2 ? n2 : n3)) : (n3 > n1 ? n1 : n3);
		if (min == n3) 
			nextMap.put(num, num / 3);
		else if (min == n2) 
			nextMap.put(num, num / 2);
		else 
			nextMap.put(num, num - 1);
		memo.put(num, 1 + min);
		return 1 + min;
	}
	
	public static void main(String[] args) {
		int num = 37;
		System.out.println("\nNum Steps : " + MinSteps(num));
		int start = num;
		System.out.print(start);
		while (start != 1) {
			System.out.print(" " + nextMap.get(start));
			start = nextMap.get(start);
		}
	}
}