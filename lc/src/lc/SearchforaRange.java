package lc;

public class SearchforaRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] searchRange(int[] A, int target) {
        int start =0;
        int end = A.length-1;
        int[] range = {-1, -1};
        
        while (start+1<end){
        	int mid = start + (end-start)/2;
        	if(A[mid]>= target){
        		end = mid;
        	} else {
        		start = mid+1;
        	}
        }
        if(A[start]==target){
        	range[0] = start;
        } else if(A[end] == target){
        	range[0] = end;
        } else {
        	return range;
        }
        
        start =0;
        end = A.length-1;
        while (start+1<end){
        	int mid = start + (end-start)/2;
        	if(A[mid]> target){
        		end = mid-1;
        	} else {
        		start = mid;
        	}
        }
        
        if(A[end]==target){
        	range[1] = end;
        } else if(A[start] == target){
        	range[1] = start;
        }
        
        return range;
    }
}
