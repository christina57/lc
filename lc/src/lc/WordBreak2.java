package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        if(!isWordBreakable(s, dict)){
        	return result;
        }
        ArrayList<String> item = new ArrayList<String>();
        helper(s, dict, result, item, 0);
        return result;
    }
    private void helper(String s, Set<String> dict, List<String> result, ArrayList<String> item, int idx){
    	if(idx == s.length()){
    		StringBuilder str = new StringBuilder();
    		int size = item.size();
    		for(int i=0;i<size;i++){
    			str.append(item.get(i)+" ");
    		}
    		if(str.charAt(str.length()-1)==' '){
    			str.deleteCharAt(str.length()-1);
    		}
    		result.add(str.toString());
    		return;
    	}
    	
    	for(int i=idx;i<s.length();i++){
    		if(dict.contains(s.substring(idx, i+1))){
    			item.add(s.substring(idx, i+1));
    			helper(s, dict, result, item, i+1);
    			item.remove(item.size()-1);
    		}
    	}
    }
    
	private boolean isWordBreakable(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return true;
		boolean[] result = new boolean[s.length() + 1];
		result[0] = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				String sub = s.substring(j, i + 1);
				if (result[j] && dict.contains(sub)) {
					result[i + 1] = true;
					break;
				}
			}
		}
		return result[s.length()];
	}
}
