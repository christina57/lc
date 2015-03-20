package lc;

public class RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public char[] rotateString(char[] A, int offset) {
    	if(A== null || A.length==0){
    		return A;
    	}
        int idx = A.length - offset%(A.length);
        reverseHelper(A, 0, idx-1);
        reverseHelper(A, idx, A.length-1);
        reverseHelper(A, 0, A.length-1);
        return A;
    }
    
    private void reverseHelper(char[] A, int begin, int end){
    	for(int i=begin;i<=(begin+end)/2;i++){
    		char temp = A[i];
    		A[i] = A[begin+end-i];
    		A[begin+end-i] = temp;
    	}
    }
}
