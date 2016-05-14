package com.practise.leetcode.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(Interval i) {
		start = i.start;
		end = i.end;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class InsertInterval {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		
		for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;        
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
 
        result.add(newInterval);
        return result;
	}
}
