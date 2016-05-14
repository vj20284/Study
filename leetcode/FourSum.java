package com.practise.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

public class FourSum {
	@Test
	public void test() {
		//int[] array = new int[] {-1, 2, 1, -4, 4, -2, 6, -6, 0};
		int[] array = new int[] {1, 0, -1, 0, -2, 2};
		List<List<Integer>> quartets = fourSum(array, 0);
		for (List<Integer> quartet : quartets) {
			for (Integer curVal : quartet) {
				System.out.print(curVal + " ");
			}
			System.out.println("\n");
		}
	}

	public List<List<Integer>> fourSum (int[] array, int target) {
		List<List<Integer>> quartets = new ArrayList<List<Integer>>();		
		List<TwoSum> twoSums = new ArrayList<TwoSum>();
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1;  j < array.length; j++) {
				TwoSum ts = new TwoSum(array[i], i, array[j], j);
				twoSums.add(ts);
			}
		}
		Collections.sort(twoSums);
		
		for (int i = 0; i < twoSums.size(); i++) {
			TwoSum curSum = twoSums.get(i);
			if (curSum.sum > target)
				break;
			Integer diff = target - curSum.sum;
			for (int j = i + 1; j < twoSums.size(); j++) {
				TwoSum diffSum = twoSums.get(j);
				if (diffSum.sum == diff) {					
					if (!curSum.intersects(diffSum))
						System.out.print(curSum.val1 + " " + curSum.val2 + " " + diffSum.val1 + " " + diffSum.val2 + "\n");
				}
			}
		}
		
		return quartets;
	}
	
	class TwoSum implements Comparable {
		Integer sum;
		int val1;
		int val1Index;
		int val2;
		int val2Index;
		
		public TwoSum (int val1, int val1Index, int val2, int val2Index) {
			this.val1 = val1;
			this.val1Index = val1Index;
			this.val2 = val2;
			this.val2Index = val2Index;
			this.sum = this.val1 + this.val2;
		}
		
		public boolean intersects(TwoSum b) {
			boolean retVal = false;
			
			if (b.val1Index == val1Index || b.val1Index == val2Index || b.val2Index == val1Index || b.val2Index == val2Index) {
				retVal = true;
			}
			
			return retVal;
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			if (!(o instanceof TwoSum)) {
				throw (new IllegalArgumentException());
			}
			
			TwoSum obj = (TwoSum) o;
			return this.sum.compareTo(obj.sum);			
		}
	}
}
