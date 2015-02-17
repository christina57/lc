package lc;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int longestCommonSubstring(String A, String B) {
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
        
        int max =0;
        for(int i=1; i<=alen;i++){
        	for(int j=1;j<=blen;j++){
        		if(A.charAt(i-1) == B.charAt(j-1)){
        			result[i][j]=result[i-1][j-1]+1;
        		} else {
        			result[i][j] = 0;
        		}
        		max = Math.max(max, result[i][j]);
        	}
        }
        return max;
        
    }
}
