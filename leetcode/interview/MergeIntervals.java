package com.practise.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {

	// (1,3) (2,6) (8, 10) (15, 18)
	// (1, 6) (8, 10) (15, 18)
	public static List<Interval> mergeIntervals(List<Interval> intervals) {
		if (intervals == null) {
			return null;
		}

		Collections.sort(intervals, new IntervalComparator());
		
		List<Interval> retList = new ArrayList<Interval>();
		Iterator<Interval> intervalIterator = intervals.iterator();
		
		retList.add(new Interval(intervals.get(0)));
		int currentStart = intervals.get(0).start;
		int currentEnd = intervals.get(0).end;
		
		while (intervalIterator.hasNext()) {
			Interval curInterval = intervalIterator.next();
			if (curInterval.start > currentEnd) {
				Interval newInterval = new Interval(curInterval);
				retList.add(newInterval);
				currentEnd = newInterval.end;
			} else {
				Interval lastInterval = retList.get(retList.size() - 1);
				lastInterval.end = curInterval.end > currentEnd ? curInterval.end : currentEnd;
				currentEnd = lastInterval.end;
			}
		}
		
		return retList;
	}
	
	public static void printIntervals(List<Interval> intervals) {
		for (Interval i : intervals) {
			System.out.print(" " + " (" + i.start + ", " + i.end + ")");
		}
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);
		List<Interval> input = new ArrayList<Interval>();
		input.add(i1);
		input.add(i2);
		input.add(i3);
		input.add(i4);
		
		List<Interval> merged = mergeIntervals(input);
		printIntervals(merged);
	}
	
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}
