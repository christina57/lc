package lc;

public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int strStr(String haystack, String needle) {
    	int hay_len = haystack.length();
    	int nee_len = needle.length();
    	
    	if(nee_len>hay_len){
    		return -1;
    	}
    	if(nee_len==0){
    	    return 0;
    	}
    	
        for(int i=0;i<(hay_len-nee_len);i++){
        	boolean found = true;
        	for(int j=0;j<nee_len;j++){
        		if(needle.charAt(j)!=haystack.charAt(i+j)){
        			found = false;
        			break;
        		}
        	}
        	if(found){
        		return i;
        	}
        }
        return -1;
    }
}
