package lc;

import java.util.ArrayList;

public class RecoverRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	int len = nums.size();
    	
    	if(len>1){
    		int min_pos=0;
    		for(int i=1;i<len;i++){
        		if(nums.get(i)<nums.get(i-1)){
        			min_pos=i;
        			break;
        		}
        	}
    		
    		if(min_pos!=0){
    			nums = swap (nums, 0, min_pos-1);
    			nums = swap (nums, min_pos, len-1);
    			nums = swap (nums, 0, len -1);
    		}
    		
    	}
    	
    }
    
    public ArrayList<Integer> swap( ArrayList<Integer> nums, int idx1, int idx2){
    	for(int i=0; i<(idx2-idx1+1)/2; i++){
    		int num1 = nums.get(idx1+i);
    		int num2 = nums.get(idx2-i);
    		nums.set(idx1+i, num2);
    		nums.set(idx2-i, num1);
    	}
    	return nums;
    }
}
