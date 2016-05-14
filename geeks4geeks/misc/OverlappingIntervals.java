package com.practise.geeks4geeks.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.practise.util.Interval;

public class OverlappingIntervals {
	public int overlapping(List<Interval> intervals) {
		Collections.sort(intervals);
		Interval last = intervals.get(0);
		int overlap = 1;
		int mergeEnd = last.end;
		int max = 0;
		
		for (int i = 1; i < intervals.size(); i++) {
			System.out.println("Merge end : " + mergeEnd + " Last End : " + last.end);
			Interval cur = intervals.get(i);
			if (cur.start < mergeEnd) {
				if (cur.start < last.end){
					System.out.println("Overlap cur start : " + cur.start + " less than last end : " + last.end);
					overlap++;
				} else {
					max = overlap > max ? overlap : max;
				}
			} else {
				overlap--;
			}
			mergeEnd = cur.end > mergeEnd ? cur.end : mergeEnd;
			last = cur;
			System.out.println("Overlap : "  + overlap);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval(0, 1);
		Interval i2 = new Interval(2, 8);
		Interval i3 = new Interval(3, 4);
		Interval i4 = new Interval(5, 10);
		Interval i5 = new Interval(9, 15);
		Interval i6 = new Interval(11, 13);
		Interval i7 = new Interval(12, 18);
		Interval i8 = new Interval(14, 16);
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);
		intervals.add(i6);
		intervals.add(i7);
		intervals.add(i8);

		OverlappingIntervals oi = new OverlappingIntervals();
		System.out.println(oi.overlapping(intervals));
	}
}
