package lc;

import java.util.Iterator;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    /*public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Iterator<Interval> iterator = intervals.iterator();
        
    }*/
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}