package lc;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams q = new Anagrams();
		String s1 = "abcd";
		String s2 = "acbd";
		String s3 = "bcad";
		String s4 = "acb";
		String s5 = "abc";
		String s6 = "abd";
		String s7 = "abdc";
		String s8 = "ac";
		//ArrayList<String> result = new ArrayList<String>();
		String[] strs = {s1,s2,s3,s4,s5,s6,s7,s8};

		List<String> list = q.anagrams(strs);
		//char[] charArray = {'h','e','l','l','o'};
		for(String s:list){
			System.out.println(s);
		}
		//System.out.println(charArray.toString());
	}
	
    public List<String> anagrams(String[] strs) {
    	HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        for(int i=0;i<strs.length;i++){
        	char[] chars = strs[i].toCharArray();
        	Arrays.sort(chars);
        	String str = new String(chars);
        	if(map.containsKey(str)){
        		map.get(str).add(strs[i]);
        	} else {
        		LinkedList<String> list = new LinkedList<String>();
        		list.add(strs[i]);
        		map.put(str, list);
        	}
        }
        List<String> result = new LinkedList<String>();
        
        for(Map.Entry<String, LinkedList<String>> e : map.entrySet()){
        	LinkedList<String> list = e.getValue();
        	if(list.size()>1){
        		result.addAll(list);
        	}
        }
        
        return result;
    }

}
