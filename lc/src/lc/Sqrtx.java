package lc;

public class Sqrtx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(2147395600));
		System.out.println(Integer.MAX_VALUE);
	}
    public static int sqrt(int x) {
    	if( x < 0){
    		return -1;
    	}
    	if( x == 0){
    		return 0;
    	}
        int start =1;
        int end = x;
        
        while (start+1<end){
        	int mid = start + (end-start)/2;
        	
        	if(mid>Integer.MAX_VALUE/mid || mid*mid > x ){
        		end = mid-1;
        	} else {
        		start = mid;
        	}
        }

        if(end<=(x/end)){
        	return end;
        } else if (start<=x/start){
        	return start;
        } else {
        	return -1;
        }
        
    }
}
