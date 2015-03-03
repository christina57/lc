package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        boolean[] used = new boolean[num.length];
        for(int i=0;i<num.length;i++){
        	used[i] = false;
        }
        Arrays.sort(num);
        permutehelper(result, item, num, used);
        
        return result;
    }
    private void permutehelper(List<List<Integer>> result, List<Integer> item, int[] num, boolean[] used){
    	if(item.size() == num.length){
    		ArrayList<Integer> newitem = new ArrayList<Integer>(item);
    		result.add(newitem);
    		return;
    	}
    	int lastremove=num[0];
    	boolean haslastremove = false;
    	
    	for(int i=0;i<num.length;i++){
    		if(!used[i]){
    			if(!haslastremove || (haslastremove && num[i]!=lastremove)){
    				item.add(num[i]);
        			used[i] = true;
        			permutehelper(result, item, num, used);
        			used[i] = false;
        			item.remove(item.size()-1);
        			lastremove = num[i];
        			haslastremove = true;
    			}
    		}
    	}
    }
}
