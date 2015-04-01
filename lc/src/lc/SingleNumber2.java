package lc;

public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    public int singleNumber(int[] A) {
        int[] result = new int[32];
        
        for(int i=0;i<A.length;i++){
        	int cur = A[i];
        	for(int j=0;j<32;j++){
        		result[j] += (cur>>j) & 1;
        	}
        }
        
        int num=0;

        for(int i=0;i<32;i++){
        	result[i] %= 3;
        	num += result[i]* (1<<i);
        }
        return num;
    }
}
