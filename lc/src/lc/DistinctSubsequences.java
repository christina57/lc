package lc;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numDistinct(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        
        if(len1<len2){
        	return 0;
        }
        
        int[][] result = new int[len1+1][len2+1];
        
       
        for(int i=0;i<=len2;i++){
        	result[0][i] =0;
        }
        for(int i=0;i<=len1;i++){
        	result[i][0] =1;
        }
        
        for(int i=1;i<=len1;i++){
        	for(int j=1;j<=len2;j++){
        		if(S.charAt(i-1) == T.charAt(j-1)){
        			result[i][j] = result[i-1][j]+result[i-1][j-1];
        		} else {
        			result[i][j] = result[i-1][j];
        		}
        	}
        }
        return result[len1][len2];
    }
}
