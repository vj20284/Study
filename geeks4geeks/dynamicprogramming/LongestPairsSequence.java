package com.practise.geeks4geeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestPairsSequence {

	public int longestSequence(List<Pair> pairs) {
		Collections.sort(pairs);
		int max = 1;
		int[] soln = new int[pairs.size() + 1];
		soln[0] = 1;
		for (int i = 1; i < pairs.size(); i++) {
			soln[i] = soln[i - 1];
			for (int j = 1; j < i; j++) {
				if (pairs.get(j).end < pairs.get(i).start &&
						soln[i] < soln[j] + 1) {
					soln[i] = soln[j] + 1;
				}
			}
			max = soln[i] > max ? soln[i] : max;
		}
		
		return max;
	}
	
	public static class Pair implements Comparable <Pair>{
		public int start;
		public int end;
		
		public Pair(int a, int b) {
			this.start = a;
			this.end = b;
		}

		@Override
		public int compareTo(Pair arg) {
			return this.start - arg.start != 0 ? 
					this.start - arg.start :
					this.end - arg.end;
		}	
	}
	
	public static void main(String[] args) {
		LongestPairsSequence lps = new LongestPairsSequence();
		Pair p1 = new LongestPairsSequence.Pair(5, 16);
		Pair p2 = new LongestPairsSequence.Pair(7, 14);
		Pair p3 = new LongestPairsSequence.Pair(15, 19);
		Pair p4 = new LongestPairsSequence.Pair(16, 20);
		Pair p5 = new LongestPairsSequence.Pair(22, 24);
		
		List<Pair> pairs = new ArrayList<Pair>();
		pairs.add(p1);
		pairs.add(p2);
		pairs.add(p3);
		pairs.add(p4);
		pairs.add(p5);
		
		System.out.println(lps.longestSequence(pairs));
	}
}
