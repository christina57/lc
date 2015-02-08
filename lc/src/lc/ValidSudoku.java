package lc;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidSudoku q = new ValidSudoku();
		char[][] board = {
				{'1','.', '.', '4', '.', '.' , '7', '.','9'},
				{'9','.', '.', '.', '.', '.' , '.', '.','.'},
				{'.','.', '2', '.', '.', '.' , '.', '.','.'},
				{'.','.', '.', '.', '.', '.' , '.', '.','.'},
				{'.','7', '3', '5', '.', '.' , '.', '.','.'},
				{'.','.', '.', '.', '.', '.' , '6', '.','.'},
				{'.','2', '.', '.', '.', '.' , '.', '.','.'},
				{'.','.', '4', '.', '.', '.' , '.', '.','.'},
				{'2','.', '.', '.', '.', '.' , '.', '7','.'},
				
		};
		//System.out.println(isValidArray(visited, board[0]));
		System.out.println(q.isValidSudoku(board));

	}
	public boolean isValidSudoku(char[][] board) {
		
		if ( board.length != 9  || board[0].length!=9 ){
			return false;
		}
		
		int[] line = new int[9];
		for ( int i=0; i<9; i++ ){
			line[i]=0;
		}
		
		for ( int i=0; i<9; i++ ){
			for ( int j=0; j<9; j++ ){
				if( board[i][j] != '.' ){
					int ind = board[i][j]-'0'-1;
					if ( line[ind] != 0){
						return false;
					} else {
						line[ind]++;
					}
				}
			}
			for ( int k=0; k<9; k++ ){
				line[k]=0;
			}
		}
		
		for ( int j=0; j<9; j++ ){
			for ( int i=0; i<9; i++ ){
				if( board[i][j] != '.' ){
					int ind = board[i][j]-'0'-1;
					if ( line[ind] != 0){
						return false;
					} else {
						line[ind]++;
					}
				}
			}
			for ( int k=0; k<9; k++ ){
				line[k]=0;
			}
		}
		
		for ( int i=0; i<9; i+=3 ){
			for ( int j=0; j<9; j+=3 ){
				for ( int a=i; a<(i+3); a++){
					for ( int b=j; b<(j+3); b++){
						if( board[a][b] != '.' ){
							int ind = board[a][b]-'0'-1;
							if ( line[ind] != 0){
								return false;
							} else {
								line[ind]++;
							}
						}
					}
				}
				for ( int k=0; k<9; k++ ){
					line[k]=0;
				}
			}
			
		}
		return true;
	}

}
