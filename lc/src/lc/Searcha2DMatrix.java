package lc;

public class Searcha2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean searchMatrix(int[][] matrix, int target) {
    	int row= matrix.length;
    	if(row<1){
    		return false;
    	}
    	int column = matrix[0].length;
    	if(column<1){
    		return false;
    	}
    	
    	int start =0;
    	int end = row-1;
    	
    	while(start+1<end){
    		int mid = start+(end-start)/2;
    		if(matrix[mid][0]> target){
    			end = mid-1;
    		} else if(matrix[mid][0] < target) {
    			start = mid;
    		} else {
    			return true;
    		}
    	}
    	
    	int selected_row;
    	
    	if(target >= matrix[start][0] && target <= matrix[start][column-1]){
    		selected_row= start;
    	} else if(target >= matrix[end][0] && target <= matrix[end][column-1]){
    		selected_row= end;
    	} else {
    		return false;
    	}
    	
		int lstart = 0;
		int lend = column -1;
    	while(lstart+1<lend){
    		int lmid = lstart+(lend-lstart)/2;
    		if(matrix[selected_row][lmid]> target){
    			lend = lmid-1;
    		} else if(matrix[selected_row][lmid] < target) {
    			lstart = lmid+1;
    		} else {
    			return true;
    		}
    	}
    	if(matrix[selected_row][lstart]==target || matrix[selected_row][lend]==target){
    		return true;
    	} else {
    		return false;
    	}
    }
}
