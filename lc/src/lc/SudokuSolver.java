package lc;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void solveSudoku(char[][] board) {
    	char[][] result = new char[9][9];
    	try{
    		helper(board, 0, 0, result);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        /*for(int p=0;p<9;p++){
			for(int q=0;q<9;q++){
				board[p][q] = result[p][q];
			}
		}*/
    }
    
    private void helper(char[][] board, int i, int j, char[][] result) throws Exception{
    	if(i==9){
    		/*for(int p=0;p<9;p++){
    			for(int q=0;q<9;q++){
    				result[p][q] = board[p][q];
    			}
    		}*/
    		throw (new Exception());
    		//return;
    	}
    	if(board[i][j]=='.'){
    		for(int k=1;k<10;k++){
    			if(isValid(board, i, j, k)){
    				board[i][j] =(char)('0'+k);
    				if(j==8){
    					helper(board, i+1, 0, result);
    				} else {
    					helper(board, i, j+1, result);
    				}
    				board[i][j]='.';
    			}
    		}
    	}
    	else {
    		if(j==8){
				helper(board, i+1, 0, result);
			} else {
				helper(board, i, j+1, result);
			}
    	}
    }
    
    private boolean isValid(char[][] board, int i, int j, int num){
    	for(int k=0;k<9;k++){
    		if(board[i][k]==(char)('0'+num)){
    			return false;
    		}
    	}
    	for(int k=0;k<9;k++){
    		if(board[k][j]==(char)('0'+num)){
    			return false;
    		}
    	}
    	
    	for(int p=(i-i%3);p<(i-i%3+3);p++){
    		for(int q=(j-j%3);q<(j-j%3+3);q++){
    			if(board[p][q]==(char)('0'+num)){
    				return false;
    			}
    		}
    	}
    
    	return true;
    }
    
}
