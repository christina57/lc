package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] L ={"fooo","barr","wing","ding","wing"};
		String S = "";
		List result = (new SubstringwithConcatenationofAllWords()).findSubstring(S, L);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
    public List<Integer> findSubstring(String S, String[] L) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(L.length==0){
    		for(int i=0;i<S.length();i++){
    			result.add(i);
    		}
    		return result;
    	}
    	
        HashMap<String, Integer> orig_map = new HashMap<String, Integer>();
        HashMap<String, Integer> copy_map = new HashMap<String, Integer>();
        
        for(String s:L){
        	if(orig_map.containsKey(s)){
        		orig_map.put(s, orig_map.get(s)+1);
        		copy_map.put(s, copy_map.get(s)+1);
        	}
        	else {
        		orig_map.put(s, 1);
        		copy_map.put(s, 1);
        	}
        }
        
        
        int len = L[0].length();
        int idx = 0;
        
        while((idx+len*L.length)<=S.length()){
        	int start = idx;
        	String sub = S.substring(idx, idx+len);
        	
        	while(copy_map.size()!=0 && copy_map.containsKey(sub)){
    			if(copy_map.get(sub)==1){
    				copy_map.remove(sub);
    			}
    			else {
    				copy_map.put(sub, copy_map.get(sub)-1);
    			}
    			idx+=len;
    			if(idx+len<=S.length()){
    				sub = S.substring(idx, idx+len);
    			}
    			else{
    				break;
    			}
        	}
        	if(copy_map.size()==0){
        		result.add(start);
        	}
        	if(start!=idx){
	        	for(String s:orig_map.keySet()){
	        		copy_map.put(s, orig_map.get(s));
	            }
        	}
        	idx = start+1;
        }
        return result;
    }

}
