package lc;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String convert(String s, int nRows) {
    	if(s.length()==0){
    		return s;
    	}
    	if(nRows == 1){
    		return s;
    	}
    	int repeat = s.length()/(2*nRows-2);
    	
        StringBuffer sb = new StringBuffer();
        
        for(int i=0;i<nRows;i++){
        	for(int j=0;j<=repeat;j++){
        		int idx = j*(2*nRows-2)+i;
        		if(idx<s.length()){
	        		sb.append(s.charAt(idx));
	        		if(i!=0 && i!=(nRows-1)){
	        			idx += 2*(nRows-1-i);
	        			if(idx<s.length()){
	        				sb.append(s.charAt(idx));
	        			}
	        		}
        		}
        	}
        }
        return sb.toString();
    }
}
