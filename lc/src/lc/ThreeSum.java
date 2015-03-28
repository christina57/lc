package lc;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0,0,0,0};
		System.out.println(threeSum(num).size());
	}
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        Arrays.sort(num);
        int pre =0;
        for(int i=0;i<(num.length-2);i++){
        	if(i>0 && num[i] == pre){
        		continue;
        	}
        	int target = 0-num[i];
        	int left = i+1;
        	int right = num.length-1;
        	while(left<right){
        		if(num[left]+num[right]>target){
    				right--;
    			} else if(num[left]+num[right]<target){
    				left++;
    			} else {
    				List<Integer> item = new LinkedList<Integer>();
    				item.add(num[i]);
    				item.add(num[left]);
    				item.add(num[right]);
        			result.add(item);
        			int cur = left;
        			while(left<num.length && num[cur] == num[left]){
        				left++;
        			}
        			cur = right;
        			while(right>i && num[cur] == num[right]){
        				right--;
        			}
    			}
        	}
        	pre = num[i];
        }
        return result;
    }
}
