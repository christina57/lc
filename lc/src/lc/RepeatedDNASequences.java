package lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedDNASequences q = new RepeatedDNASequences();
		System.out.println(q.findRepeatedDnaSequences("CAAAAAAAAAC").size());
	}
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> result = new LinkedList<String>();
    	if(s.length()<=10){
    		return result;
    	}
        HashMap<Character, Integer> maps = new HashMap<Character, Integer>();
        maps.put('A', 0);
        maps.put('C', 1);
        maps.put('G', 2);
        maps.put('T', 3);
        HashMap<Integer, Integer> allsubstring = new HashMap<Integer, Integer>();
    	//HashSet<String> repeatsubstring = new HashSet<String>();
    	
    	int sum = 0;
    	int mask = 0x00FF;
    	for(int i=0;i<10;i++){
    		int tmp = maps.get(s.charAt(i));
    		sum = sum<<2 + tmp;
    		System.out.println(sum);
    	}
    	allsubstring.put(sum,0);
    	System.out.println(sum);
    	for(int i=1;i<=(s.length()-10);i++){
    		sum = (sum & mask) << 2 + maps.get(s.charAt(i));
    		
    		if(allsubstring.containsKey(sum)){
    			if(allsubstring.get(sum) == 0){
    				result.add(s.substring(i, i+10));
    				allsubstring.put(sum, 1);
    			}
    			//repeatsubstring.add(s.substring(i, i+10));
    		} else {
    			allsubstring.put(sum, 0);
    		}
    	}
    	
    	//result.addAll(repeatsubstring);
    	return result;
    }
}
