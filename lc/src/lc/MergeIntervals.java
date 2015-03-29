package lc;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Interval> merge(List<Interval> intervals) {
    	
    	if(intervals == null || intervals.size()==0 || intervals.size()==1){
    		return intervals;
    	}
    	Comparator<Interval> comp = new Comparator<Interval>(){
    		public int compare(Interval v1, Interval v2){
    			return (v1.start-v2.start);
    		}
    	};
    	Collections.sort(intervals, comp);
    	
    	List<Interval> result = new LinkedList<Interval>();
        Iterator<Interval> iterator = intervals.iterator();
        Interval pre = iterator.next();
        int start=pre.start, end=pre.end;
        
        while(iterator.hasNext()){
        	Interval cur = iterator.next();
        	
        	if(cur.start > end){
        		result.add(new Interval(start, end));
        		start = cur.start;
        		end = cur.end;
        	} else {
        		end = Math.max(end, cur.end);
        	}
        }
        
        result.add(new Interval(start, end));
        
        return result;
    }
}
