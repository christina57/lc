package lc;

import java.util.HashSet;
import java.util.Iterator;


public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        int longest =0;
        
        for(int i=0;i<num.length;i++){
        	if(!set.contains(num[i])){
        		set.add(num[i]);
        	}
        }
        
        
        for(int i=0;i<num.length;i++){
        	if(set.contains(num[i])){
        		int bias = 1;
            	int len = 1;
            	while(set.contains(num[i]-bias)){
            		set.remove(num[i]-bias);
            		len++;
            		bias++;
            	}
            	bias = 1;
            	while(set.contains(num[i]+bias)){
            		set.remove(num[i]+bias);
            		len++;
            		bias++;
            	}
            	set.remove(num[i]);
            	longest = Math.max(len, longest);
        	}
        }
       
        return longest;
    }
}
