package lc;

public class FindMinimuminRotatedSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int findMin(int[] num) {
	     int start = 0;
	     int end = num.length - 1;
	     
	     while(start+1<end){
	    	 int mid = start+(end-start)/2;
	    	 if(num[mid] < num[end]){
	    		 end = mid;
	    	 }
	    	 else if( num[mid] > num[end]){
	    		 start = mid;
	    	 } else {
	    		 end--;
	    	 }
	     }
	     return (num[start]>num[end])?num[end]:num[start];
   }
}
