package lc;

import java.util.LinkedList;

public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void solve(char[][] board) {
    	int row = board.length;
    	if(row==0){
    		return;
    	}
    	int column = board[0].length;
        boolean[][] used = new boolean[row][column];
        for(int i=0;i<row;i++){
        	for(int j=0;j<column;j++){
        		used[i][j]=false;
        	}
        }
        for(int k=0;k<column;k++){
        	if(board[0][k]=='O'){
        		traceO(0, k, board, used);
        	}
        	if(board[row-1][k]=='O'){
        		traceO(row-1, k, board, used);
        	}
        }
        
        for(int k=1;k<(row-1);k++){
        	if(board[k][0]=='O'){
        		traceO(k, 0, board, used);
        	}
        	if(board[k][column-1]=='O'){
        		traceO(k, column-1, board, used);
        	}
        }
        
        for(int i=0;i<row;i++){
        	for(int j=0;j<column;j++){
        		if(board[i][j]=='O' && !used[i][j]){
        			board[i][j]='X';
        		}
        	}
        }
    }
    private void traceO(int a, int b, char[][] board, boolean[][] used){
    	int row = board.length;
    	int column = board[0].length;
    	
		LinkedList<Integer> qrow = new LinkedList<Integer>();
		LinkedList<Integer> qcolumn = new LinkedList<Integer>();
		qrow.offer(a);
		qcolumn.offer(b);
		used[a][b]=true;
		while(!qrow.isEmpty()){
			int i = qrow.poll();
			int j = qcolumn.poll();
			
			if(isValidNode(row, column, i,j-1) && board[i][j-1]=='O' && !used[i][j-1]){
				qrow.offer(i);
				qcolumn.offer(j-1);
				used[i][j-1]=true;
			}
			
			if(isValidNode(row, column, i,j+1) && board[i][j+1]=='O' && !used[i][j+1]){
				qrow.offer(i);
				qcolumn.offer(j+1);
				used[i][j+1]=true;
			}
			
			if(isValidNode(row, column, i-1,j) && board[i-1][j]=='O' && !used[i-1][j]){
				qrow.offer(i-1);
				qcolumn.offer(j);
				used[i-1][j]=true;
			}
			
			if(isValidNode(row, column, i+1,j) && board[i+1][j]=='O' && !used[i+1][j]){
				qrow.offer(i+1);
				qcolumn.offer(j);
				used[i+1][j]=true;
			}
		}
    }
    
    private boolean isValidNode(int row, int column, int i, int j){
    	if(i<row && i>=0 && j<column && j>=0){
    		return true;
    	} else {
    		return false;
    	}
    }
}
