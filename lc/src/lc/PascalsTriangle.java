package lc;

import java.util.ArrayList;

public class PascalsTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> tria = new ArrayList<ArrayList<Integer>>();
    	
    	for (int i=0; i<=numRows; i++){
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		if(i==0){
    			row.add(1);
    			tria.add(row);
    		} else {
    			row.add(1);
    			for (int j=0;j<(i-1);j++){
    				ArrayList<Integer> prerow = tria.get(i-1);
    				int add1 = prerow.get(j);
    				int add2 = prerow.get(j+1);
    				row.add(add1+add2);
    			}
    			row.add(1);
    			tria.add(row);
    		}
    	}
    	return tria;
    }	
}
