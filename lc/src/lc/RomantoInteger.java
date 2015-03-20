package lc;

public class RomantoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int romanToInt(String s) {
    	s = s.toUpperCase();
        int result = 0;
        int pre =0;
        for(int i=0;i<s.length();i++){
        	int cur =0;
        	switch(s.charAt(i)){
        	case 'I': cur =1; break;
        	case 'V': cur =5; break;
        	case 'X': cur =10; break;
        	case 'L': cur =50; break;
        	case 'C': cur = 100; break;
        	case 'D': cur =500; break;
        	case 'M': cur =1000; break;
        	default: cur =0;
        	}
        	if(i!=0 && cur>pre){
        		result = result+cur-2*pre;
        	} else {
        		result += cur;
        	}
        	pre = cur;
        }
        return result;
    }
}
