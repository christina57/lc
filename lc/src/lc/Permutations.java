package lc;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        permutehelper(result, item, num);
        
        return result;
    }
    private void permutehelper(List<List<Integer>> result, List<Integer> item, int[] num){
    	if(item.size() == num.length){
    		ArrayList<Integer> newitem = new ArrayList<Integer>(item);
    		result.add(newitem);
    		return;
    	}
    	for(int i=0;i<num.length;i++){
    		if(!item.contains(num[i])){
    			item.add(num[i]);
    			permutehelper(result, item, num);
    			item.remove(item.size()-1);
    		}
    	}
    }
}
