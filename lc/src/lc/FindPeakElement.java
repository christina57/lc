package lc;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int findPeakElement(int[] num) {
        int start =0;
        int end = num.length-1;
        
        while(start+1<end){
        	int mid =start+(end-start)/2;
        	if(num[mid-1]> num[mid]){
        		end =mid;
        	} else if(num[mid+1]>num[mid]){
        		start = mid;
        	}
        	else {
        		return mid;
        	}
        }
        return (num[start]>num[end])?start:end;
    }

}
