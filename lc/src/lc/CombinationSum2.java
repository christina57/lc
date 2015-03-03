package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    
	    ArrayList<Integer> item = new ArrayList<Integer>();
	    boolean[] used = new boolean[num.length];
        for(int i=0;i<num.length;i++){
        	used[i] = false;
        }
        
	    Arrays.sort(num);
	    permutehelper(result, item, num, used, target, 0);
	    
	    return result;      
    }
    
	private void permutehelper(List<List<Integer>> result, List<Integer> item, int[] num, boolean[] used, int target, int pos){
		if(target == 0){
			ArrayList<Integer> newitem = new ArrayList<Integer>(item);
			result.add(newitem);
			return;
		}
		if (target < 0 ){
			return;
		}
		
		for(int i=pos;i<num.length;i++){
			if(i==0 || num[i] > num[i-1] || (num[i] == num[i-1] && used[i-1])){
				item.add(num[i]);
				used[i] = true;
				permutehelper(result, item, num, used, target-num[i], i+1);
				item.remove(item.size()-1);
				used[i] = false;
			}
			
		}
	}
}
