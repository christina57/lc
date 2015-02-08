package lc;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int firstMissingPositive(int[] A) {
        int result=-1;
        int len = A.length;
        
        for (int i=0; i<len; i++){
        	if (A[i]<=0){
        		A[i] = len+1;
        	}
        }
        
        for (int i=0; i<len; i++){
    		if(A[i]>0 && A[i]<=len){
    			if(A[A[i]-1]>0){
    				A[A[i]-1] = A[A[i]-1]+Integer.MIN_VALUE;
    			}
    		}
    		else if (A[i]<=0){
    			int original = A[i]-Integer.MIN_VALUE;
    			if(original <=len && A[original-1]>0){
    				A[original-1] = A[original-1]+Integer.MIN_VALUE;
    			}
    		}
        }
        
        for (int i=0; i<len; i++){
        	if (A[i]>0){
        		result = i+1;
        		break;
        	}
        }
        
        if(result==-1){
        	result=len+1;
        }
    	return result;
    }

}
