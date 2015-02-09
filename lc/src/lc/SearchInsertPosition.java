package lc;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int searchInsert(int[] A, int target) {
    	int start =0;
    	int end = A.length-1;
    	
    	while(start+1<end){
    		int mid = start+(end-start)/2;
    		if(A[mid]> target){
    			end = mid -1;
    		} else if(A[mid]< target){
    			start = mid;
    		} else {
    			return mid;
    		}
    	}
    	
    	if(A[start]>=target){
    		return start;
    	} else if(A[end]>=target){
    		return end;
    	} else{
    		return end+1;
    	}
    }
}
