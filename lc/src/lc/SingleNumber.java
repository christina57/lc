package lc;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int singleNumber(int[] A) {
        int result = 0;
        
        for(int i=0;i<A.length;i++){
        	result ^= A[i];
        }
        return result;
    }
}
