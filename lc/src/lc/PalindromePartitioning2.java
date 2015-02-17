package lc;

public class PalindromePartitioning2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(minCut("bb"));
	}

    public static int minCut(String s) {
        int len = s.length();
        
        boolean[][] result = new boolean[len][len];
        
        for(int i=len-1;i>=0;i--){
        	for(int j=0;j<len;j++){
        		if(i==j){
        			result[i][j] = true;
        		} else if (i<j) {
        			if(j==(i+1)){
        				result[i][j] = (s.charAt(i)==s.charAt(j));
        			}else{
        				result[i][j] = (result[i+1][j-1]) && (s.charAt(i)==s.charAt(j));
        			}
        		}
        	}
        }
        
        int[] cut = new int[len];
        
        for(int i=0;i<len;i++){
        	cut[i] = i+1;
        	for(int j=0;j<=i;j++){
        		if(result[j][i]){
        			if((j-1)<0){
        				cut[i]= Math.min(cut[i], 1);
        			} else {
        				cut[i]= Math.min(cut[i], cut[j-1]+1);
        			}
        		}
        	}
        }

        return (cut[len-1]-1);
    }
}
