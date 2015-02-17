package lc;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxProfit(int[] prices) {
       int len = prices.length;
       
       if(len<=1){
    	   return 0;
       }
       int[] result = new int[len];
       int min=prices[0];
       int max = 0;
       for(int i=0;i<len;i++){
    	   min = Math.min(min, prices[i]);
    	   result[i] = prices[i]-min;
    	   max = Math.max(max, result[i]);
       }
       return max;
    }
}
