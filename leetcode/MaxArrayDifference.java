package com.practise.leetcode;

public class MaxArrayDifference {
	public static int ArrayDifference(int[] input) {
		int[] minPtrs = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			minPtrs[i] = -1;
		}
		int min = 9999;
		int minIndex = 0;
		for (int i = 0; i < input.length; i++) {
			int val = input[i];
			if (val < min) {
				minPtrs[i] = i;
				minIndex = i;
				min = val;
			} else {
				minPtrs[i] = minIndex;
			}
		}
		int maxDiff = 0;
		int maxValIndex = -1;
		int minValIndex = -1;
		for (int k = input.length - 1; k > 0; k--) {
			int val = input[k];
			int valMinIndex = input[minPtrs[k]];
			if (val - valMinIndex > maxDiff) {
				maxDiff = val - valMinIndex;
				maxValIndex = k;
				minValIndex = minPtrs[k];
			}
		}
		System.out.println("Max Diff : " + maxDiff);
		if (maxValIndex != -1 && minValIndex != -1) {
			System.out.println("Val Max : " + input[maxValIndex]);
			System.out.println("Val Min : " + input[minValIndex]);
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		int[] input = new int[10];
		for (int i = 0; i < input.length; i++) {
			input[i] = (int) (Math.random() * 100);
		}
		printArray(input); 
		int val = MaxArrayDifference.ArrayDifference(input);
		System.out.println(val);
	}

	public static void printArray(int[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(" " + input[i]);
		}
		System.out.println();
	}
}
