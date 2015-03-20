package lc;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring q = new MinimumWindowSubstring();
		System.out.println(q.minWindow("a", "a"));
	}
	
    public String minWindow(String S, String T) {
    	HashMap<Character, Integer> orig_map = new HashMap<Character, Integer>();
    	HashMap<Character, Integer> cur_map = new HashMap<Character, Integer>();
    	
    	for(int i=0;i<T.length();i++){	
    		char c = T.charAt(i);
    		if(orig_map.containsKey(c)){
    			orig_map.put(c, orig_map.get(c)+1);
    		} else {
    			orig_map.put(c, 1);
    		}
    	}
    	
    	int start=0, end =0;
    	int final_start=0, final_end=S.length();
    	int count = 0;
    	int hasCover =0;
    	
    	while(end<S.length()){
    		char c = S.charAt(end);
    		if(orig_map.containsKey(c)){
    			if(cur_map.containsKey(c)){
    				cur_map.put(c, cur_map.get(c)+1);
    			}
    			else{
    				cur_map.put(c, 1);
    			}
    			if(cur_map.get(c)<=orig_map.get(c)){
    				count++;
    			}
    			
    			if(count == T.length()){
    				while(start<=end){
    					char h = S.charAt(start);
    					if(orig_map.containsKey(h)){
    						if(cur_map.get(h)<=orig_map.get(h)){
    							if((end-start)<(final_end-final_start)){
    								final_start = start;
    								final_end = end;
    								hasCover=1;
    							}
    							cur_map.put(h, cur_map.get(h)-1);
    							count--;
    							start++;
    							break;
    						} else {
    							cur_map.put(h, cur_map.get(h)-1);
    						}
    					}
    					start++;
    				}
    			}
    		}
    		end++;
    	}
    	if(hasCover == 0){
    		return "";
    	} else {
    		return S.substring(final_start, final_end+1);
    	}
    }
}
