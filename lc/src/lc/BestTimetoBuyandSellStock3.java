package lc;

public class BestTimetoBuyandSellStock3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2){
        	return 0;
        }
        
        int[] left = new int[len];
        int[] right = new int[len];
        int max =0;
        int leftmin =prices[0];
        int rightmax =prices[len-1];
        
        for(int i=1;i<len;i++){
        	
    		leftmin = Math.min(leftmin, prices[i]);
    		left[i] = Math.max(left[i-1], prices[i] - leftmin);  	
        	
        }
        
        for(int i=len-2;i>=0;i--){
        	
    		rightmax = Math.max(rightmax, prices[i]);
    		right[i] = Math.max(right[i+1], rightmax-prices[i]); 	
        	
        }
        
        for(int i=0;i<len;i++){
        	max= Math.max(max, left[i]+right[i]);
        }
        return max;
    }
}
