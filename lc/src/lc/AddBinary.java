package lc;

import java.util.Arrays;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1010", "1011"));
	}
    public static String addBinary(String a, String b) {
        if(a==null || a.length()==0){
        	return b;
        }
        if(b==null || b.length()==0){
        	return a;
        }
        int range = Math.max(a.length(), b.length())+1;
        char[] result = new char[range];
        int carry = 0;
        int idx1 = a.length()-1;
        int idx2 = b.length()-1;
        for(int i=range-1;i>=0;i--){
        	int c1 = (idx1<0)?0:(a.charAt(idx1)-'0');
        	int c2 = (idx2<0)?0:(b.charAt(idx2)-'0');
        	int sum = c1+c2+carry;
        	
        	if(sum==3){
        		carry =1;
        		result[i] = '1';
        	} else if(sum==2){
        		carry =1;
        		result[i] = '0';
        	} else if(sum==1){
        		carry = 0;
        		result[i] = '1';
        	} else {
        		carry = 0;
        		result[i] = '0';
        	}
        	idx1--;
        	idx2--;
        }
        
        if(result[0] == '0'){
        	return new String(Arrays.copyOfRange(result, 1, range));
        } else {
        	return new String(result);
        }
    }
}
