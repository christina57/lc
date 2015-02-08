package lc;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public void merge(int A[], int m, int B[], int n) {
	       int a = m - 1;
	       int b = n - 1;
	       
	       while (a >= 0 && b >= 0) {
			   if (A[a] >= B[b]) {
				   A[a + b + 1] = A[a];
				   a--;
			   } else {
				   A[a + b + 1] = B[b];
				   b--;
			   }
	       }
	       
	       if(a<0 && b>=0){
	    	   while(b>=0){
	    		   A[a+b+1]=B[b];
				   b--;
	    	   }
	       }
	       
	    }

}
