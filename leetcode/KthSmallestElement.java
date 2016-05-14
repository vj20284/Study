package com.practise.leetcode;

public class KthSmallestElement {
	public static int KthSmallest(int[] input1, int[] input2, int k) {
		return compare(input1, input2, 0, input1.length - 1, 0, input2.length - 1, k);
	}
	
	private static int compare(int[] a, int[] b, int lowA, int highA, int lowB, int highB, int k) {
		if (highA == lowA && highB == lowB) {
			return a[highA] > b[highB] ? b[highB] : a[highA];
		}
		int i = (highA - lowA) / 2;
		int j = k - i - 1;
		int Ai = a[i];
		int Bj = b[j];
		int Ai_1 = a[i-1];
		int Bj_1 = b[j-1];
		
		if (Ai > Bj_1 && Ai < Bj) {
			return Ai;
		}
		if (Bj > Ai_1 && Bj < Ai) {
			return Bj;
		}
		if (Ai > Bj) 
			return compare(a, b, lowA, i - 1, j + 1, highB, k);
		else
			return compare(a, b, i + 1, highA, lowB, j - 1, k);
	}
	
	public static void main(String[] args) {
		//int[] input1 = new int[] {1, 3, 5, 7, 9, 11};
		//int[] input2 = new int[] {2, 4, 6, 8, 10, 12};
		
		int[] input1 = new int[] {4, 7, 40, 50, 60, 70, 80};
		int[] input2 = new int[] {1, 2, 3, 6, 8, 9, 10};
		
		int rv = KthSmallestElement.KthSmallest(input1, input2, 7);
		System.out.println(rv);
	}
}
