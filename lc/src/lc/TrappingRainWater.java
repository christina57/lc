package lc;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int trap(int[] A) {
        
    	int len =A.length;
    	if(len==0){
    		return 0;
    	}
    	int[] lefthigh = new int[len];
    	int[] righthigh = new int[len];
    	lefthigh[0] =0;
    	righthigh[len-1] =0;
    	
    	for(int i=1;i<len;i++){
    		lefthigh[i] = Math.max(lefthigh[i-1], A[i-1]);
    	}
    	for(int i=len-2;i>=0;i--){
    		righthigh[i] = Math.max(righthigh[i+1], A[i+1]);
    	}
    	
    	int sum=0;
    	for(int i=0;i<len;i++){
    		int left = Math.max(lefthigh[i]-A[i], 0);
    		int right = Math.max(righthigh[i]-A[i], 0);
    		sum+= Math.min(left, right);
    	}
    	return sum;
    }
    
}
