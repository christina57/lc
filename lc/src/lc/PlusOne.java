package lc;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] plusOne(int[] digits) {
    	if(digits==null || digits.length==0){
    		return null;
    	}
    	int [] result = new int[digits.length+1];
    	int carry = 1;
        for(int i = digits.length-1;i>=0;i--){
        	int sum = digits[i] + carry;
        	if(sum<10){
        		carry = 0;
        		result[i+1] = sum;
        	} else {
        		carry = 1;
        		result[i+1] = sum-10;
        	}
        }
        result[0] = carry;
        if(result[0] == 0){
        	return Arrays.copyOfRange(result, 1, result.length-1);
        } else {
        	return result;
        }
    }
}
