package lc;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String largestNumber(int[] num) {
        StringBuilder sb = new StringBuilder();

        Integer[] nums = new Integer[num.length];
        boolean isAllZero = true;
        for(int i=0;i<num.length;i++){
        	nums[i] = Integer.valueOf(num[i]);
        	if(num[i] != 0){
        		isAllZero = false;
        	}
        }
        if(isAllZero){
        	return "0";
        }
        Arrays.sort(nums, new Comparator<Integer>(){
        	@Override
        	public int compare(Integer a, Integer b){
        		String ab = a.toString() + b.toString();
        		String ba = b.toString() + a.toString();
        		
        		for(int i =0;i<ab.length();i++){
        			if(ab.charAt(i) > ba.charAt(i)){
        				return -1;
        			} else if(ab.charAt(i) < ba.charAt(i)){
        				return 1;
        			}
        		}
        		return 0;
        	}
        });
        for(int i=0;i<nums.length;i++){
        	sb.append(nums[i]);
        }
        return sb.toString();
    }
}
