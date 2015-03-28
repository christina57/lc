package lc;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1534236469));
		//System.out.println(Integer.MAX_VALUE);
	}
    public static int reverse(int x) {
    	if(x==0){
        	return 0;
        }
    	boolean isNegative = false;
    	int result = 0;
    	
        if(x<0){
        	isNegative = true;
        	x = 0-x;
        }
        
        int count =0;
        int temp = x;
        while(temp>0){
        	temp /= 10;
        	count++;
        }
        if(count >=10 && x%10 > 2){
        	return 0;
        }
        while(count>0){
        	int addon = (x%10)*(int)Math.pow(10,(count-1));
        	if(!isNegative && addon>Integer.MAX_VALUE-result){
        		return 0;
        	}
        	if(isNegative && addon+Integer.MIN_VALUE>(-result)){
        		return 0;
        	}
        	result+=addon;
        	x = x/10;
        	count--;
        }
        if(isNegative){
        	return -result;
        }
        return result;
    }
}
