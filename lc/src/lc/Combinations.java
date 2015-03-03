package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> combine(int n, int k) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    
	    ArrayList<Integer> item = new ArrayList<Integer>();
	    
	    permutehelper(result, item, n, k);
	    
	    return result;
	}
	private void permutehelper(List<List<Integer>> result, List<Integer> item, int n, int k){
		if(item.size() == k){
			ArrayList<Integer> newitem = new ArrayList<Integer>(item);
			result.add(newitem);
			return;
		}
	
		
		int last = 0;
		if(item.size() != 0) {
			last = item.get(item.size()-1);
		}
		
		for(int i=last+1;i<=n;i++){
			item.add(i);
			permutehelper(result, item, n, k);
			item.remove(item.size()-1);
		}
	}
}
