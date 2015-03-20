package lc;

import java.util.HashMap;

public class MaxPointsonaLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] p = {new Point(2,3), new Point(3,3), new Point(-5, 3)};
		System.out.println(maxPoints(p));
		
	}
    public static int maxPoints(Point[] points) {
    	if(points.length == 0){
    		return 0;
    	}
    	if(points.length == 1){
    		return 1;
    	}
    		
    	int max=2;
        for(int i=0;i<(points.length-1);i++){
        	int cur_max=0;
        	int duplicate =1;
        	HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        	
        	for(int j=i+1;j<points.length;j++){
        		if(points[i].x == points[j].x && points[i].y == points[j].y){
        			duplicate++;
        		} else if(points[i].x == points[j].x){
        			double slope = Integer.MAX_VALUE;
        			if(map.containsKey(slope)){
            			map.put(slope, map.get(slope)+1);
            		} else {
            			map.put(slope, 1);
            		}
        			cur_max = Math.max(cur_max, map.get(slope));
        		} else if (points[i].y == points[j].y){
        			if(map.containsKey(0.0)){
            			map.put(0.0, map.get(0.0)+1);
            		} else {
            			map.put(0.0, 1);
            		}
        			cur_max = Math.max(cur_max, map.get(0.0));
        		} else{
        			double slope = (double)(points[i].y - points[j].y)/(double)(points[i].x - points[j].x);
        			//System.out.println(slope);
            		if(map.containsKey(slope)){
            			map.put(slope, map.get(slope)+1);
            		} else {
            			map.put(slope, 1);
            		}
            		cur_max = Math.max(cur_max, map.get(slope));
        		}
        	}
        	
        	max = Math.max(max, cur_max+duplicate);
        }
        return max;
    }
}

class Point {
	 int x;
	 int y;
	 Point() { x = 0; y = 0; }
	 Point(int a, int b) { x = a; y = b; }
}
