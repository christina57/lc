package lc;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("230"));
	}

    public static int numDecodings(String s) {
    	int len = s.length();
        int[] result = new int[len];
        int temp = 0;
        
        if(len == 0){
        	return 0;
        }
        
        temp = Integer.parseInt(s.substring(0,1));
        if(temp == 0) {
            result[0]=0;
        } else {
    	    result[0]=1;
        }
        
        if(len == 1){
        	return result[0];
        }
        	
        for(int i=1;i<len;i++){
        	temp = Integer.parseInt((s.substring(i-1, i+1)));
        	if (temp == 0 || temp == 30 || temp == 40 || temp == 50 || temp == 60 || temp == 70 || temp == 80 || temp == 90){
        		result[i] = 0;
        	}
        	else if((temp>0 && temp<10) || (temp>26)){
        		result[i] = result[i-1];
        	} else if((temp>10 && temp<20) || (temp>20 && temp<27)){
        		if(i == 1){
        			result[i] = result[i-1]+1;
        		} else {
        			result[i] = result[i-1] + result[i-2];
        		}
        	} else {
        		if(i == 1){
        			result[i] = 1;
        		} else {
        			result[i] = result[i-2];
        		}
        	}
        }
        return result[len-1];
    }
}
