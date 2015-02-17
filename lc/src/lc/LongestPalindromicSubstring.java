package lc;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String longestPalindrome(String s) {
        int len = s.length();
        
        boolean[][] result = new boolean[len][len];
        int max = 1;
        int start=0, end=0;
        
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
        			if(result[i][j] && (j-i+1)>max){
    					start=i;
    					end=j;
    					max = j-i+1;
    				}
        		}
        	}
        }
        return s.substring(start, end+1);
    }
}
