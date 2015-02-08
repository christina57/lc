package lc;

import java.util.ArrayList;

public class PascalsTriangle2 {
	public static void main(String[] args){
		System.out.print(getRow(2));
	}

    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        
    	for (int i=0; i<=rowIndex; i++){
    		if(i==0){
    			row.add(1);
    		} else {
    			int middle = 1;
    			for (int j=0;j<(i-1);j++){
    				int add1 = middle;
    				int add2 = row.get(j+1);
    				row.set(j+1, add1+add2);
    				middle = add2;
    			}
    			row.add(1);
    		}
    	}
    	return row;
    }
}
