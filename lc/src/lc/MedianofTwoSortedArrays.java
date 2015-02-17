package lc;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A ={1};
		int[] B = {2, 3};
		System.out.println(findMedianSortedArrays(A,B));
	}

    public static double findMedianSortedArrays(int A[], int B[]) {
        int asize = A.length;
        int bsize = B.length;
        
        if((asize+bsize)%2 == 0){
        	return (findmedianhelper(A,B,0,0,(asize+bsize-1)/2) + findmedianhelper(A,B,0,0,(asize+bsize-1)/2+1))/2.0;
        } else {
        	return findmedianhelper(A,B,0,0,(asize+bsize-1)/2);
        }
    }
    
    public static double findmedianhelper(int A[], int B[], int Astart, int Bstart, int k){
    	
    	
    	if(k ==0){
    		if(Astart >= A.length){
    			return B[Bstart];
    		}
    		if(Bstart >= B.length){
    			return A[Astart];
    		}
    		if (A[Astart] >= B[Bstart]){
    			return B[Bstart];
    		} else {
    			return A[Astart];
    		}
    	}
    	
    	if ((Astart+(k+1)/2) > A.length){
    		return findmedianhelper(A, B, Astart, Bstart+(k+1)/2, k-(k+1)/2);
    	}
    	if ((Bstart+(k+1)/2) > B.length){
    		return findmedianhelper(A, B, Astart+(k+1)/2, Bstart, k-(k+1)/2);
    	}
    	if (A[Astart+(k+1)/2-1] >= B[Bstart+(k+1)/2-1]){
    		return findmedianhelper(A, B, Astart, Bstart+(k+1)/2, k-(k+1)/2);
    	} else {
    		return findmedianhelper(A, B, Astart+(k+1)/2, Bstart, k-(k+1)/2);
    	}
    }
}
