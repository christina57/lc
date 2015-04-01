package lc;

import java.util.LinkedList;
import java.util.List;

public class SingleNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Integer> singleNumberIII(int[] A) {
        
    	int result1 = 0;
    	for(int i=0;i<A.length;i++){
    		result1 ^= A[i];
    	}
    	
    	int bias =0;
    	for(bias=0;bias<32;bias++){
    		if((result1>>bias & 1) == 1){
    			break;
    		}
    	}
    	
    	int result2 = 0;
    	int result3 = 0;
    	for(int i=0;i<A.length;i++){
    		if((A[i]>>bias & 1) == 1){
    			result2 ^= A[i];
    		} else {
    			result3 ^= A[i];
    		}
    	}
    	List<Integer> result = new LinkedList<Integer>();
    	result.add(result2);
    	result.add(result3);
    	return result;
    }
}
