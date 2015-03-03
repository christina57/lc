package lc;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<String>> partition(String s) {
        int len = s.length();
        
        boolean[][] partitiontable = new boolean[len][len];
        
        for(int i=len-1;i>=0;i--){
        	for(int j=0;j<len;j++){
        		if(i==j){
        			partitiontable[i][j] = true;
        		} else if (i<j) {
        			if(j==(i+1)){
        				partitiontable[i][j] = (s.charAt(i)==s.charAt(j));
        			}else{
        				partitiontable[i][j] = (partitiontable[i+1][j-1]) && (s.charAt(i)==s.charAt(j));
        			}
        		}
        	}
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
	    
	    ArrayList<String> item = new ArrayList<String>();
	    
        helper(partitiontable, result, item, s, 0);
        
        return result;
    }

    private void helper(boolean[][] partitiontable, List<List<String>> result, ArrayList<String> item, String s, int start){
    	if(start == s.length()){
    		result.add(new ArrayList<String>(item));
    		return;
    	}
    	for (int j=start;j<s.length();j++){
        	if(partitiontable[start][j]){
        		item.add(s.substring(start, j+1));
        		helper(partitiontable, result, item, s, j+1);
        		item.remove(item.size()-1);
        	}
        }
    }
}
