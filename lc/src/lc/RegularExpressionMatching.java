package lc;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}
	
    public static boolean isMatch(String s, String p) {
    	int len1 = s.length();
    	int len2 = p.length();
    	
    	boolean[][] result = new boolean[len1+1][len2+1];
    	
    	result[0][0] = true;
    	
    	
    	for(int i=1;i<=len1;i++){
    		result[i][0] = false;
    	}
    	
    	for(int i=0;i<=len1;i++){
    		for(int j=1;j<=len2;j++){
    			
    			if(p.charAt(j-1) =='*'){
    				if(i==0){
    					result[i][j] = result[i][j-2];
    				} else {
    					//              0个*             >0个*
    					result[i][j] = result[i][j-2] | ((s.charAt(i-1)==p.charAt(j-2) | p.charAt(j-2)=='.') & result[i-1][j]);
    				}
    			} else {
    				if(i==0){
    					result[i][j] = false;
    				} else if(s.charAt(i-1)==p.charAt(j-1) | p.charAt(j-1)=='.'){
    					result[i][j] = result[i-1][j-1];
    				} else {
    					result[i][j] = false;
    				}
    			}
    		}
    	}
    	return result[len1][len2];
    }
}
