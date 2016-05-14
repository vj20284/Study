package com.practise.leetcode.interview;

public class MergeSorted {
	public static void Merge(int a[], int m, int b[], int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i > 0 && j > 0) {
			if (a[i] >= b[j]) {
				a[k] = a[i];
				i--;
			} else {
				a[k] = b[j];
				j--;
			}
			k--;
		}
		while (j > 0) {
			a[k--] = b[j--];
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = Utils.GetRandomArray(20);
		int[] arr2 = Utils.GetRandomArray(13);
		Utils.SortArray(arr1);
		Utils.SortArray(arr2);
		Utils.PrintArray(arr1);
		Utils.PrintArray(arr2);
		Merge(arr1, arr1.length - arr2.length - 1, arr2, arr2.length);
		Utils.PrintArray(arr1);
	}
}
