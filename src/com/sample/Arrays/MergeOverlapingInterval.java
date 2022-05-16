package com.sample.Arrays;

import java.util.*;

class Interval {
	int start;
	int end;
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class MergeOverlapingInterval {	
	public static ArrayList<Interval> mergeOverlapingInterval (ArrayList<Interval> intervals) {
		if (intervals.size() <2) { //if only 1 pair is present.
			return intervals;
		}		
		ArrayList<Interval> output = new ArrayList<>();
		// Sort Interval based on the basis of start attribute
		Collections.sort(intervals,(a,b)-> Integer.compare(a.start,b.start));
		
		Interval temp = intervals.get(0);
		int first = temp.start;
		int second = temp.end;
		
		for (int i=0; i<intervals.size(); i++) {
			temp = intervals.get(i);
			if (temp.start <= second) {
				second = Math.max(second,temp.end);
			}else {
				output.add(new Interval(first,second));
				first = temp.start;
				second = temp.end;
			}
		}
		output.add(new Interval(first,second));		
		return output;
	}

	public static void main(String[] args) {
		ArrayList<Interval> output = new ArrayList<>();
		output.add(new Interval(1, 5));
		output.add(new Interval(3, 7));
		output.add(new Interval(4, 6));
		output.add(new Interval(6, 8));
		output.add(new Interval(10, 12));
		output.add(new Interval(11, 15));
	    ArrayList<Interval> result = mergeOverlapingInterval(output);
	    for(int i=0; i<result.size(); i++){
	      System.out.print(String.format("[%d, %d] ", result.get(i).start, result.get(i).end));
	    }
	}

}
