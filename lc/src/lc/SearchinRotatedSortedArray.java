package lc;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,5,6,7,0,1,2};
		System.out.println(search(A, 0));

	}
    public static int search(int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        
        while(start+1<end){
        	int mid = start+(end-start)/2;
        	if(A[mid] == target){
        		return mid;
        	}
        	if(A[mid] > A[start]){
        		if ( target < A[mid] && target >= A[start]){
        			end = mid-1;
        		} else {
        			start = mid+1;
        		}
        	} else if ( A[mid] < A[end]) {
        		if( target <= A[end] && target > A[mid] ) {
        			start = mid+1;
        		} else {
        			end = mid -1;
        		}
        	}
        }
        
        if(A[start] == target){
        	return start;
        } else if(A[end] == target) {
        	return end;
        } else {
        	return -1;
        }
    }
}
