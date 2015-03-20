package lc;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters q = new LongestSubstringWithoutRepeatingCharacters();
		String s = "bbbbb";
		System.out.println(q.lengthOfLongestSubstring(s));
	}
	
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        int start_idx=0;
        int cur_len=0;
        
        for(int i=0;i<s.length();i++){
        	if(map.containsKey(s.charAt(i))){
        		int pos = map.get(s.charAt(i));
        		if(pos>=start_idx){
        			start_idx = pos+1;
        			cur_len = i - pos;
        		}
        		else {
            		cur_len++;		
        		}
        	} else {
        		cur_len++;
        	}
        	
        	map.put(s.charAt(i), i);
        	if(cur_len>max){
    			max=cur_len;
    		}
        }
        
        return max;
    }
}
