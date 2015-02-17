package lc;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("ab", "?*"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("", "**"));
	}

    public static boolean isMatch(String s, String p) {
        //to pass leetcode start;
        // without this optimization, it will fail for large data set
		int pNoneStarLen = 0; //p中的非'*'的字符数量
		for (char c : p.toCharArray()) {
			if (c != '*') {
				pNoneStarLen++;
			}
		}
		if (pNoneStarLen > s.length()){ //如果p中非'*'字符数量比s还多，则说明p中肯定有冗余，所以false
			return false;
		}
        //to pass leetcode end;
		
    	int len1 = p.length();
    	int len2 = s.length();
    	/*boolean hasstar = false;
    	
    	for(int i=0;i<len1;i++){
    		if(p.charAt(i)=='*'){
    			hasstar = true;
    			break;
    		}
    	}*/
    	
    	boolean[][] result = new boolean[len1+1][len2+1];
    	result[0][0] = true;
    	
    	boolean nostar = true;
    	for(int i=1;i<=len1;i++){
    		if(p.charAt(i-1)!='*'){
				nostar=false;
			}
    		if(nostar && p.charAt(i-1)=='*'){
    			result[i][0]=true;
    		} else {
    			result[i][0]=false;
    		}
    	}
    	for(int i=1;i<=len2;i++){
    		result[0][i]=false;
    	}
    	
    	for(int i=1;i<=len1;i++){
    		for (int j=1;j<=len2;j++){
    			if(p.charAt(i-1)=='*'){
					result[i][j] = result[i-1][j] | result[i][j-1];
				} else {
					if(s.charAt(j-1)==p.charAt(i-1) || p.charAt(i-1)=='?'){
						result[i][j] = result[i-1][j-1];
					} else {
						result[i][j] =false;
					}
				}
    			/*if(hasstar){
    				if(p.charAt(i-1)=='*'){
    					result[i][j] = result[i-1][j] | result[i][j-1];
    				} else {
    					if(s.charAt(j-1)==p.charAt(i-1) || p.charAt(i-1)=='?'){
    						result[i][j] = result[i-1][j-1];
    					} else {
    						result[i][j] =false;
    					}
    				}
    			} else {
    				if(len1!=len2){
    					return false;
    				} else {
    					if(s.charAt(j-1)==p.charAt(i-1) || p.charAt(i-1)=='?'){
    						result[i][j] = result[i-1][j-1];
    					} else {
    						result[i][j] = false;
    					}
    				}
    			}*/
    		}
    	}
    	
    	return result[len1][len2];
    }
}
