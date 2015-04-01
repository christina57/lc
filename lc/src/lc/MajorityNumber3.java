package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MajorityNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        HashMap<Integer, Integer> candidates = new HashMap<Integer, Integer>();
        int count = 0;
        int len = nums.size();
        
        for(int i=0;i<len;i++){
        	int cur = nums.get(i);
        	if(candidates.containsKey(cur)){
        		candidates.put(cur, candidates.get(cur)+1);
        	} else if(count<k){
        		candidates.put(cur, 1);
        	} else {
        		for(Map.Entry<Integer, Integer> candidate:candidates.entrySet()){
        			if(candidate.getValue() == 1){
        				candidates.remove(candidate.getKey());
        				count--;
        			} else {
        				candidates.put(candidate.getKey(), candidate.getValue()-1);
        			}
        		}
        	}
        }
        for(Map.Entry<Integer, Integer> candidate:candidates.entrySet()){
        	candidates.put(candidate.getKey(), 0);
        }
        int major = 0;
        int majorcount = 0;
        for(int i=0;i<len;i++){
        	int cur = nums.get(i);
        	if(candidates.containsKey(cur)){
        		int cnt = candidates.get(cur)+1;
        		candidates.put(cur, cnt);
        		if(cnt > majorcount){
        			major = cur;
        			majorcount = cnt;
        		}
        	}
        }
        return major;
    }
}
