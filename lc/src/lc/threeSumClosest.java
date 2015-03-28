package lc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class threeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int threeSumClosest(int[] num, int target) {
        int mindistance = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(num);
        for(int i=0;i<(num.length-2);i++){
        	int left = i+1;
        	int right = num.length-1;
        	while(left<right){
        		int sum = num[left]+num[right]+num[i];
        		if(sum>target){
        			if(Math.abs(sum-target)<mindistance){
        				mindistance = Math.abs(sum-target);
        				result = sum;
        			}
    				right--;
    			} else if(sum<target){
    				if(Math.abs(sum-target)<mindistance){
        				mindistance = Math.abs(sum-target);
        				result = sum;
        			}
    				left++;
    			} else {
    				return target;
    			}
        	}
        }
        return result;
    }
}
