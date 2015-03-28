package lc;

public class SortColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void sortColors(int[] A) {
        int left = 0;
        int right = A.length-1;
        for(int i=0;i<A.length;i++){
        	if(A[i] == 0){
        		if(A[left] != 0){
        			A[i] = A[left];
        			A[left] = 0;
        		}
        		left++;
        	} else if (A[i] == 2){
        		if(A[right] != 2){
        			A[i] = A[right];
        			A[right] = 2;
        		}
        		right--;
        		i--;
        	}
        	if(i==right){
        		break;
        	}
        }
    }
}
