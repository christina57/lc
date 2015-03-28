package lc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class fourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        Arrays.sort(num);

        for(int i=0;i<(num.length-3);i++){
        	if(i>0 && num[i] == num[i-1]){
        		continue;
        	}
        	for(int j=i+1;j<(num.length-2);j++){
        		if(j>i+1 && num[j] == num[j-1]){
            		continue;
            	}
            	int left = j+1;
            	int right = num.length-1;
            	while(left<right){
            		int sum = num[left]+num[right]+num[i]+num[j];
            		if(sum>target){
        				right--;
        			} else if(sum<target){
        				left++;
        			} else {
        				List<Integer> item = new LinkedList<Integer>();
        				item.add(num[i]);
        				item.add(num[j]);
        				item.add(num[left]);
        				item.add(num[right]);
            			result.add(item);
            			int cur = left;
            			while(left<num.length && num[cur] == num[left]){
            				left++;
            			}
            			cur = right;
            			while(right>j && num[cur] == num[right]){
            				right--;
            			}
        			}
            	}
        	}
        	
        	
        }
        return result;
    }
}
