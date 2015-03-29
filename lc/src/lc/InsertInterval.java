package lc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> result = new LinkedList<Interval>();
    	
    	if(intervals == null || intervals.size()==0){
    		result.add(newInterval);
    		return result;
    	}
    	
        Iterator<Interval> iterator = intervals.iterator();
        boolean foundstart = false, foundend = false;
        int start=0, end=0;
        
        while(iterator.hasNext()){
        	Interval cur = iterator.next();
        	
        	if(!foundstart){
        		if(newInterval.start < cur.start){
            		start = newInterval.start;
            		foundstart = true;
            	} else if(newInterval.start <=cur.end){
            		start = cur.start;
            		foundstart = true;
            	}
        	}
        	
        	if(foundstart && !foundend){
        		if(newInterval.end < cur.start){
        			end = newInterval.end;
        			result.add(new Interval(start, end));
        			result.add(cur);
        			foundend = true;
        		} else if(newInterval.end<=cur.end){
        			end = cur.end;
        			result.add(new Interval(start, end));
        			foundend = true;
        		}
        	} else {
        		result.add(cur);
        	}
        	
        }
        
        if(!foundstart){
        	result.add(newInterval);
        } else if(!foundend){
        	end = newInterval.end;
        	result.add(new Interval(start, end));
        }
        return result;
    }
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}