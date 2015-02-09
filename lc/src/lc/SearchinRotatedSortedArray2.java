package lc;

public class SearchinRotatedSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        
        while(start+1<end){
        	int mid = start+(end-start)/2;
        	if(A[mid] == target){
        		return true;
        	}
        	if(A[mid] > A[start]){
        		if ( target < A[mid] && target >= A[start]){
        			end = mid-1;
        		} else {
        			start = mid+1;
        		}
        	} else if ( A[mid] < A[start]) {
        		if( target <= A[end] && target > A[mid] ) {
        			start = mid+1;
        		} else {
        			end = mid -1;
        		}
        	} else {
        		start++;
        	}
        }
        
        if(A[start] == target){
        	return true;
        } else if(A[end] == target) {
        	return true;
        } else {
        	return false;
        }
    }
    
    public boolean search2(int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        
        while(start+1<end){
        	int mid = start+(end-start)/2;
        	if(A[mid] == target){
        		return true;
        	}
    	    if(A[mid] == A[start] && A[mid] == A[end]){
     		    for ( int i =start+1; i<end; i++){
     			    if (A[i] == target) {
     				    return true;
     			    }
     			}
     		}
        	if(A[mid] >= A[start]){
        		if ( target < A[mid] && target >= A[start]){
        			end = mid-1;
        		} else {
        			start = mid+1;
        		}
        	} else  if ( A[mid] <= A[end]) {
        		if( target <= A[end] && target > A[mid] ) {
        			start = mid+1;
        		} else {
        			end = mid -1;
        		}
        	}
        }
        
        if(A[start] == target){
        	return true;
        } else if(A[end] == target) {
        	return true;
        } else {
        	return false;
        }
    }

}
