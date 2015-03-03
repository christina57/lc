package lc;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        StringBuilder item = new StringBuilder();
        
        helper(result, item, s, 0, 0);
        return result;
    }
    
    private void helper(List<String> result, StringBuilder item, String s, int divide, int start){
    	if(divide>4){
    		return;
    	}
    	if(start==s.length()){
    		if(divide==4){
    			result.add(new String(item));
    		}
    		return;
    	}
    	
    	for(int i=0;i<3;i++){
    		if(start+i<s.length()){
    			String sub = s.substring(start, start+i+1);
        		
        		if(isValid(sub)){
        			int end1 = item.length();
        			if(start==0){
        				item.append(sub);
        			} else {
        				item.append("."+sub);
        			}
        			int end2 = item.length();
        			helper(result, item, s, divide+1, start+i+1);
        			item.delete(end1, end2);
        		}
    		}
    		
    	}
    	
    }
    
    private boolean isValid(String s){
    	
    	if(s.charAt(0)=='0' && s.length()!=1){
    		return false;
    	}
    	int value = Integer.parseInt(s);
    	if(value>=0 && value<=255){
    		return true;
    	}
    	return false;
    }
}
