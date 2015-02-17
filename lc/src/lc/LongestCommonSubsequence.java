package lc;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int longestCommonSubsequence(String A, String B) {
        int alen = A.length();
        int blen = B.length();
        
        if(alen==0 || blen==0){
        	return 0;
        }
        
        int[][] result = new int[alen+1][blen+1];
        
        for(int i=0; i<alen;i++){
        	result[i][0] =0;
        }
        for(int i=0; i<blen;i++){
        	result[0][i] =0;
        }
        
        
        for(int i=1; i<=alen;i++){
        	for(int j=1;j<=blen;j++){
        		if(A.charAt(i-1) == B.charAt(j-1)){
        			result[i][j]=result[i-1][j-1]+1;
        		} else {
        			result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
        		}
        	}
        }
        return result[alen][blen];
    }
    

}
