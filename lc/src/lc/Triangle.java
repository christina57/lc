package lc;

import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	int row = triangle.size();
    	
    	if(row == 0){
    		return 0;
    	}
    	int maxline = triangle.get(row-1).size();
    	
    	int[] result = new int[maxline];
    	
    	for (int i =0; i< row; i++){
    		List<Integer> line = triangle.get(i);
    		if ( i ==0){
    			result [0] = line.get(0);
    		} else {
    			int line_size = line.size();
    			for(int j=line_size-1; j>=0; j--){
    				if(j == (line_size-1)){
    					result[j] = result[j-1]+line.get(j);
    				} else if ( j == 0) {
    					result[j] = result[j]+ line.get(j);
    				} else {
    					result[j] = Math.min(result[j], result[j-1])+line.get(j);
    				}
    			}
    		}
    	}
    	
    	int min_result =result[0];
    	for(int i =1; i<maxline; i++){
    		if(result[i]<min_result){
    			min_result = result[i];
    		}
    	}
    	return min_result;
    }
}
