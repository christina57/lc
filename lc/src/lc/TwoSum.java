package lc;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
        for(int i=0;i<numbers.length;i++){
        	int left = target - numbers[i];
        	if(map.containsKey(left)){
        		result[0] = map.get(left)+1;
    			result[1] = i+1;
    			return result;
        	}
        	map.put(numbers[i], i);
        }
        return result;
	}
	
	
	public int[] twoSum_sort(int[] numbers, int target) {
		Arrays.sort(numbers);
		int left =0;
		int right = numbers.length-1;
		int[] result = new int[2];
		
		while(left<right){
			if(numbers[left]+numbers[right]>target){
				right--;
			} else if(numbers[left]+numbers[right]<target){
				left++;
			} else {
				result[0] = left+1;
    			result[1] = right+1;
    			return result;
			}
		}
		return result;
	}
	
    public int[] twoSum2(int[] numbers, int target) {
    	int[] result = new int[2];
    	
        for(int i=0;i<(numbers.length-1);i++){
        	int left = target - numbers[i];
        	for(int j=i+1;j<numbers.length;j++){
        		if(numbers[j] == left){
        			result[0] = i+1;
        			result[1] = j+1;
        			return result;
        		}
        	}
        }
        return result;
    }
}
