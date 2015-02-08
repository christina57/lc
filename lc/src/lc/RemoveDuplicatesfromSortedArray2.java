package lc;

public class RemoveDuplicatesfromSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (A.length>0){
	        int start = 1;
	        int current =A[0];
	        int current_count = 1;
	        
	        
	        for ( int i=1; i<len; i++){
	        	if( A[i] != current){
	        		current = A[i];
	        		A[start]= current;
	        		start++;
	        		current_count = 1;
	        	} else {
	        		current_count ++;
	        		if (current_count <3){
	        			A[start]= current;
	        			start++;
	        		}
	        	}
	        }
	        return start;
        }
        else{
        	return 0;
        }
    }

}
