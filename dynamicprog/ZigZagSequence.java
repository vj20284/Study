package com.practise.dynamicprog;

import java.util.ArrayList;
import java.util.List;

public class ZigZagSequence {
	public static int ZigZag(int[] input){
		int[] negatives = new int[input.length];
		int[] nprev = new int[input.length];
		int[] positives = new int[input.length];
		int[] pprev = new int[input.length];

		negatives[0] = 0;
		positives[0] = 0;

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i] - input[j] > 0) {
					int maxSeqIndex = Math.max(negatives[j] + 1, positives[i]);
					positives[i] = maxSeqIndex;
					pprev[i] = negatives[j] + 1 > positives[i] ? j : i;
				}
				else if (input[i] - input[j] < 0) {
					int maxSeqIndex = Math.max(positives[j] + 1, negatives[i]);
					negatives[i] = maxSeqIndex;
					nprev[i] = positives[j] + 1 > negatives[i] ? j : i;
				}
			}
		}
		int maxSequenceLength = Math.max(positives[input.length - 1], negatives[input.length - 1]);
		int[] maxArray = positives[input.length - 1] > negatives[input.length - 1] ? pprev : nprev;
		int index = input.length - 1;
		int count = 0;
		while (maxSequenceLength-- > 0) {
			System.out.print(maxArray[index]);
			index = maxArray[maxArray[index]];
		}
		return count;
	}

	public static void main(String[] args) {
		int[] input = new int[] {8, 1, 3, 5, 4, 3, 6, 2, 1};
		int rv = ZigZag(input);
		System.out.println("\n" + rv);
	}
}

/*
 * 1 3 4 7 8 2 4 9 10 11 5 13 4 2
 */
