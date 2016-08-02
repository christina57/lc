package lc;

/**
 * Created by zzren on 8/1/2016.
 */
public class GameofLife {
    public void gameOfLife(int[][] board) {

        //0: dead to dead
        //1: live to live
        //2: live to dead
        //3: dead to live

        int row = board.length;
        if(row == 0){
            return;
        }
        int column = board[0].length;
        if(column == 0){
            return;
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                int neighbor = 0;
                for(int a=i-1;a<=i+1;a++){
                    for(int b=j-1;b<=j+1;b++){
                        if(a>=0 && a<row && b>=0 && b<column && !(a == i && b == j)){
                            if(board[a][b] == 1 || board[a][b] == 2){
                                neighbor++;
                            }
                        }
                    }
                }

                if(board[i][j] == 1){
                    if(neighbor < 2 || neighbor > 3){
                        board[i][j] = 2;
                    }
                } else {
                    if(neighbor == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                board[i][j] %= 2;
            }
        }
    }
}
