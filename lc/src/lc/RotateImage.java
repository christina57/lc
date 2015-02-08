package lc;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        
        if(row!=column){
        	return;
        } else {
        	int swap = 0;
            for(int i=0; i<row/2; i++){
            	for(int j=0; j<(row+1)/2; j++){
            		swap = matrix[i][j];
            		matrix[i][j] = matrix[row-1-j][i];
            		matrix[row-1-j][i] = matrix[row-1-i][row-1-j];
            		matrix[row-1-i][row-1-j] = matrix[j][row-1-i];
            		matrix[j][row-1-i] = swap;
            	}
            }
        }
    	
    }
}
