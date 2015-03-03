package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    
	    ArrayList<Integer> item = new ArrayList<Integer>();
	    
	    Arrays.sort(candidates);
	    permutehelper(result, item, candidates, target);
	    
	    return result;
	}
	private void permutehelper(List<List<Integer>> result, List<Integer> item, int[] candidates, int target){
		if(target == 0){
			ArrayList<Integer> newitem = new ArrayList<Integer>(item);
			result.add(newitem);
			return;
		}
		if (target < 0){
			return;
		}
		
		for(int i=0;i<candidates.length;i++){
			if(item.size() == 0 || candidates[i] >= item.get(item.size()-1)){
				item.add(candidates[i]);
				permutehelper(result, item, candidates, target-candidates[i]);
				item.remove(item.size()-1);
			}
		}
	}
}
