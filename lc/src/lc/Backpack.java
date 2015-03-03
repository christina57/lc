package lc;

public class Backpack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int backPack(int m, int[] A) {
       int len = A.length;
       boolean[][] result = new boolean[len+1][m+1];
       result[0][0]=true;
       
       for(int j=1;j<=m;j++){
    	   result[0][j]=false;
       }
       for(int i=1;i<=len;i++){
    	   result[i][0]=true;
       }
       int max=0;
       for(int j=1;j<=m;j++){
    	   for(int i=1;i<=len;i++){
    		   result[i][j] = result[i-1][j] || ((j-A[i-1])>=0 && result[i-1][j-A[i-1]]);
    		   if(result[i][j] && j>max){
    			   max = j;
    		   }
    	   }
       }
       return max;
    }

}
