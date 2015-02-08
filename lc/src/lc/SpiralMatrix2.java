package lc;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int level = (n + 1)/2;
        int current=1;
        
        for(int i=0; i<level; i++ ){
        	
        	for(int j=0;j<(n-2*i);j++){
        		matrix[i][i+j]=current;
        		current++;
        	}
        	for(int j=1;j<(n-2*i);j++){
        		matrix[i+j][n-1-i]=current;
        		current++;
        	}
            for(int j=1;j<(n-2*i);j++){
	        	matrix[n-1-i][n-1-i-j]=current;
	        	current++;
	        }
	        for(int j=1;j<(n-2*i-1);j++){
	        	matrix[n-1-i-j][i]=current;
	        	current++;
	        }
        }
        return matrix;
    }
}
