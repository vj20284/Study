package com.practise.leetcode;

import java.util.*;

public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	    ArrayList<Interval> result = new ArrayList<Interval>();
        boolean isLarge = true;
        
        for (Interval it : intervals)
        {
            if (it.end < newInterval.start) // curInterval is before new interval and no intersection
            {
                result.add(it);
                continue;
            }
            if (it.start > newInterval.end)   // curInterval starts after new interval and no intersection
            {
                if (isLarge)    // if new interval hasn't been added yet add new interval
                {
                    result.add(newInterval);
                    isLarge = false;
                }
                result.add(it);   // add current interval
                continue;
            }
            // curinterval and new interval merge --- adjust new interval's start and end
            newInterval.start = (it.start < newInterval.start) ? it.start : newInterval.start;
            newInterval.end = (it.end > newInterval.end) ? it.end : newInterval.end;
        }
        
        if (isLarge)
            result.add(newInterval);
		
		return result;
	}

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}
