package lc;

import java.util.ArrayList;

public class MaximumGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumGap q = new MaximumGap();
		int[] num = {100,3,2,1};
		System.out.println(q.maximumGap(num));
	}
    public int maximumGap(int[] num) {
    	if(num.length<2){
    		return 0;
    	}
    	int max = num[0], min = num[0];
    	for(int i=1;i<num.length;i++){
    		max = Math.max(max, num[i]);
    		min = Math.min(min, num[i]);
    	}
    	
    	int bucket_size = (max-min)/num.length +1;
    	int bucket_count = (max-min)/bucket_size + 1;
    	System.out.println(bucket_size+","+bucket_count);
    	
    	// 0: max , 1:min
    	int[][] buckets = new int[bucket_count][2];
    	boolean[] emptybuckets = new boolean[bucket_count];
    	
    	for(int i=0;i<bucket_count;i++){
    		buckets[i][0] = Integer.MIN_VALUE;
    		buckets[i][1] = Integer.MAX_VALUE;
    		emptybuckets[i] = true;
    	}
    	
    	for(int i=0;i<num.length;i++){
    		int idx = (num[i]-min)/bucket_size;
    		System.out.println(idx);
    		buckets[idx][0] = Math.max(buckets[idx][0], num[i]);
    		buckets[idx][1] = Math.min(buckets[idx][1], num[i]);
    		emptybuckets[idx] = false;
    	}
    	
    	int result = Integer.MIN_VALUE;
    	int preidx = -1;
    	for(int i=0;i<bucket_count;i++){
    		if(!emptybuckets[i]){
    			if(preidx != -1){
    				result = Math.max(buckets[i][1]-buckets[preidx][0], result);
    			}
    			preidx = i;
    		}
    	}
        return result;
    }
}
