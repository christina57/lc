package lc;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxSubArray(int[] A) {
    	int size = A.length;
        int[] subarray = new int[size];
        
        subarray[0] = A[0];
        int max = subarray[0];
        
        for(int i =1; i<size; i++){
        	if(subarray[i-1]>0){
        		subarray[i] = subarray[i-1]+A[i];
        	} else {
        		subarray[i] = A[i];
        	}
        	if(subarray[i]>max){
        		max = subarray[i];
        	}
        }
        return max;
    }
}
