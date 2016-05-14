package com.practise.leetcode.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utils {
	private static final Random random = new Random();
	
	public static int[] GetRandomArray(int size) {
		int[] retArray = new int[size];
		for (int i = 0; i < size; i++) {
			retArray[i] = random.nextInt(size);
		}
		return retArray;
	}
	
	public static void PrintArray(int[] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void SortArray(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0 ; i < arr.length; i++) {
			list.add(arr[i]);
		}
		int k = 0;
		Collections.sort(list);
		for (Integer i : list) {
			arr[k++] = i;
		}
	}
}
