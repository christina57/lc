package lc;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxProduct(int[] A) {
        int len = A.length;
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = A[0];
        min[0] = A[0];
        int max_result = max[0];
        
        for(int i=1;i<len;i++){
    		int a = max[i-1] * A[i];
    		int b = min[i-1] * A[i];
    		max[i] = Math.max(Math.max(a, b), A[i]);
    		min[i] = Math.min(Math.min(a, b), A[i]);
        	max_result = Math.max(max[i], max_result);
        }
        return max_result;
    }
}
