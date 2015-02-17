package lc;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minPathSum(int[][] grid) {
    	int row = grid.length;
    	
    	if(row == 0){
    		return 0;
    	}
    	int column= grid[0].length;
    	
    	if(column == 0){
    		return 0;
    	}
    	
    	int[][] sum = new int[row][column];
    	sum[0][0] = grid[0][0];
    	
    	for (int i=1; i<column;i++){
    		sum[0][i] = sum[0][i-1]+grid[0][i];
    	}
    	
    	for (int i=1; i<row;i++){
    		sum[i][0] = sum[i-1][0]+grid[i][0];
    	}
    	
    	for(int i=1; i<row; i++){
    		for(int j=1;j<column;j++){
    			sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1])+grid[i][j];
    		}
    	}
    	
    	return sum[row-1][column-1];
    }
}
