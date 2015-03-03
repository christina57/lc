package lc;

import java.util.ArrayList;
import java.util.List;

public class NQueens2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int totalNQueens(int n) {
    	//List<String[]> result = new ArrayList<String[]>();
    	StringBuilder[] item = new StringBuilder[n];
    	char[] line = new char[n];
    	for(int i=0;i<n;i++){
    		line[i] = '.';
    	}
    	for(int i=0;i<n;i++){
    		item[i] = new StringBuilder(new String(line));
    	}
    	int[] count = new int[1];
    	helper(count, item, n, 0);
    	
    	return count[0];
    }

    private void helper(int[] count, StringBuilder[] item, int n, int line){
    	if(line==n){
    		count[0]++;
    		return;
    	}
    	
    	for(int j=0;j<n;j++){
    		if(!isConflict(item,n,line,j)){
    			item[line].replace(j, j+1, "Q");
    			helper(count, item, n, line+1);
    			item[line].replace(j, j+1, ".");
    		}
    	}
    }
    
    private boolean isConflict(StringBuilder[] result, int n, int i, int j){
    	
    	for(int k=0;k<n;k++){
    		if(result[i].charAt(k)=='Q'){
    			return true;
    		}
    		if(result[k].charAt(j)=='Q'){
    			return true;
    		}
    		
    	}
    	int k=1;
		while((i-k)>=0 && (j-k)>=0){
			if(result[i-k].charAt(j-k)=='Q'){
				return true;
			}
			k++;
		}
		k=1;
		while((i+k)<n && (j+k)<n){
			if(result[i+k].charAt(j+k)=='Q'){
				return true;
			}
			k++;
		}
		k=1;
		while((i+k)<n && (j-k)>=0){
			if(result[i+k].charAt(j-k)=='Q'){
				return true;
			}
			k++;
		}
		k=1;
		while((i-k)>=0 && (j+k)<n){
			if(result[i-k].charAt(j+k)=='Q'){
				return true;
			}
			k++;
		}
    	return false;
    }

}
