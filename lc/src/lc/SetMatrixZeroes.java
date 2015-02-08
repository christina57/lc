package lc;

public class SetMatrixZeroes {
	public static void main (String[] args){
		int[][] matrix = new int[1][2];
		matrix[0][0]=0;
		matrix[0][1]=1;
		setZeroes(matrix);
		//System.out.print(matrix);
		
	}

    public static void setZeroes(int[][] matrix) {
    
        int row = matrix.length;
        int column = matrix[0].length;
        
    	int column1 = 1;
    	for ( int i=0; i<row; i++ ){
    		if ( matrix[i][0] == 0 ){
    			column1 = 0;
    			break;
    		}
    	}
    	int row1 = 1;
    	for ( int j=0; j<column; j++ ){
    		if ( matrix[0][j] == 0 ){
    			row1 = 0;
    			break;
    		}
    	}
    	
    	for ( int i=1; i<row; i++ ){
    		for( int j=1; j<column; j++){
    			if( matrix[i][j] == 0 ){
    				matrix[i][0] =0;
    				matrix[0][j] =0;
    			}
    		}
    	}
    	
    	for ( int i=1; i<row; i++ ){
    		if( matrix[i][0] == 0 ){
    			for( int j=1; j<column; j++){
    				matrix[i][j] =0;
    			}
    		}
    	}
    	
    	for ( int j=1; j<column; j++ ){
    		if( matrix[0][j] == 0 ){
    			for( int i=1; i<row; i++){
    				matrix[i][j] =0;
    			}
    		}
    	}
    		
    	if(column1 == 0){
    		for ( int i=0; i<row; i++ ){
        		matrix[i][0] = 0;
    		}
    	}
    	
    	if(row1 == 0){
    		for ( int j=0; j<column; j++ ){
        		matrix[0][j] = 0;
    		}
    	}
    }
}
