package lc;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int climbStairs(int n) {
        int[] result = new int[n];
        
        if(n == 0){
        	return 0;
        }
        
        result[0] = 1;
        if(n == 1){
        	return 1;
        }
        
        result[1] = 2;
        if(n == 2){
        	return 2;
        }
        
        for(int i=2; i<n;i++){
        	result[i] = result[i-1]+result[i-2];
        }
        
        return result[n-1];
    }

}
