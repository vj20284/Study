package com.practise.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class RainTrap {
	
	@Test
	public void rainTrapTest() {
		int array[] = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		//int array[] = new int[] {3, 2, 0, 1, 4, 1, 2, 3, 1};
		//int array[] = new int[] {3, 2, 0, 1, 0, 2, 4};
		//int array[] = new int[] {3, 2, 0, 1, 0, 2, 4, 0, 2};
		rainTrap(array);
	}
	
	public void rainTrap(int[] elevation) {
		HashMap<Integer, List<Integer>> segments = new HashMap<Integer, List<Integer>>();
		int last = 0;
		int current = 1;
		boolean hasDecreased = false;
		boolean hasIncreased = false;
		int startIndex = 0;
		int endIndex = 0;
		int segmentCount = 0;
		while (current < elevation.length) {
			if (elevation[current] < elevation[last] && hasDecreased == false) {				
				hasDecreased = true;
				if(current > 0 && elevation[current - 1] > elevation[current])
					startIndex = current - 1;
			}
			if (current == elevation.length - 1) {
				if (elevation[current] > elevation[last]) {
					endIndex = current;
					segments.put(segmentCount++, addSegmentValues(elevation, startIndex, endIndex));
				}
			}
			if (elevation[current] < elevation[last] && hasDecreased == true && hasIncreased == true) {				
				hasDecreased = false;
				hasIncreased = false;
				endIndex = last;				
				segments.put(segmentCount++, addSegmentValues(elevation, startIndex, endIndex));
				current = last;
				last = last - 1;
				continue;
			}
			if (elevation[current] > elevation[last] && hasDecreased == true) {
				hasIncreased = true;
			}
			last = current;
			current = current + 1;			
		}
		displaySegments(segments);
		segments = combineSegments(segments);
		displaySegments(segments);
		System.out.println("Total Capacity : " + getTotalCapacity(segments));
	}
	
	public List<Integer> addSegmentValues(int[] elevation, int startIndex, int endIndex) {
		List<Integer> segmentValues = new ArrayList<Integer>();
		for (int j = startIndex; j <= endIndex; j++) {
			segmentValues.add(elevation[j]);
		}
		return segmentValues;
	}
	
	public HashMap<Integer, List<Integer>> combineSegments(HashMap<Integer, List<Integer>> segments) {
		HashMap<Integer, List<Integer>> newSegments = new HashMap<Integer, List<Integer>>();
		boolean skipNext = false;
		for (int i = 0 ; i < segments.size() - 1 ; i++) {
			if (skipNext) 
			{
				skipNext = false;
				continue;
			}
			List<Integer> segment1 = segments.get(i);
			List<Integer> segment2 = segments.get(i+1);
			
			if (segment2.get(0) < segment1.get(0)) {
				segment1.remove(segment1.size() - 1);
				segment1.addAll(segment2);
				skipNext = true;
			}			
			newSegments.put(i, segment1);
		}
		if (!skipNext) {
			newSegments.put(segments.size() - 1, segments.get(segments.size() - 1));
		}
		return newSegments;
	}
	
	public int getTotalCapacity(HashMap<Integer, List<Integer>> segments) {
		int totalCapacity = 0;
		for (Integer key : segments.keySet()) {
			List<Integer> values = segments.get(key);
			totalCapacity += getCapacity(values);
		}
		return totalCapacity;
	}
	
	public void displaySegments(HashMap<Integer, List<Integer>> segments) {
		for (Integer key : segments.keySet()) {
			List<Integer> values = segments.get(key);
			System.out.print("Segment " + key + " : ");
			for (Integer val : values) {
				System.out.print(val + " ");
			}
			System.out.print(" Capacity : " + getCapacity(values));
			System.out.println();
		}
	}
	
	public int getCapacity(List<Integer> segments) {
		int lowerHt = segments.get(0) > segments.get(segments.size() - 1) ? segments.get(segments.size() - 1) : segments.get(0);
		int maxCapacity = lowerHt * (segments.size() - 2); 
		
		for (int i = 1; i < segments.size() - 1; i++) {
			maxCapacity -= segments.get(i);
		}
		
		return maxCapacity;
	}
}
