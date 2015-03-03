package lc;

import java.util.Arrays;

public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isScramble(String s1, String s2) {
    	
    	int len = s1.length();
        if(len !=s2.length()){
        	return false;
        }
        
    	if( s1.equals(s2)){
        	return true;
        }
    	String part1, part2, part3, part4;
        for(int i=1;i<len;i++){
        	part1 = s1.substring(0, i);
        	part2 = s1.substring(i);
        	part3 = s2.substring(0, i);
        	part4 = s2.substring(i);
        	
        	if(sum(part1) == sum(part3) && sum(part2) == sum(part4)){
        		if(isScramble(part1,part3) && isScramble(part2,part4)){
        			return true;
        		}
        	}
        	part3 = s2.substring(len-i);
        	part4 = s2.substring(0, len-i);
        	
        	if(sum(part1) == sum(part3) && sum(part2) == sum(part4)){
        		if(isScramble(part1,part3) && isScramble(part2,part4)){
        			return true;
        		}
        	}
        }
        return false;
    }
    
    private int sum(String s){
    	int sum=0;
    	for(int i =0;i<s.length();i++){
    		sum+=s.charAt(i);
    	}
    	return sum;
    }
}
