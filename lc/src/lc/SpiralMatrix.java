package lc;

import java.util.ArrayList;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[1][2];
		matrix[0][0]=2;
		matrix[0][1]=3;
		spiralOrder(matrix);

	}
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> finallist = new ArrayList<Integer>();
    	
        int row = matrix.length;
        if(row==0){
        	return finallist;
        } else {
	        int column = matrix[0].length;
	        
	        int level = (Math.min(row, column) + 1)/2;
	        
	        for(int i=0; i<level; i++ ){
	        	for(int j=0;j<(column-2*i);j++){
	        		finallist.add(matrix[i][i+j]);
	        	}
	        	for(int j=1;j<(row-2*i);j++){
	        		finallist.add(matrix[i+j][column-1-i]);
	        	}
	        	if(row-1-2*i != 0 && column-1-2*i != 0){
                    for(int j=1;j<(column-2*i);j++){
    		        	finallist.add(matrix[row-1-i][column-1-i-j]);
    		        }
	        	}
	        	if(row-1-2*i != 0 && column-1-2*i != 0){
    		        for(int j=1;j<(row-2*i-1);j++){
    		        	finallist.add(matrix[row-1-i-j][i]);
    		        }
	        	}
	        }
	    	
	    	return finallist;
        }
    }
    
    public static ArrayList<Integer> spiralOrder_old(int[][] matrix) {
    	ArrayList<Integer> finallist = new ArrayList<Integer>();
    	
        int row = matrix.length;
        if(row==0){
        	return finallist;
        } else {
	        int column = matrix[0].length;
	        
	        int level = (Math.min(row, column) + 1)/2;
	        
	        for(int i=0; i<level; i++ ){
	        	if(column-1-2*i != 0){
		        	for(int j=0;j<(column-2*i);j++){
		        		finallist.add(matrix[i][i+j]);
		        	}
	        	}
	        	if(row-1-2*i != 0){
	        		if(column-1-2*i != 0){
	        			finallist.remove(finallist.size()-1);
	        		}
		        	for(int j=0;j<(row-2*i);j++){
		        		finallist.add(matrix[i+j][column-1-i]);
		        	}
	        	}
	        	if(column-1-2*i != 0 && row-1-2*i != 0){
	        		finallist.remove(finallist.size()-1);
		        	for(int j=0;j<(column-2*i);j++){
		        		finallist.add(matrix[row-1-i][column-1-i-j]);
		        	}
	        	}
	        	if(row-1-2*i != 0 && column-1-2*i != 0){
	        		finallist.remove(finallist.size()-1);
		        	for(int j=0;j<(row-2*i);j++){
		        		finallist.add(matrix[row-1-i-j][i]);
		        	}
		        	finallist.remove(finallist.size()-1);
	        	}
	        	if (row-1-2*i == 0 && column-1-2*i == 0){
	        		finallist.add(matrix[i][i]);
	        	}
	        }
	    	
	    	return finallist;
        }
    }

}
