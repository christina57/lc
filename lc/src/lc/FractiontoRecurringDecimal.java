package lc;

import java.util.HashMap;

public class FractiontoRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractiontoRecurringDecimal q = new FractiontoRecurringDecimal();
		//System.out.println(0.0000000004656612873077392578125 * -2147483648);
		System.out.println(q.fractionToDecimal(-1, -2147483648));
	}
	
    public String fractionToDecimal(int numerator, int denominator) {
    	if(denominator==0){
    		return "NULL";
    	}
    	if(numerator==0){
    		return "0";
    	}
        StringBuilder sb = new StringBuilder();
        if(((numerator>>31 & 1) ^ (denominator>>31 & 1)) == 1){
        	sb.append("-");
        }
        long longnumerator = numerator<0?-(long)numerator:numerator;
        long longdenominator = denominator<0?-(long)denominator:denominator;

        long cur = longnumerator/longdenominator;
        long remainder = longnumerator%longdenominator;
        if(remainder == 0){
        	sb.append(cur);
        	return sb.toString();
        } else {
        	sb.append(cur+".");
        }
        int orig_len = sb.length();
        int idx = 0;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(remainder, 0);
        
        while(remainder != 0){
	        cur = (remainder*10)/longdenominator;
	        remainder = (remainder*10)%longdenominator;
	        idx++;

	        if(map.containsKey(remainder)){
	        	
	        	int start = map.get(remainder);
	        	sb.insert(start+orig_len, '(');
	        	sb.append(cur+")");
	        	break;
	        } else {
	        	map.put(remainder, idx);	        	
	        	sb.append(cur);
	        }
        }
        return sb.toString();
    }
}
