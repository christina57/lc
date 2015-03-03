package lc;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = generateParenthesis(3);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        
        StringBuilder item = new StringBuilder();
        
        char[] paren = new char[n*2];
        boolean[] used = new boolean[n*2];
        for(int i=0;i<n;i++){
        	paren[i] = '(';
        	paren[i+n] = ')';
        	used[i] = false;
        	used[i+n] = false;
        }
        generateParenthesisHelper(result, item, paren, used, 0);
        
        return result;
        
    }
    
    private static void generateParenthesisHelper(List<String> result, StringBuilder item, char[] paren, boolean[] used, int leftminusright){
    	if(item.length() == paren.length){
    		result.add(new String(item));
    		return;
    	}
    	
    	for(int i=0;i<paren.length;i++){
    		if(leftminusright>=0 && !used[i]){
    			if(i==0 || paren[i]!=paren[i-1] || (paren[i]==paren[i-1] && used[i-1])){
    				item.append(paren[i]);
    				if(paren[i] == '('){
    					leftminusright++;
    				} else {
    					leftminusright--;
    				}
    				used[i] = true;
    				generateParenthesisHelper(result, item, paren, used, leftminusright);
    				item.deleteCharAt(item.length()-1);
    				if(paren[i] == '('){
    					leftminusright--;
    				} else {
    					leftminusright++;
    				}
    				used[i] = false;
    			}
    		}
    	}
    }
}
