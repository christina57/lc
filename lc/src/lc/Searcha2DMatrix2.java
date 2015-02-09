package lc;

import java.util.ArrayList;

public class Searcha2DMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        int row = matrix.size();
        if(row <1){
        	return 0;
        }
        int column = matrix.get(0).size();
        if(column < 1){
        	return 0;
        }
        
        int count = 0;
        int curow = row-1;
        int cucol = 0;
        
        while(curow>=0 && cucol<column){
        	int current =matrix.get(curow).get(cucol);
        	if(current > target){
        		curow--;
        	} else if(current < target){
        		cucol++;
        	} else {
        		count++;
        		curow--;
        		cucol++;
        	}
        }
        return count;
    }

}
