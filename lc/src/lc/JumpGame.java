package lc;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0};
		System.out.println(canJump(A));
	}
	
	public static boolean canJump(int[] A) {
		int begin = 0;
		int end = 0;
		
		while(end<=A.length-1){
			int max = end;
			for(int i=begin;i<=end;i++){
				max = Math.max(max, i+A[i]);
				if(max>=(A.length-1)){
					return true;
				}
			}
			if(end == max){
				return false;
			}
			if(end+1<=max){
				begin = end+1;
			}
			end = max;
		}
		return false;
	}
	
    public static boolean canJump2(int[] A) {
    	boolean[] result = new boolean[A.length];
    	result[A.length-1] = true;
    	
        for(int i = A.length-2;i>=0;i--){
        	result[i] = false;
        	for(int j=A[i];j>=1;j--){
        		if(i+j>=A.length-1){
        			result[i] = true;
        			break;
        		} else {
        			if(result[i+j]){
        				result[i] = true;
            			break;
        			}
        		}
        	}
        }
        
        return result[0];
    }
}
