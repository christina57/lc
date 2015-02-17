package lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String s1 = "leet";
		String s2 = "code";
		//String s3 = "ab";
		//String s4 = "cd";
		
		String elements[] = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		Set<String> dict = new HashSet(Arrays.asList(elements));
		System.out.println(wordBreak(s, dict));
	}
	
	 public static boolean wordBreak(String s, Set<String> dict) {
		 	int size = s.length();
	        boolean[] result = new boolean[size];
	        
	        int max_len =Integer.MAX_VALUE;
	        Iterator<String> iterator = dict.iterator();
	        while(iterator.hasNext()){
	        	String word = iterator.next();
	        	max_len = Math.max(word.length(), max_len);
	        }
	        for(int i =0; i<size; i++){
	        	result[i] = false;
	        	for(int j=Math.max(0, (i+1-max_len)); j<=i;j++){
	        		if((j-1<0 || result[j-1]==true) && dict.contains(s.substring(j, i+1))){
	        			result[i] = true;
	        			break;
	        		}
	        	}
	        }
	        return result[size-1];
	    }
	 
    public static boolean wordBreak2(String s, Set<String> dict) {

        boolean result = false;
        if(s.isEmpty()){
        	return true;
        }
        for(int i =1; i<=s.length();i++){
        	if(dict.contains(s.substring(0, i))){
        		result= wordBreak(s.substring(i), dict);
        		if(result == true){
        			return result;
        		}
        	}
       }
       return result;
    }
}
