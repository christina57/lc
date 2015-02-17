package lc;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(divide (-1010369383, -2147483648));
	}    
	
	public static int divide(int dividend, int divisor) {
        if(divisor == 0){
        	return 0;
        }
		
        long pos_divisor = divisor>0?(long)divisor:-((long)divisor);
        long count = 1;
        long cur_divisor = pos_divisor;
        long left = dividend>0?(long)dividend:-((long)dividend);
        long result = 0;
        
        System.out.println(pos_divisor);
        
        while(left > cur_divisor){
        	count = count << 1;
        	cur_divisor = cur_divisor <<1;
        }
        
       
        while (cur_divisor>=pos_divisor && left>=0){
        	if(left >= cur_divisor){
        		left -= cur_divisor;
        		result += count;
        	} else {
        		cur_divisor = cur_divisor >> 1;
        		count = count >> 1;
        	}
        }
        
        if(((dividend >> 31) ^ (divisor >> 31)) != 0){
        	result = -result;
        }
        
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
        	return Integer.MAX_VALUE;
        }
        
        return (int)result;
    }

}
