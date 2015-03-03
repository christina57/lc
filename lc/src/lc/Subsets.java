package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        Arrays.sort(S);
        permutehelper(result, item, S);
        
        return result;
    }
    private void permutehelper(List<List<Integer>> result, List<Integer> item, int[] S){
    	
    	ArrayList<Integer> newitem = new ArrayList<Integer>(item);
		result.add(newitem);
	
    	for(int i=0;i<S.length;i++){
    		if(item.size() == 0 || S[i]>item.get(item.size()-1)){
    			item.add(S[i]);
    			permutehelper(result, item, S);
    			item.remove(item.size()-1);
    		}
    	}
    }
}
