package lc;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if(len3!=(len1+len2)){
        	return false;
        }
 
        boolean[][] result = new boolean[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++){
        	result[i][0] = (s1.substring(0, i).equals(s3.substring(0, i)));
        }
        for(int i=0;i<=len2;i++){
        	result[0][i] = (s2.substring(0, i).equals(s3.substring(0, i)));
        }
        
        for(int i=1;i<=len1;i++){
        	for(int j=1;j<=len2;j++){
        		result[i][j] = (result[i-1][j] & s1.charAt(i-1)==s3.charAt(i+j-1)) ||
        				(result[i][j-1] & s2.charAt(j-1)==s3.charAt(i+j-1));
        	}
        }
        return result[len1][len2];
    }
}
