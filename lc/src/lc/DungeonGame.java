package lc;

public class DungeonGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int calculateMinimumHP(int[][] dungeon) {
    	int row = dungeon.length;
    	if(row == 0){
    		return 0;
    	}
    	int column = dungeon[0].length;
    	
        int[][] minrequire = new int[row][column];
        
        for(int i=row-1;i>=0;i--){
        	for(int j=column-1;j>=0;j--){
        		if(i==row-1 && j==column-1){
        			minrequire[i][j] = 1 - dungeon[i][j];
        		} else {
	        		int next1 = (i+1<row)?minrequire[i+1][j]:Integer.MAX_VALUE;
	        		int next2 = (j+1<column)?minrequire[i][j+1]:Integer.MAX_VALUE;
	        		minrequire[i][j] = Math.min(next1, next2) - dungeon[i][j];
        		}
        		minrequire[i][j] = minrequire[i][j]<0?1:minrequire[i][j];
        	}
        }

        return minrequire[0][0];
    }
}
