package lc;

public class BestTimetoBuyandSellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public int maxProfit(int[] prices) {
	        int profit = 0;
	        int len = prices.length;
	        
	        if(len == 0 || len == 1){
	            return profit;
	        } else if (len == 2){
	            int dif=prices[1]-prices[0];
	            profit = dif>0?dif:0;   
	            return profit;
	        } else{
	            int start = 0;
	            int end = 0;
	            for(int i=1;i<(len-1);i++){
	                if(prices[i]>prices[i-1] && prices[i+1]<=prices[i]){
	                	profit+=(prices[i]-prices[start]);
                        start = i+1;
	                }
	                else if( prices[i]<prices[i-1]){
	                    start = i;
	                }
	            }
	            if((prices[len-1]-prices[start])>0){
	                profit+=(prices[len-1]-prices[start]);
	            }
	            return profit;
	        }
	        
	    }

	   public int maxProfit2(int[] prices) {
	        int profit = 0;
	        int len = prices.length;
	        
	        if(len == 0 || len == 1){
	            return profit;
	        } else if (len == 2){
	            int dif=prices[1]-prices[0];
	            profit = dif>0?dif:0;   
	            return profit;
	        } else{
	            int start = 0;
	            int end = 0;
	            for(int i=1;i<(len-1);i++){
	                if(prices[i]>prices[i-1]){
	                    end = i;
	                    if(prices[i+1]<=prices[i]){
	                         profit+=(prices[end]-prices[start]);
	                         start = i+1;
	                    }
	                }
	                else {
	                    start = i;
	                }
	            }
	            if((prices[len-1]-prices[start])>0){
	                profit+=(prices[len-1]-prices[start]);
	            }
	            return profit;
	        }
	        
	    }
}
