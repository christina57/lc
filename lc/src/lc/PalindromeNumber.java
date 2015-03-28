package lc;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPalindrome(int x) {
        if(x<0){
        	return false;
        }
        if(x == 0){
        	return true;
        }
        
        int count=0;
        int divide =x;
        while(divide>0){
        	divide /= 10;
        	count++;
        }
        
        int left = count-1;
        int right = 0;
        while(left>right){
        	if((x/(int)Math.pow(10, left))%10 != (x/(int)Math.pow(10, right))%10){
        		return false;
        	}
        	left--;
        	right++;
        }
        return true;
    }
}
