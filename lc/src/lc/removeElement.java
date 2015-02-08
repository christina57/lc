package lc;

public class removeElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int end = len-1;
        int passed_len =0;
        
    	for ( int i =len-1; i>=0; i--){
    		if(A[i] == elem){
    			if(passed_len == 0){
    				end--;
    			} else{
    				A[i] = A[end];
    				end--;
    			}
    		} else {
    			passed_len++;
    		}
    	}
    	return (end+1);
    }

}
