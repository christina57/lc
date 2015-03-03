package lc;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<String> letterCombinations(String digits) {
        
    	return helper(digits, 0);
    }
    
    private List<String> helper(String digits, int start){
    	List<String> newlists = new ArrayList<String>();
    	
    	if(start==digits.length()){
    		return newlists;
    	}
    	
    	String letters = getLetters(digits.charAt(start));
    	List<String> lists = helper(digits, start+1);
    	int size = lists.size();
    	for(int i=0;i<letters.length();i++){
    		for(int j=0;j<size;j++){
    			newlists.add(letters.charAt(i)+lists.get(j));
    		}
    	}
    	if(letters.length()==0){
    		newlists = lists;
    	}
    	
    	if(size==0){
    		for(int i=0;i<letters.length();i++){
    			newlists.add(letters.substring(i, i+1));
        	}
    	}
    	return newlists;
    }
    
    private String getLetters(char c){
    	
    	switch(c){
    		case '0':
    			return "";
    		case '1':
    			return "";
    		case '2':
    			return "abc";
    		case '3':
    			return "def";
    		case '4':
    			return "ghi";
    		case '5':
    			return "jkl";
    		case '6':
    			return "mno";
    		case '7':
    			return "pqrs";
    		case '8':
    			return "tuv";
    		case '9':
    			return "wxyz";
    		default:
    			return "";
    	}
    }
}
