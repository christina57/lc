package lc;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean exist(char[][] board, String word) {
    	int row = board.length;
    	if(row==0 && word.equals("")){
    		return true;
    	}
    	if(row==0){
    		return false;
    	}
    	
    	int column = board[0].length;
        boolean[][] used = new boolean[row][column];
        for(int i=0;i<row;i++){
        	for(int j=0;j<column;j++){
        		used[i][j] = false;
        	}
        }
        
        return helper(board, word, used, 0, -1, -1);
        
    }
    
    private boolean helper(char[][] board, String word, boolean[][] used, int idx, int lastrow, int lastcolumn){
    	int row = board.length;
    	int column = board[0].length;
    	
    	if(idx == 0){
    		for(int i=0;i<row;i++){
            	for(int j=0;j<column;j++){
            		if(board[i][j] == word.charAt(idx)){
            			used[i][j] = true;
            			if(helper(board, word, used, idx+1, i, j)){
            				return true;
            			}
            			used[i][j] = false;
            		}
            	}
            }
    	} else if(idx == word.length()){
    		return true;
    	} else {
    		if(lastrow-1>=0 && !used[lastrow-1][lastcolumn] && board[lastrow-1][lastcolumn] == word.charAt(idx)){
    			used[lastrow-1][lastcolumn]=true;
    			if(helper(board, word, used, idx+1, lastrow-1, lastcolumn)){
    				return true;
    			}
    			used[lastrow-1][lastcolumn]=false;
    		}
    		if (lastcolumn+1<column && !used[lastrow][lastcolumn+1] && board[lastrow][lastcolumn+1] == word.charAt(idx)){
    			used[lastrow][lastcolumn+1]=true;
    			if(helper(board, word, used, idx+1, lastrow, lastcolumn+1)){
    				return true;
    			}
    			used[lastrow][lastcolumn+1]=false;
    		}
    		if (lastrow+1<row && !used[lastrow+1][lastcolumn] && board[lastrow+1][lastcolumn] == word.charAt(idx)){
    			used[lastrow+1][lastcolumn]=true;
    			if(helper(board, word, used, idx+1, lastrow+1, lastcolumn)){
    				return true;
    			}
    			used[lastrow+1][lastcolumn]=false;
    		}
    		if (lastcolumn-1>=0 && !used[lastrow][lastcolumn-1] && board[lastrow][lastcolumn-1] == word.charAt(idx)){
    			used[lastrow][lastcolumn-1]=true;
    			if(helper(board, word, used, idx+1, lastrow, lastcolumn-1)){
    				return true;
    			}
    			used[lastrow][lastcolumn-1]=false;
    		}
    	}
    	return false;
    }
}
